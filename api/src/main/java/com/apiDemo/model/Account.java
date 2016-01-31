package com.apiDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by p.bell on 25.01.2016.
 */
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sessionId;
    private String iban;
    private String businessIdentifierCode;

    public Account(){}

    public Account(String iban,String businessIdentifierCode){
        this.iban=iban;
        this.businessIdentifierCode=businessIdentifierCode;
    }

    public Account(String sessionId,String iban,String businessIdentifierCode){
        this.sessionId=sessionId;
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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
