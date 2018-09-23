package com.ubs.assignment;

public abstract class AbstractTransaction implements Transaction {
    public String transactionId;
    public String transactionType;
    public String instrument;
    public int transactionQuantity;

    public void process() {

    }

    public void processExternalAccount(Account account) {

    }

    public void processInternalAccount(Account account) {

    }
}
