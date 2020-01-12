package com.caacetc.gcx.domain.enums;

/**
 * @author: ganchangxin
 * @create: 2020-01-12 16:46
 **/
public enum ContentType {
    PAY_MEAL("have a meal"),
    PAY_TRAFFIC("traffic"),
    PAY_CLOTH("buy clothes"),
    PAY_PHONE_BILL("telephone bill"),
    INCOME_SALARY("salary");

    private String value;

    ContentType(String value) {
        this.value = value;
    }
    }
