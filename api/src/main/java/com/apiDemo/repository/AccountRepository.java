package com.apiDemo.repository;

import com.apiDemo.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by p.bell on 31.01.2016.
 */
@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {

    @Query("select a from Account a where sessionId=?")
    public List<Account> getBySessionId(String sessionId);
}
