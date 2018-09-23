package com.ubs.assignment;
import com.ubs.assignment.AbstractTransaction;
import com.ubs.assignment.JsonObject;

public class TransactionFactory {

    public static Transaction getTransaction(String transactionType, JsonObject jsonObject) {
        AbstractTransaction transaction = null;
        if (transactionType.equalsIgnoreCase("B")) {
            transaction = new BTransaction();
            transaction.transactionId=jsonObject.get("TransactionId").toString();
            transaction.transactionType = jsonObject.get("TransactionType").toString();
            transaction.instrument=jsonObject.get("Instrument").toString();
            transaction.transactionQuantity=Integer.valueOf(jsonObject.get("TransactionQuantity").toString());

        } else if (transactionType.equalsIgnoreCase("S")) {
            transaction = new STransaction();
            transaction.transactionId=jsonObject.get("TransactionId").toString();
            transaction.transactionType = jsonObject.get("TransactionType").toString();
            transaction.instrument=jsonObject.get("Instrument").toString();
            transaction.transactionQuantity=Integer.valueOf(jsonObject.get("TransactionQuantity").toString());
        }
      return transaction;
    }
}
