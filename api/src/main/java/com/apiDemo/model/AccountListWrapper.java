package com.apiDemo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p.bell on 25.01.2016.
 */
public class AccountListWrapper {
    private List<Account> accountList;
    private String storageType;

    public AccountListWrapper(){
        accountList=new ArrayList<>();
    }

    public AccountListWrapper(List<Account> accountList,String storageType){
        this.accountList=accountList;
        this.storageType=storageType;
    }
    public void add(Account account){
        this.accountList.add(account);
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }
}
