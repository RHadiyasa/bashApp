package com.budimind.bashapp.service;

import com.budimind.bashapp.dto.response.JwtClaims;
import com.budimind.bashapp.entity.Account;

public interface JwtService {
    String generateToken(Account account);

    boolean verifyJwtToken(String token);

    JwtClaims getClaimsByToken(String token);
}
