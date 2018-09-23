package com.usb.assignment;

import com.ubs.assignment.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ClientTest {

    Client client = null;
    BufferedReader br = null;

    @Before
    public void setup() {
        client = new Client();
        ClassLoader classLoader = Client.class.getClassLoader();
        String path = classLoader.getResource(ConstantUtils.OUTPUT_FILE_PATH).getPath().replaceAll("%20", " ");
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSend() throws IOException {
        for (Object jsonObject : client.getTransactions()) {
            JsonObject jsonTransaction = ((JsonObject) jsonObject);
            //TransactionFactory gives the BTransaction or STransaction type objects as per input of CommonUtils.TRANSACTION_TYPE_STR
            //CommonUtils.TRANSACTION_TYPE_STR can be "B" or "S"
            Transaction transaction = TransactionFactory.getTransaction(jsonTransaction.get(ConstantUtils.TRANSACTION_TYPE_STR).toString(), jsonTransaction);
            client.send(transaction);
        }
        String actualString = "";

        //forming actualString with processed Transactions
        for (Object object : AccountUtils.getAccounts().keySet()) {
            Account actualAccount = (Account) object;
            actualString += actualAccount.toString();
        }
        String expectedLine = null;
        String expectedString = "";
        boolean isHeader = true;

        //forming expetedString from expected output file :Expected_EndOfDay_Positions.csv
        while ((expectedLine = br.readLine()) != null) {
            if (isHeader) {
                isHeader = false;
            } else {
                expectedString += expectedLine + "\n";
            }
        }
        System.out.println("======================================");
        System.out.println("Actual  Calculated ");
        System.out.println("======================================");
        System.out.println(actualString);
        System.out.println("======================================");
        System.out.println("Expected ");
        System.out.println("======================================");
        System.out.println(expectedString);

        //Asserting expected and actual output
        Assert.assertTrue(actualString.equals(expectedString));
    }
}
