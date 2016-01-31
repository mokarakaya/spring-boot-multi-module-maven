package com.webDemo.controller;

import com.apiDemo.controller.BanksController;
import com.apiDemo.model.Account;
import com.apiDemo.model.AccountListWrapper;
import com.apiDemo.service.BanksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by p.bell on 25.01.2016.
 */
@Controller
public class BanksMvcController {

    @Autowired
    private BanksService banksService;

    public static final String ACCOUNT_LIST_WRAPPER="accountListWrapper";
    private static final String INIT_IBAN="initIban";
    private static final String INIT_BUSINESS_IDENTIFER_CODE="initBusinessIdentifierCode";
    private static final String SESSION="session";
    private static final String DATABASE="database";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(HttpSession session,ModelMap model, @RequestParam(value="storageType",required = false) String storageType) {
        AccountListWrapper accountListWrapper=null;
        if(storageType==null || SESSION.equals(storageType)) {
            accountListWrapper = sessionSelected(session, storageType);
        }else if(DATABASE.equals(storageType)){
            accountListWrapper = databaseSelected(session, storageType);
        }
        model.addAttribute(ACCOUNT_LIST_WRAPPER, accountListWrapper);
        return "index";
    }

    private AccountListWrapper databaseSelected(HttpSession session, String storageType) {
        List<Account> accountList = banksService.getBySessionId(session.getId());
        return new AccountListWrapper(accountList,DATABASE);
    }

    private AccountListWrapper sessionSelected(HttpSession session, @RequestParam(value = "storageType", required = false) String storageType) {
        AccountListWrapper accountListWrapper = (AccountListWrapper) session.getAttribute(ACCOUNT_LIST_WRAPPER);
        if(accountListWrapper==null){
            accountListWrapper=  new AccountListWrapper();
            accountListWrapper.add(new Account(INIT_IBAN, INIT_BUSINESS_IDENTIFER_CODE));
            accountListWrapper.setStorageType(SESSION);
        }
        accountListWrapper.setStorageType(storageType);
        session.setAttribute(ACCOUNT_LIST_WRAPPER, accountListWrapper);
        return accountListWrapper;
    }
}
