package com.caacetc.gcx.account.domain;

public enum AccountType {
    Spending("Spending"),
    Incoming("Incoming");
    private String value;
    AccountType(String value){
        this.value = value;
    }
}
