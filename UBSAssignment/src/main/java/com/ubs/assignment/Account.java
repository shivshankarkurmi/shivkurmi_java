package com.ubs.assignment;

public class Account {
    private String instrument;
    private int account;
    private String accountType;
    private int quantity;
    private int delta;

    public Account(String instrument, int account, String accountType, int quantity) {
        this.instrument = instrument;
        this.account = account;
        this.accountType = accountType;
        this.quantity=quantity;
    }

    public Account(String instrument, int account, String accountType) {
        this.instrument = instrument;
        this.account = account;
        this.accountType = accountType;;
    }

    public String getInstrument() {
        return instrument;
    }

    public int getAccount() {
        return account;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    @Override
    public int hashCode(){
        return instrument.hashCode()+account+accountType.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        Account account = (Account)obj;
     if(this.instrument.equals(account.instrument) && this.account == account.account && this.accountType.equals(account.accountType)){
         return true;
     }
     return false;
    }
    @Override
    public String toString(){
        return instrument+ ","+account+","+accountType+","+quantity+","+delta +"\n";
    }
}
