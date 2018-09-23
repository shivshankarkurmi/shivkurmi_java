package com.ubs.assignment;

import java.io.*;
import java.util.Map;
/*
 * This is just Test class for initial level Testing, for Test cases please check class : ClientTest
 *
 * @auther-shiv kurmi
 * @since-1.0
 */
public class Main {
    public static void main(String[] args) {
        ClassLoader classLoader = Main.class.getClassLoader();
        Map<Object, Integer> inputMap = AccountUtils.parseCSV(classLoader.getResource("ubs assignment/Input_StartOfDay_Positions.csv").getPath().replaceAll("%20", " "), true);
        JsonArray jsonArray = new JsonArray();
        try {
            Object[] jsonTransactions= jsonArray.getJsonArray(classLoader.getResource("ubs assignment/1537277231233_Input_Transactions.txt").getPath().replaceAll("%20", " "));
            for(Object jsonObject : jsonTransactions){
                JsonObject jsonTransaction = ((JsonObject)jsonObject);
                Transaction transaction = TransactionFactory.getTransaction(jsonTransaction.get(ConstantUtils.TRANSACTION_TYPE_STR).toString(), jsonTransaction);
                TransactionExecuter executer = new TransactionExecuter(transaction);
                executer.execute();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Object object : AccountUtils.getAccounts().keySet()){
            System.out.print(((Account)object).toString());
        }
    }
}
