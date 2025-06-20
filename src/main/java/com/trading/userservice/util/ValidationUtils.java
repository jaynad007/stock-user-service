package com.trading.userservice.util;

import com.trading.userservice.models.ErrorObject;
import com.trading.userservice.models.RiskProfile;
import com.trading.userservice.models.User;
import com.trading.userservice.models.repo.UserDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static com.trading.userservice.constants.ErrorConstants.*;


public class ValidationUtils {


    public static ErrorObject validateUserObject(User userObj) {
        ErrorObject error = new ErrorObject();
        List<String> errorList = new ArrayList<>();
        verifyBlankOrEmptyField(userObj.getFirstName(), "First Name", errorList);
        verifyBlankOrEmptyField(userObj.getLastName(), "Last Name", errorList);
        //verifyBlankOrEmptyField(userObj.getAddress(), "Address", errorList);
        verifyBlankOrEmptyField(userObj.getMobile(), "Mobile Number", errorList);
        verifyBlankOrEmptyField(userObj.getEmail(), "Email", errorList);
        verifyBlankOrEmptyField(userObj.getPassword(), "Password", errorList);
        verifyRiskProfile(userObj.getRiskProfile(), errorList);
        if (userObj.getAge() == null || userObj.getAge() < 18 || userObj.getAge() > 100) {
            errorList.add(AGE_ERROR);
        }
        // We can add regex later.
        if(!CollectionUtils.isEmpty(errorList)){
            error.setErrorMessage(errorList);
            error.setErrorCode(VALIDATION_ERROR_CODE);
        }

        return error;
    }

    private static void verifyBlankOrEmptyField(String field, String fieldName, List<String> errorList) {
        if (StringUtils.isBlank(field)) {
            errorList.add(fieldName + BLANK_EMPTY_FIELDS);
        }
    }

    private static void verifyRiskProfile(String profile, List<String> errorList) {
        try {
            if(StringUtils.isEmpty(profile)){
                errorList.add(INVALID_RISK_PROFILE + profile);
            }
            RiskProfile riskProfile = RiskProfile.valueOf(profile.toUpperCase());
        } catch (IllegalArgumentException e) {
            errorList.add(INVALID_RISK_PROFILE + profile);
        }
    }

    public static Mono<ServerResponse> generateErrorServerResponse(ErrorObject err){
        return ServerResponse
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(err);
    }

    public static Mono<ServerResponse> generateInternalErrorServerResponse(ErrorObject err){
        return ServerResponse
                .status(500)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(err);
    }

}
