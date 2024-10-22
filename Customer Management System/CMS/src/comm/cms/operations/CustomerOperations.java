package comm.cms.operations;

import comm.cms.core.ServicePlan;
import comm.cms.custom_exception.CustomerValidationException;

import java.time.LocalDate;

public interface CustomerOperations {
    String signUp(String firstname, String lastname, String email, String password, double registrationAmount, String dob, String plan) throws CustomerValidationException;

    void signIn(String email, String password) throws CustomerValidationException;

    void changePassword(String email, String oldPass, String newPass) throws CustomerValidationException;

    void unSubscribeCustomer(String email) throws CustomerValidationException;

    void displayAllCustomer();
}
