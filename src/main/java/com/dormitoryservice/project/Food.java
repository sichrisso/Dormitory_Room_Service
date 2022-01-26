package com.dormitoryservice.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.springframework.security.crypto.password.PasswordEncoder;

  
@Entity
@Table(name = "FoodService")
public class Food{
        
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "foodPassword")
    private String foodPassword;
    
    @Column(name = "foodPlace")
    private String foodPlace;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private Integer contact;

    @Column(name = "delivery")
    private String delivery;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getFoodPassword() {
        return foodPassword;
    }
    public void setFoodPassword(String foodPassword) {
        this.foodPassword = foodPassword;
    }
    
    public String getFoodPlace() {
        return foodPlace;
    }
    public void setFoodPlace(String foodPlace) {
        this.foodPlace = foodPlace;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getContact() {
        return contact;
    }
    public void setContact(Integer contact) {
        this.contact = contact;
    }
    public String getDelivery() {
        return delivery;
    }
    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
   
    
}
    
