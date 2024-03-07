package com.budimind.bashapp.service.implementation;

import com.budimind.bashapp.dto.response.JwtClaims;
import com.budimind.bashapp.entity.Account;
import com.budimind.bashapp.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtServiceImpl implements JwtService {
//    private final String JWT_SECRET;
//    private final String ISSUER;
//    private final long JWT_EXPIRATION;

//    public JwtServiceImpl(@Value("${bash_application.jwt.secret_key}") String jwtSecret,
//                          @Value("${bash_application.jwt.issuer}")String issuer,
//                          @Value("${bash_application.jwt.expirationInSecond}") long jwtExpiration) {
//        JWT_SECRET = jwtSecret;
//        ISSUER = issuer;
//        JWT_EXPIRATION = jwtExpiration;
//    }

    @Override
    public String generateToken(Account account) {
        return null;
    }

    @Override
    public boolean verifyJwtToken(String token) {
        return false;
    }

    @Override
    public JwtClaims getClaimsByToken(String token) {
        return null;
    }
}
