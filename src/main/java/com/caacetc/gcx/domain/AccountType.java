package com.caacetc.gcx.domain;

public enum AccountType {
    Spending("Spending"),
    Incoming("Incoming");
    private String value;
    AccountType(String value){
        this.value = value;
    }
}
