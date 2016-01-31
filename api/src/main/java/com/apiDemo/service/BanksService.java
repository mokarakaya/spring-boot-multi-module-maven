package com.apiDemo.service;

import com.apiDemo.model.Account;
import com.apiDemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by p.bell on 31.01.2016.
 */
@Service
public class BanksService {

    @Autowired
    private AccountRepository accountRepository;

    public Account get(long index){
        return accountRepository.findOne(index);
    }

    public List<Account> getBySessionId(String sessionId) {
        return accountRepository.getBySessionId(sessionId);
    }

    public void update(long index,String iban, String businessIdentifierCode) {
        Account account = accountRepository.findOne(index);
        account.setBusinessIdentifierCode(businessIdentifierCode);
        account.setIban(iban);
        accountRepository.save(account);
    }

    public void create(String iban, String businessIdentifierCode ,String sessionId) {
        Account account = new Account(sessionId,iban,businessIdentifierCode);
        accountRepository.save(account);
    }

    public void delete(long index) {
        accountRepository.delete(index);
    }
}
