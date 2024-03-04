package com.budimind.bashapp.repository;

import com.budimind.bashapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
