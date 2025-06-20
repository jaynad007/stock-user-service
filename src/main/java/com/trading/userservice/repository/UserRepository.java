package com.trading.userservice.repository;

import com.trading.userservice.models.repo.UserDTO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserDTO, String> {

}
