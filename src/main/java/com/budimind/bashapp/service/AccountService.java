package com.budimind.bashapp.service;

import com.budimind.bashapp.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    Account getAccountById(String id);
    Account getByContext();
}
