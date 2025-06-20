package com.trading.userservice.util;

import com.trading.userservice.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodingUtil {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static User encodePwd(User userObj) {
        String pwd = userObj.getPassword();
        userObj.setPassword(encoder.encode(pwd));
        return userObj;

    }


}
