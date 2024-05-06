package co.simplon.gael.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="persons")
//@IdClass(PersonnePK.class)
public class Person {
    
    @Id
    @Column(name= "firstname")
    private String firstname;
    
    @Column(name="lastname")
    private String lastname;
    
    @Column(name="address")
    private String address;
    
    @Column(name="city")
    private String city;
    
    @Column(name="zip")
    private String zip;
    
    @Column(name="phone")
    private String phone;
    
    @Column(name="email")
    private String email;
    
    public Person() {
	
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
	return "{firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", city=" + city
		+ ", zip=" + zip + ", phone=" + phone + ", email=" + email + "}";
    }
    
    
}
