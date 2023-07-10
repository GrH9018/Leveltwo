package com.example.leveltwo.service;

import com.example.leveltwo.dto.SignupRequestDto;
import com.example.leveltwo.dto.UserRequestDto;
import com.example.leveltwo.entity.User;
import com.example.leveltwo.jwt.JwtUtil;
import com.example.leveltwo.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public void signup(SignupRequestDto signupRequestDto) {
        String username = signupRequestDto.getUsername();
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        Optional<User> overlapUser = userRepository.findByUsername(username);
        if(overlapUser.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }
        User user = new User(username, password);
        userRepository.save(user);


    }

    public void login (UserRequestDto userRequestDto, HttpServletResponse jwtResponse) {
        String username = userRequestDto.getUsername();
        String password = userRequestDto.getPassword();

        User user = userRepository.findByUsername(username).orElseThrow(()
                -> new IllegalArgumentException("등록된 사용자가 없습니다."));

        if (!passwordEncoder.matches(password, user.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // Jwt 생성
        String token = jwtUtil.createToken(user.getUsername());
        jwtResponse.addHeader(JwtUtil.AUTHORIZATION_HEADER, token);


    }
}
