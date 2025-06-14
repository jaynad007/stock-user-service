package com.trading.userservice.handler;

import com.trading.userservice.models.ErrorObject;
import com.trading.userservice.models.User;
import com.trading.userservice.util.ValidationUtils;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class UserHandler {


    public Mono<ServerResponse> handleUserRegistration(ServerRequest request) {

       /* return request.bodyToMono(User.class).flatMap(userObj -> {

            ErrorObject error = ValidationUtils.validateUserObject(userObj);

            if (StringUtils.isNotBlank(error.getErrorCode())) {
                return ValidationUtils.generateErrorServerResponse(error);
            }

            return Mono.just(userObj);
        }).doOnNext(user -> {



        });*/


        return null;
    }



}
