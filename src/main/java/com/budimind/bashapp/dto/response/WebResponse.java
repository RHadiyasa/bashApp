package com.budimind.bashapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebResponse<T>{
    private T data;
    private Integer statusCode;
    private String errors;
    private String message;
}
