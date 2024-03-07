package com.budimind.bashapp.dto.response;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserResponse {
    private String username;
    private String name;
    private String email;
    private List<String> role;
}
