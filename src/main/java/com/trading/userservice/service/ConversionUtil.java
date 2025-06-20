package com.trading.userservice.service;

import com.trading.userservice.models.User;
import com.trading.userservice.models.repo.AddressDTO;
import com.trading.userservice.models.repo.UserAuthDTO;
import com.trading.userservice.models.repo.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class ConversionUtil {

    public UserDTO convertUserToUserDTO(User userObj) {
        UserDTO userDTOObj = new UserDTO();
        userDTOObj.setAge(userObj.getAge());
        userDTOObj.setUserName(userObj.getUserName());
        userDTOObj.setEmail(userObj.getEmail());
        userDTOObj.setFirstName(userObj.getFirstName());
        userDTOObj.setLastName(userObj.getLastName());
        userDTOObj.setMobile(userObj.getMobile());
        userDTOObj.setRiskProfile(userObj.getRiskProfile());
        userDTOObj.setOccupation(userObj.getOccupation());
        return userDTOObj;
    }

    public UserAuthDTO convertUserToUserAuth(User userObj) {
        UserAuthDTO authDTO = new UserAuthDTO();
        authDTO.setFirstName(userObj.getFirstName());
        authDTO.setLastName(userObj.getLastName());
        authDTO.setState(userObj.getState());
        authDTO.setPassword(userObj.getPassword());
        authDTO.setUserName(userObj.getUserName());
        return authDTO;
    }

    public AddressDTO convertUserToAddressDTO(User userObj) {
        AddressDTO addDto = new AddressDTO();
        addDto.setAddressLine1(userObj.getAddressLine1());
        addDto.setAddressLine2(userObj.getAddressLine2());
        addDto.setAddressLine3(userObj.getAddressLine3());
        addDto.setCity(userObj.getCity());
        addDto.setCountry(userObj.getCountry());
        addDto.setCounty(userObj.getCounty());
        addDto.setUserId(userObj.getUserName());
        addDto.setState(userObj.getState());
        return addDto;

    }


}
