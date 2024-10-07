package com.stanchik.bankbackend.repository;

import com.stanchik.bankbackend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
