package com.ubs.assignment;
import com.ubs.assignment.AccountUtils;
import com.ubs.assignment.Command;

/*
 * TransactionExecuter helps to process received Transactions from Client.
 *
 * @auther-shiv kurmi
 * @since-1.0
 */
public class TransactionExecuter implements Command {
    private Transaction transaction;
    TransactionExecuter(Transaction transaction){
        this.transaction=transaction;
    }
    public void execute() {
      transaction.process();
      AccountUtils.calculateDelta();
    }
}
