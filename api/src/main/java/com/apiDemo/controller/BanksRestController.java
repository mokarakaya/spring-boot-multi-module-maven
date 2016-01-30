package com.apiDemo.controller;

import com.apiDemo.model.Account;
import com.apiDemo.model.AccountListWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by p.bell on 26.01.2016.
 */
@RestController
@RequestMapping("/operations")
public class BanksRestController {
    public static final String ACCOUNT_LIST_WRAPPER="accountListWrapper";
    @RequestMapping(value="/", method = RequestMethod.PUT)
    public void update(@RequestParam(value="index") int index,@RequestParam(value="iban") String iban,
                       @RequestParam(value="businessIdentifierCode") String businessIdentifierCode ,HttpServletRequest request) {
        AccountListWrapper accountListWrapper = (AccountListWrapper) request.getSession().getAttribute(ACCOUNT_LIST_WRAPPER);
        accountListWrapper.getAccountList().set(index, new Account(iban, businessIdentifierCode));
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public void create(@RequestParam(value="iban") String iban,
                       @RequestParam(value="businessIdentifierCode") String businessIdentifierCode ,HttpServletRequest request) {
        AccountListWrapper accountListWrapper = (AccountListWrapper) request.getSession().getAttribute(ACCOUNT_LIST_WRAPPER);
        accountListWrapper.getAccountList().add(new Account(iban, businessIdentifierCode));
    }

    @RequestMapping(value="/",method = RequestMethod.DELETE)
    public void delete(@RequestParam(value="index") int index,HttpServletRequest request) {
        AccountListWrapper accountListWrapper = (AccountListWrapper) request.getSession().getAttribute(ACCOUNT_LIST_WRAPPER);
        accountListWrapper.getAccountList().remove(index);
    }
}
