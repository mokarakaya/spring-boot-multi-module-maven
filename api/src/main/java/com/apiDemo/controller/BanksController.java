package com.apiDemo.controller;

import com.apiDemo.model.Account;
import com.apiDemo.model.AccountListWrapper;
import com.apiDemo.service.BanksService;
import com.apiDemo.util.UtilConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by p.bell on 26.01.2016.
 * this class consists of rest services for database operations
 */
@RestController
@RequestMapping("/operations")
public class BanksController {

    @Autowired
    private BanksService banksService;

    @RequestMapping(value="/", method = RequestMethod.PUT)
    public void update(@RequestParam(value="index") long index,@RequestParam(value="iban") String iban,
                       @RequestParam(value="businessIdentifierCode") String businessIdentifierCode ,HttpServletRequest request) throws Exception {
        checkSessionId(index, request);
        banksService.update(index,iban,businessIdentifierCode);
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public void create(@RequestParam(value="iban") String iban,
                       @RequestParam(value="businessIdentifierCode") String businessIdentifierCode ,HttpServletRequest request) {
        banksService.create(iban, businessIdentifierCode, request.getRequestedSessionId());
    }

    @RequestMapping(value="/",method = RequestMethod.DELETE)
    public void delete(@RequestParam(value="index") long index,HttpServletRequest request) throws Exception {
        checkSessionId(index,request);
        banksService.delete(index);
    }

    /**
     * checks if the request is from the proper session
     * @param index
     * @param request
     * @throws Exception
     */
    private void checkSessionId(long index, HttpServletRequest request) throws Exception {
        Account account = banksService.get(index);
        if(!account.getSessionId().equals(request.getRequestedSessionId())){
            throw new Exception("invalid session id");
        }
    }
}
