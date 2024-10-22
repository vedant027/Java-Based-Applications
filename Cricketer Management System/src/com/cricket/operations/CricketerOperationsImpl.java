package com.cricket.operations;

import com.cricket.core.Cricket;
import com.cricket.exception.CricketerException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static com.cricket.validations.CricketerValidations.*;

public class CricketerOperationsImpl implements CricketerOperations {
    private Map<String, Cricket> cricketer;

    public CricketerOperationsImpl(){
        cricketer = new HashMap<>();
    }

    @Override
    public void addCricketer(String name, int age, String email_id, String phone, double rating) throws CricketerException {
//        String key = email_id.concat(name);

        validateEmail(email_id,cricketer);
        validateAge(age);
        validatePhone(phone,cricketer);


        cricketer.put(email_id,new Cricket(name, age, email_id, phone, rating));
        System.out.println("Cricketer Added Successfully");
    }

    @Override
    public void modifyRating(String email_id,double rating) throws CricketerException {
            if(cricketer.containsKey(email_id)){
                cricketer.values().stream().filter(s -> s.getEmail_id().equals(email_id)).forEach(s -> s.setRating(rating));
                System.out.println("Rating Modified!!");
            }
            else{
                throw new CricketerException("Invalid Email Id !!");
            }

    }

    @Override
    public void displayCricketers() throws CricketerException {
        cricketer.values().stream().forEach(s -> System.out.println(s));
    }

    @Override
    public void searchByName(String name) throws CricketerException {
        if(cricketer.values().stream().anyMatch(s -> s.getName().equals(name))){
            cricketer.values().stream().filter(s -> s.getName().equals(name)).forEach(s -> System.out.println(s));
        }
        else {
            throw new CricketerException("Name not Found in the Collection!!");
        }
    }

    @Override
    public void sortByRating() throws CricketerException {
        cricketer.values().stream().sorted(Comparator.comparing(Cricket::getRating)).forEach(s -> System.out.println(s));
    }
}
