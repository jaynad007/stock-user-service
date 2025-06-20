package com.trading.userservice.handler;

import com.trading.userservice.models.ErrorObject;
import com.trading.userservice.models.User;
import com.trading.userservice.models.repo.AddressDTO;
import com.trading.userservice.models.repo.UserAuthDTO;
import com.trading.userservice.models.repo.UserDTO;
import com.trading.userservice.repository.AddressRepository;
import com.trading.userservice.repository.UserAuthRepository;
import com.trading.userservice.repository.UserRepository;
import com.trading.userservice.service.ConversionUtil;
import com.trading.userservice.service.UserRegistrationService;
import com.trading.userservice.util.EncodingUtil;
import com.trading.userservice.util.ValidationUtils;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.trading.userservice.constants.ErrorConstants.UNEXPECTED_ERROR_CODE;
import static com.trading.userservice.constants.ErrorConstants.UNEXPECTED_ERROR_MESSAGE;

@Service
public class UserHandler {

    @Autowired
    private UserRegistrationService registrationService;

    public Mono<ServerResponse> handleUserRegistration(ServerRequest request) {
        return request.bodyToMono(User.class)
                .flatMap(userObj -> {
                    ErrorObject error = ValidationUtils.validateUserObject(userObj);
                    if (StringUtils.isNotBlank(error.getErrorCode())) {
                        return ValidationUtils.generateErrorServerResponse(error);
                    }
                    return registrationService.registerUser(userObj).flatMap(user->{
                        return ServerResponse.status(200).bodyValue(user);
                    });

                }).onErrorResume(e -> {
                    ErrorObject error = new ErrorObject();
                    error.setErrorCode(UNEXPECTED_ERROR_CODE);
                    error.setErrorMessage(List.of(UNEXPECTED_ERROR_MESSAGE));
                    return ValidationUtils.generateInternalErrorServerResponse(error);
                });

    }


}
