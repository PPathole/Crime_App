package com.pranaypathole.democrime;

public class User {

    public String nameuser,emailuser,passworduser,addressuser,phonenumber;

    public User(String emailuser, String passworduser, String nameuser, String addressuser, String phonenumber){
        this.nameuser = nameuser;
        this.emailuser = emailuser;
        this.passworduser = passworduser;
        this.addressuser = addressuser;
        this.phonenumber = phonenumber;
    }

    User(){

    }
}
