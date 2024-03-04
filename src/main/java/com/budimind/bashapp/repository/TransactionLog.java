package com.budimind.bashapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionLog extends JpaRepository<TransactionLog, String> {
}
