package comm.cms.core;

import java.time.LocalDate;

public class CustomerRegistration {
    private int customerId;
    private static int idGenerator;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private double registrationAmount;
    private LocalDate dob;
    private ServicePlan plan;

    static {
        idGenerator=1;
    }

    public CustomerRegistration(String firstname, String lastname, String email, String password, double registrationAmount, LocalDate dob, ServicePlan plan) {
        this.customerId=idGenerator++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.registrationAmount = registrationAmount;
        this.dob = dob;
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "CustomerRegistration{" +
                "customerId=" + customerId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registrationAmount=" + registrationAmount +
                ", dob=" + dob +
                ", plan=" + plan +
                '}';
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getRegistrationAmount() {
        return registrationAmount;
    }

    public LocalDate getDob() {
        return dob;
    }

    public ServicePlan getPlan() {
        return plan;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
