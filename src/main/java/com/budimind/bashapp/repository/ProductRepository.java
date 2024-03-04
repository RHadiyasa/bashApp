package com.budimind.bashapp.repository;

import com.budimind.bashapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
}
