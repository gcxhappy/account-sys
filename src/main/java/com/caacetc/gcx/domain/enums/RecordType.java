package com.caacetc.gcx.domain.enums;

public enum RecordType {
    Spending("Spending"),
    Incoming("Incoming");
    private String value;
    RecordType(String value){
        this.value = value;
    }
}
