package com.budimind.bashapp.repository;

import com.budimind.bashapp.entity.Transaction;
import com.budimind.bashapp.entity.TransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionLogRepository extends JpaRepository<TransactionLog, String> {
}
