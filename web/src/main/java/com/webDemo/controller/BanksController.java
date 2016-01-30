package com.apiDemo.controller;

import com.apiDemo.model.Account;
import com.apiDemo.model.AccountListWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by p.bell on 25.01.2016.
 */
@Controller
public class BanksController {

    public static final String ACCOUNT_LIST_WRAPPER="accountListWrapper";
    private static final String INIT_IBAN="initIban";
    private static final String INIT_BUSINESS_IDENTIFER_CODE="initBusinessIdentifierCode";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(HttpSession session,ModelMap model) {
        AccountListWrapper accountListWrapper = (AccountListWrapper) session.getAttribute(ACCOUNT_LIST_WRAPPER);
        if(accountListWrapper==null){
            accountListWrapper=  new AccountListWrapper();
            accountListWrapper.add(new Account(INIT_IBAN, INIT_BUSINESS_IDENTIFER_CODE));
        }
        session.setAttribute(ACCOUNT_LIST_WRAPPER, accountListWrapper);
        model.addAttribute(ACCOUNT_LIST_WRAPPER,accountListWrapper);
        return "hello";
    }
}
