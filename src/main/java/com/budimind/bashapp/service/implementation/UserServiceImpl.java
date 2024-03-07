package com.budimind.bashapp.service.implementation;

import com.budimind.bashapp.constant.AccountRole;
import com.budimind.bashapp.dto.request.RegisterUserRequest;
import com.budimind.bashapp.dto.request.UpdateUserRequest;
import com.budimind.bashapp.dto.response.RegisterUserResponse;
import com.budimind.bashapp.entity.Role;
import com.budimind.bashapp.entity.User;
import com.budimind.bashapp.repository.AccountRepository;
import com.budimind.bashapp.repository.UserRepository;
import com.budimind.bashapp.service.RoleService;
import com.budimind.bashapp.service.UserService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
//        Role role = roleService.getOrSave(AccountRole.ROLE_USER);
//        String hashPassword = passwordEncoder.encode(registerUserRequest.getPassword());

        User user = new User();
        user.setUsername(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        user.setEmail(registerUserRequest.getEmail());
        user.setAddress(registerUserRequest.getAddress());
        user.setPhone(registerUserRequest.getPhone());
//        user.setRole(List.of(role));
        user.setActive(true);

        userRepository.save(user);

//        List<String> roles = user.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority).toList();

        return RegisterUserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
//                .role(roles)
                .build();
    }

    @Override
    public RegisterUserResponse updateUser(UpdateUserRequest updateUserRequest) {
        return null;
    }

    @Override
    public RegisterUserResponse findUserById(String id) {
        return null;
    }
}
