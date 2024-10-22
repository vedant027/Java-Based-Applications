package com.cricket.tester;

import com.cricket.operations.CricketerOperations;
import com.cricket.operations.CricketerOperationsImpl;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CricketerTest {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            CricketerOperations ops = new CricketerOperationsImpl();
            boolean exit = false;
            while(!exit){
                System.out.println("Options 1.Add Cricketer 2.Display Cricketers 3.Modify Rating 4.Search By Name 5.Sort Cricketers By Rating 0.Exit\n");
                System.out.print("Choose Options: ");
                try{
                    switch(sc.nextInt()){
                        case 1:
                            System.out.println("Enter Cricketer Details: name, age, email_id, phone, rating");
                            ops.addCricketer(sc.next(),sc.nextInt(),sc.next(),sc.next(),sc.nextDouble());
                            break;
                        case 2:
                            ops.displayCricketers();
                            break;
                        case 3:
                            System.out.println("Enter Email_id & New Rating");
                            ops.modifyRating(sc.next(),sc.nextDouble());
                            break;
                        case 4:
                            System.out.println("Enter Name of Cricketer");
                            ops.searchByName(sc.next());
                            break;
                        case 5:
                            ops.sortByRating();
                            break;
                        case 0:
                            exit=true;
                            break;
                    }
                } catch(Exception e){
                    System.out.println(e);
                    sc.nextLine();
                }
            }
        }
    }
}
