package com.trading.userservice.models.repo;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("stockmonkey.users")
public class UserDTO {
    @Id
    private Long id;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("age")
    private Integer age;
    @Column("mobile")
    private String mobile;
    @Column("email")
    private String email;
    @Column("occupation")
    private String occupation;
    @Column("user_name")
    private String userName;
    @Column("risk_profile")
    private String riskProfile;


    public UserDTO(String riskProfile, String userName, String occupation, String email, String mobile, String address, Integer age, String lastName, String firstName) {
        this.riskProfile = riskProfile;
        this.userName = userName;
        this.occupation = occupation;
        this.email = email;
        this.mobile = mobile;
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public UserDTO() {

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
