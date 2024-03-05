package com.budimind.bashapp.repository;

import com.budimind.bashapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.expression.spel.ast.OpAnd;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
