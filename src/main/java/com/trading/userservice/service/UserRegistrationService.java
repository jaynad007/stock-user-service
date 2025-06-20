package com.trading.userservice.service;

import com.trading.userservice.models.User;
import com.trading.userservice.models.repo.AddressDTO;
import com.trading.userservice.models.repo.UserAuthDTO;
import com.trading.userservice.models.repo.UserDTO;
import com.trading.userservice.repository.AddressRepository;
import com.trading.userservice.repository.UserAuthRepository;
import com.trading.userservice.repository.UserRepository;
import com.trading.userservice.util.EncodingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserRegistrationService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserAuthRepository authRepo;

    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private ConversionUtil util;

    @Autowired
    private TransactionalOperator txOperator;


    public Mono<User> registerUser(User userObj) {
        User userEncoded = EncodingUtil.encodePwd(userObj);
        UserDTO userDTO = util.convertUserToUserDTO(userEncoded);
        UserAuthDTO authDTO = util.convertUserToUserAuth(userEncoded);
        AddressDTO addDTO = util.convertUserToAddressDTO(userEncoded);

        return txOperator.transactional(
                userRepo.save(userDTO)
                        .then(authRepo.save(authDTO))
                        .then(addressRepo.save(addDTO))
                        .thenReturn(userEncoded)
        );
    }

}
