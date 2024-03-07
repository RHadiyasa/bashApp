package com.budimind.bashapp.service.implementation;

import com.budimind.bashapp.constant.AccountRole;
import com.budimind.bashapp.entity.Role;
import com.budimind.bashapp.repository.RoleRepository;
import com.budimind.bashapp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Role getOrSave(AccountRole role){
        return roleRepository.findByRole(role)
                .orElseGet(()-> roleRepository.saveAndFlush(Role.builder().role(role).build()));
    }
}
