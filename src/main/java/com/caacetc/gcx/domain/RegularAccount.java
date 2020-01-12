package com.caacetc.gcx.domain;

import com.caacetc.gcx.domain.enums.RecordType;

import java.math.BigDecimal;

public class RegularAccount extends Account {

    @Override
    public BigDecimal profitBy(int month) {
        return incomingBy(month).subtract(spendingBy(month));
    }

    @Override
    public BigDecimal incomingBy(int month) {
        return caculateBy(month, RecordType.Incoming);
    }

    @Override
    public BigDecimal spendingBy(int month) {
        return caculateBy(month, RecordType.Spending);
    }

    public void showAllRecords() {
        for (AccountRecord record : accountRecords) {
            System.out.println(record);
        }
    }

    private BigDecimal caculateBy(int month, RecordType type) {
        return accountRecords.stream()
                .filter(record -> record.getRecordTime().getMonthValue() == month)
                .filter(record -> record.getRecordType().equals(type))
                .map(AccountRecord::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

