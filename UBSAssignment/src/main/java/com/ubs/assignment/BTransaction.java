package com.ubs.assignment;
import com.ubs.assignment.AbstractTransaction;
import com.ubs.assignment.AccountUtils;

public class BTransaction extends AbstractTransaction {

    public BTransaction(){

    }

    @Override
    public void process() {
     processExternalAccount(new Account(this.instrument,ConstantUtils.ACCOUNT_101,ConstantUtils.ACCOUNT_TYPE_E));
     processInternalAccount(new Account(this.instrument,ConstantUtils.ACCOUNT_201,ConstantUtils.ACCOUNT_TYPE_I));
    }
    @Override
    public void processExternalAccount(Account account){
        AccountUtils.getAccounts().put(account,AccountUtils.getAccounts().get(account)+this.transactionQuantity);
    }

    @Override
    public void processInternalAccount(Account account){
        AccountUtils.getAccounts().put(account,AccountUtils.getAccounts().get(account)-this.transactionQuantity);
    }
}
