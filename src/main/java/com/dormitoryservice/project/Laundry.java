package com.dormitoryservice.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

  
@Entity
@Table(name = "LaundryService")
public class Laundry {
        
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

    @Column(name = "luserName")
    private String luserName;

    @Column(name = "laundaryPassword")
    private String laundryPassword;
    
    @Column(name = "lauAddress")
    private String lauAddress;
    
    @Column(name = "lauContact")
    private Integer lauContact;

    @Column(name = "minPrice")
    private Integer minPrice;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
    public String getLuserName() {
        return luserName;
    }
    public void setLuserName(String luserName) {
        this.luserName = luserName;
    }
    
    public String getLaundryPassword() {
        return laundryPassword;
    }
    public void setLaundryPassword(String laundryPassword) {
        this.laundryPassword = laundryPassword;
    }
    public String getLauAddress() {
        return lauAddress;
    }
    public void setLauAddress(String lauAddress) {
        this.lauAddress = lauAddress;
    }
   
    public Integer getLauContact() {
        return lauContact;
    }
    public void setLauContact(Integer lauContact) {
        this.lauContact = lauContact;
    }
    public Integer getMinPrice() {
        return minPrice;
    }
    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }
    
}
    
