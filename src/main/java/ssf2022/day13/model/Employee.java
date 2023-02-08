package ssf2022.day13.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Employee {
    
    @NotEmpty(message = "First name is a mandary field.")
    @Size(min = 2, max = 150, message = "First name must be between 2 to 150 characters.")
    private String firstName;

    @NotEmpty(message = "Laast name is a mandatory field.")
    @Size(min = 2, max = 150, message = "Last name must be between 2 to 150 characters.")
    private String lastName;

    @Email(message = "Invalid email format.")
    @Size(max = 120)
    @Pattern(regexp = ".+@.+\\..+", message = "Wrong email format.")
    @NotBlank(message = "Email is a mandary field.")
    private String email;


    // following regexp is to ensure the phone number starts with 8 or 9, then following 7 digits are btw 0-9.
    @Pattern(regexp = "(\\8|9)[0-9]{7}", message = "Invalid phone format.")
    private String phoneNo;

    @Min(value = 1500, message = "Min salary is 1500.")
    @Max(value = 40000, message = "Max salary is 40000.")
    private Integer salary;

    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    @PastOrPresent(message = "Birth date cannot be greater than today.")
    private Date birthday;

    private String address;

    @Digits(fraction = 0, integer =6, message ="Postal code format, i.e. 123456")
    private Integer postalCode;
    
    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String phoneNo, Integer salary, Date birthday,
            String address, Integer postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.salary = salary;
        this.birthday = birthday;
        this.address = address;
        this.postalCode = postalCode;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    
    @Override
    public String toString() {

        return "Firstname: " + firstName + "lastname: " +lastName+ ", email: " + email + ", phone number:" + phoneNo
        + ", salary: " + salary + ", birthday: " + birthday + " address: " + address + ", postal code: " + postalCode;
    }

}
