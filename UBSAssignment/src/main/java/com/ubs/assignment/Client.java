package com.ubs.assignment;
import com.ubs.assignment.AccountUtils;
import com.ubs.assignment.Main;

import java.io.IOException;
import java.util.Map;
/*
 * This is Entry point class to parse and send Transactions to TransactionExecuter
 *
 * @auther-shiv kurmi
 * @since- 1.0
 */
public class Client {
    private Map<Object, Integer> inputMap;
    private Object[] jsonTransactions;

    public Client() {
        ClassLoader classLoader = Main.class.getClassLoader();
        JsonArray jsonArray = new JsonArray();
        inputMap = AccountUtils.parseCSV(classLoader.getResource(ConstantUtils.INPUT_FILE_PATH).getPath().replaceAll("%20", " "), true);
        try {
            jsonTransactions = jsonArray.getJsonArray(classLoader.getResource(ConstantUtils.TRASACTIONS_FILE_PATH).getPath().replaceAll("%20", " "));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
     * this method used to  inject transactions into  executer
     */
    public void send(Transaction transaction) {
        TransactionExecuter executer = new TransactionExecuter(transaction);
        executer.execute();
    }

    public Object[] getTransactions() {
        return jsonTransactions;
    }
}
