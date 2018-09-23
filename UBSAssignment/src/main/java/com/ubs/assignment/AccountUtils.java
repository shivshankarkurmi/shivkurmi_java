package com.ubs.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AccountUtils {

    private static Map<Object, Integer> map = new LinkedHashMap<Object, Integer>();

    private static Map<Object, Integer> startOfDayMap = new LinkedHashMap<Object, Integer>();
    public static Map<Object, Integer> parseCSV(String path, boolean isHeaderPresent) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (isHeaderPresent) {
                    isHeaderPresent = false;
                } else {
                    Account account = mapToAccount(parseLine(line, ","));
                    startOfDayMap.put(account, account.getQuantity());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.putAll(startOfDayMap);
        return map;
    }

    private static String[] parseLine(String line, String sep) {
        return line.split(sep);
    }

    private static Account mapToAccount(String[] values) {
        return new Account(values[0].trim(), Integer.parseInt(values[1].trim()), values[2].trim(), Integer.parseInt(values[3].trim()));
    }

    public static  Map<Object, Integer> getAccounts(){
        return map;
     }

    public static  Map<Object, Integer> getStartDayAccounts(){
        return startOfDayMap;
    }
    public static void calculateDelta(){
        for(Object account : map.keySet()){
            ((Account)account).setDelta(map.get(account)-startOfDayMap.get(account));
            ((Account)account).setQuantity(map.get(account));
        }
    }
}
