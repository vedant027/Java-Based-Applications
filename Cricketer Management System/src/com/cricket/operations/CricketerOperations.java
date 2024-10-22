package com.cricket.operations;

import com.cricket.core.Cricket;
import com.cricket.exception.CricketerException;

import java.util.Map;

public interface CricketerOperations {
    void addCricketer(String name,int age,String email_id,String phone,double rating) throws CricketerException;

    void modifyRating(String email_id, double rating) throws CricketerException;

    void displayCricketers() throws CricketerException;

    void searchByName(String name) throws CricketerException;

    void sortByRating() throws CricketerException;


}
