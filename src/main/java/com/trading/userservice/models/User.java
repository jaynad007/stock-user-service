package com.trading.userservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class User {

    private String firstName;
    private String lastName;
    private Integer age;
    private String address;
    private String mobile;
    private String email;
    private String occupation;
    @JsonIgnore
    private String password;
    private String userName;
    private String riskProfile;


    public User(String riskProfile, String userName, String occupation, String email, String mobile, String address, Integer age, String lastName, String firstName) {
        this.riskProfile = riskProfile;
        this.userName = userName;
        this.occupation = occupation;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRiskProfile() {
        return riskProfile;
    }

    public void setRiskProfile(String riskProfile) {
        this.riskProfile = riskProfile;
    }


}
