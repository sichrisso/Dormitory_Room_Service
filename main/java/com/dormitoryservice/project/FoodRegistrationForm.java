// package com.dormitoryservice.project.Security;

// import org.springframework.security.crypto.password.PasswordEncoder;

// import lombok.Data;

// @Data
// public class FoodRegistrationForm {
//     private String userName;
//     private String foodPassword;
//     private String foodPlace;
//     private String address;
//     private String email;
//     private String contact;
//     private String delivery;

//     Food toFood(PasswordEncoder encoder) {
//         Food Food = new Food();
//         food.setUserName(this.userName);
//         food.setfoodPassword(encoder.encode(this.foodPassword));
//         food.setfoodPlace(this.foodPlace);
//         food.setaddress(this.address);
//         food.setemail(this.email);
//         food.setcontact(this.contact);
//         food.setdelivery(this.delivery);
//         return food;
//     }
// }


