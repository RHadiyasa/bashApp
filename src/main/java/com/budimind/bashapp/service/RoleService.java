package com.budimind.bashapp.service;

import com.budimind.bashapp.constant.AccountRole;
import com.budimind.bashapp.entity.Role;

public interface RoleService {
    Role getOrSave(AccountRole accountRole);
}
