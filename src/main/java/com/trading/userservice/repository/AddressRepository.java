package com.trading.userservice.repository;

import com.trading.userservice.models.repo.AddressDTO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ReactiveCrudRepository<AddressDTO, String> {
}
