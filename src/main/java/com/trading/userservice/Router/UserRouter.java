package com.trading.userservice.Router;

import com.trading.userservice.handler.UserHandler;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class UserRouter {

@Bean
 public RouterFunction<ServerResponse> userRoutes(UserHandler handler){
    return RouterFunctions.route(POST("/users/register"), handler::handleUserRegistration);
}


}

