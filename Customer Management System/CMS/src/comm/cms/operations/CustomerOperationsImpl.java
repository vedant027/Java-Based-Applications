package comm.cms.operations;

import comm.cms.core.CustomerRegistration;
import comm.cms.core.ServicePlan;
import comm.cms.custom_exception.CustomerValidationException;

import static comm.cms.validations.CustomerValidation.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CustomerOperationsImpl implements CustomerOperations {

    private Map<String, CustomerRegistration> customer;

    public CustomerOperationsImpl(){
        customer = new HashMap<>();
    }

    @Override
    public String signUp(String firstname, String lastname, String email, String password, double registrationAmount, String dob, String plan) throws CustomerValidationException {

        checkForDuplicates(email,customer);
        ServicePlan servicePlan = validatePlan(plan);
        validateRegularAmount(servicePlan,registrationAmount);
        LocalDate dateOfBirth = LocalDate.parse(dob);
        String validEmail = validateEmail(email);

        CustomerRegistration cust = new CustomerRegistration(firstname,lastname,validEmail,password,registrationAmount,dateOfBirth,servicePlan);
        customer.put(email, cust);
        System.out.println(cust);
        return "Customer Successfully Registered!!";
    }

    public CustomerRegistration getEmailbyCustomer(String email){
        CustomerRegistration c = customer.get(email);
        if(c==null)
            System.out.println("Invalid EmailId!!");
        return c;
    }


    @Override
    public void signIn(String email, String password) throws CustomerValidationException {
        CustomerRegistration c = getEmailbyCustomer(email);
        if(c.getPassword().equals(password)) {
            System.out.println("Successfully LoggedIn!!");
        }
        else {
            throw new CustomerValidationException("Incorrect Password!!");
        }
    }

    @Override
    public void changePassword(String email, String oldPass, String newPass) throws CustomerValidationException {
        CustomerRegistration c = getEmailbyCustomer(email);
        if(c.getPassword().equals(oldPass)){
            c.setPassword(newPass);
            System.out.println("Password Successfully Updated!!");
        }
        else {
            throw new CustomerValidationException("Incorrect Old Password!!");
        }
    }

    @Override
    public void unSubscribeCustomer(String email) throws CustomerValidationException {
       String validEmail = validateEmail(email);
        CustomerRegistration cust = customer.remove(validEmail);
        if(cust != null){
            System.out.println("Successfully Removed Customer");
        }
        else {
            System.out.println("No Customer Found!!");
        }
    }

    @Override
    public void displayAllCustomer() {
        for(CustomerRegistration c : customer.values())
            System.out.println(c);
    }

}
