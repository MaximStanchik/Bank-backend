package com.stanchik.bankbackend.repository;

import com.stanchik.bankbackend.model.Account;
import org.springframework.data.repository.CrudRepository;
public interface AccountRepository extends CrudRepository<Account, Long> {
}
