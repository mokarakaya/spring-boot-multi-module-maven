package com.apiDemo.model;

/**
 * Created by p.bell on 25.01.2016.
 */
public class Account {
    private String iban;
    private String businessIdentifierCode;

    public Account(){}

    public Account(String iban,String businessIdentifierCode){
        this.iban=iban;
        this.businessIdentifierCode=businessIdentifierCode;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBusinessIdentifierCode() {
        return businessIdentifierCode;
    }

    public void setBusinessIdentifierCode(String businessIdentifierCode) {
        this.businessIdentifierCode = businessIdentifierCode;
    }
}
