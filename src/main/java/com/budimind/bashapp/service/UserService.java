package com.budimind.bashapp.service;

import com.budimind.bashapp.dto.request.RegisterUserRequest;
import com.budimind.bashapp.dto.request.UpdateUserRequest;
import com.budimind.bashapp.dto.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse findUserById(String id);
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    RegisterUserResponse updateUser(UpdateUserRequest updateUserRequest);

}
