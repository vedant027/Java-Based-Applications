package com.cricket.validations;

import com.cricket.core.Cricket;
import com.cricket.exception.CricketerException;

import java.util.Map;

public class CricketerValidations {
    private static int MIN_AGE=18;

    public static void validateEmail(String email, Map<String,Cricket> cricketer)throws CricketerException{

        if(!email.matches("^[a-zA-z0-9]+@[a-z]+\\.(com|net|org)")){
            throw new CricketerException("Invalid Email-Id");
        }
//^[a-zA-z0-9]+@[a-z]+\\.(com|net|org)
        if(cricketer.values().stream().anyMatch(c -> c.getEmail_id().equals(email))){
            throw new CricketerException("Email Already Exists!!");
        }
    }

    public static void validateAge(int age) throws CricketerException{
        if(age < MIN_AGE){
            throw new CricketerException("Invalid Age");
        }
    }

    public static void validatePhone(String phone, Map<String,Cricket> cricketer) throws CricketerException{
        if(phone.length() != 10 && !phone.matches("\\n{0,9}"))
            throw new CricketerException("Invalid Phone Number!!");

        if(cricketer.values().stream().anyMatch(c -> c.getPhone().equals(phone)))
            throw new CricketerException("Phone Number Already exists");
    }

}
