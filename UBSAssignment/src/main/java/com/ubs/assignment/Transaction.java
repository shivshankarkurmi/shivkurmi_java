package com.ubs.assignment;

import com.ubs.assignment.Account;

/*
 * Transaction is a generic interface which can be implemented by all kind of transactions like :STransaction or BTransaction
 *
 * @auther-shiv kurmi
 * @since-1.0
 */
public interface Transaction {
    void process();
    void processExternalAccount( Account account);
    void processInternalAccount( Account account);
}
