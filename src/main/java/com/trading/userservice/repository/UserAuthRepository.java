package com.trading.userservice.repository;

import com.trading.userservice.models.repo.UserAuthDTO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends ReactiveCrudRepository<UserAuthDTO, String> {
}
