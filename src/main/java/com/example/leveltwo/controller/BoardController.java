package com.example.leveltwo.controller;

import com.example.leveltwo.dto.BoardRequestDto;
import com.example.leveltwo.dto.BoardResponseDto;
import com.example.leveltwo.jwt.JwtUtil;
import com.example.leveltwo.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;
    private final JwtUtil jwtUtil;

    // 게시글 작성
    @PostMapping("/boards")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto, HttpServletRequest req) {
        String token = auth(req);
        return boardService.createBoard(requestDto, token);
    }

    // 전체 게시글 조회
    @GetMapping("/boards")
    public List<BoardResponseDto> getBoards() {
        return boardService.getBoards();
    }

    //  선택 게시글 조회
    @GetMapping("/boards/{id}")
    public BoardResponseDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    // 선택 게시글 수정
    @PutMapping("/boards/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto, HttpServletRequest req) {
        String token = auth(req);
        return boardService.updateBoard(id, requestDto, token);
    }

    // 선택 게시글 삭제
    @DeleteMapping("/boards/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long id, HttpServletRequest req) {
        String token = auth(req);
        boardService.deleteBoard(id, token);
        return ResponseEntity.ok()
                .body("게시글 삭제 성공");
    }


    private String auth(HttpServletRequest req) {
        String tokenValue = req.getHeader(JwtUtil.AUTHORIZATION_HEADER);

        String token = jwtUtil.substringToken(tokenValue);
        if(!jwtUtil.validateToken(token)) {
            throw new IllegalArgumentException("토큰 에러");
        }

        return token;
    }

}