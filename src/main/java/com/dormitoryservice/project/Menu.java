package com.dormitoryservice.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

  
@Entity
@Data
@Table(name = "Menu")
public class Menu {
        
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "food")
	private String food;

	@Column(name = "price")
	private Integer price;
    
	private long foodId;
}
    
