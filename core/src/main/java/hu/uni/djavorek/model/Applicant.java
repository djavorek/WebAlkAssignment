package hu.uni.djavorek.model;

import hu.uni.djavorek.model.exception.InvalidEmailAddressException;
import org.apache.commons.validator.routines.EmailValidator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Applicant {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phonenumber;

    protected Applicant() {}

    public Applicant(String firstname, String lastname, String email, String phonenumber) {
        setFirstname(firstname);
        setLastname(lastname);
        setEmail(email);
        setPhonenumber(phonenumber);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(!EmailValidator.getInstance().isValid(email)) {
            throw new InvalidEmailAddressException("The given email address is not valid: " + email);
        }

        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
