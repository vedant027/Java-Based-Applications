package comm.cms.validations;

import comm.cms.core.CustomerRegistration;
import comm.cms.core.ServicePlan;
import comm.cms.custom_exception.CustomerValidationException;

import java.util.Map;

public class CustomerValidation {

    public static void checkForDuplicates(String email, Map<String, CustomerRegistration> custEmail)throws CustomerValidationException{
        if(custEmail.containsKey(email))
            throw new CustomerValidationException("Customer with the same EmailId already exists!!");
    }

    public static ServicePlan validatePlan(String plan){
        return ServicePlan.valueOf(plan.toUpperCase());
    }

    public static void validateRegularAmount(ServicePlan plan,double charges) throws CustomerValidationException{
        if(charges!=plan.getCharges())
            throw new CustomerValidationException("Provided Amount doesn't match with the service plan!!");
    }

    public static String validateEmail(String email) throws CustomerValidationException{
        if(!email.contains("@")){
            throw new CustomerValidationException("Invalid Email!!");
        }
        if(!(email.endsWith(".com") || email.endsWith(".net") || email.endsWith(".org"))){
            throw new CustomerValidationException("Invalid Email!!");
        }
        return email;
    }
}
