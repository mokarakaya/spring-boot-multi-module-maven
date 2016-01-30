package com.apiDemo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p.bell on 25.01.2016.
 */
public class AccountListWrapper {
    private List<Account> accountList;

    public AccountListWrapper(){
        accountList=new ArrayList<>();
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
}
