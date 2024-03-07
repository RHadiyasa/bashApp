package com.budimind.bashapp.controller;

import com.budimind.bashapp.constant.ResponseMessage;
import com.budimind.bashapp.dto.request.RegisterUserRequest;
import com.budimind.bashapp.dto.response.RegisterUserResponse;
import com.budimind.bashapp.dto.response.WebResponse;
import com.budimind.bashapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;

    @PostMapping(path = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        RegisterUserResponse registerUser = userService.registerUser(registerUserRequest);

        WebResponse<RegisterUserResponse> webResponse = WebResponse.<RegisterUserResponse>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message(ResponseMessage.SUCCESS_SAVE_DATA)
                .data(registerUser)
                .build();

        return WebResponse.<RegisterUserResponse>builder().data(registerUser).build();
    }
}
