package com.sparta.meme_nameking.controller;

import com.sparta.meme_nameking.dto.LoginRequestDto;
import com.sparta.meme_nameking.dto.ResponseMsgDto;
import com.sparta.meme_nameking.dto.SignupRequestDto;
import com.sparta.meme_nameking.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Tag(name = "userController", description = "회원가입/로그인 API")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입 API", description = "회원가입")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "회원 가입 완료")})
    //회원가입
    @PostMapping(value = "/signup")
    public ResponseMsgDto signup(@Valid @RequestBody SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto);
    }

    @Operation(summary = "로그인 API", description = "로그인 성공시 jwt 토큰을 헤더에 넣어 반환합니다.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "로그인 완료")})
    //로그인
    @PostMapping("/login")
    public ResponseMsgDto login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response){
        return userService.login(loginRequestDto, response);
    }
}
