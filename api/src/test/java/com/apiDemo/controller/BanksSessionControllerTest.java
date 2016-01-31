package com.apiDemo.controller;

import com.apiDemo.ApiApplication;
import com.apiDemo.model.Account;
import com.apiDemo.model.AccountListWrapper;
import com.apiDemo.util.UtilConstants;
import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;

/**
 * Created by p.bell on 31.01.2016.
 */

public class BanksSessionControllerTest extends TestCase {


    private BanksSessionController banksSessionController;

    private HttpSession mockedSession;


    public void setUp() throws Exception {
        banksSessionController=new BanksSessionController();
        List<Account> accountList= new ArrayList<>();
        accountList.add(0, new Account("1", "test"));
        AccountListWrapper accountListWrapper=new AccountListWrapper();
        accountListWrapper.setAccountList(accountList);
        mockedSession = createNiceMock(HttpSession.class);
        expect(mockedSession.getAttribute(UtilConstants.ACCOUNT_LIST_WRAPPER)).andReturn(accountListWrapper);
        EasyMock.replay(mockedSession);
    }



    @Test
    public void testAddData() {
        banksSessionController.create("2","test2",mockedSession);
    }

    @Test
    public void testUpdate() {
        banksSessionController.update(0,"2","test2",mockedSession);
    }

    @Test
    public void testDeleteData() throws Exception {
        banksSessionController.delete(0,mockedSession);
    }

}