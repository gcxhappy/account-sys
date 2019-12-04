package com.caacetc.gcx.domain;

import java.math.BigDecimal;

public class RegularAccount extends Account {

    @Override
    public BigDecimal profitBy(int month) {
        return incomingBy(month).subtract(spendingBy(month));
    }

    @Override
    public BigDecimal incomingBy(int month) {
        return caculateBy(month, AccountType.Incoming);
    }

    @Override
    public BigDecimal spendingBy(int month) {
        return caculateBy(month, AccountType.Spending);
    }

    public void showAllRecords() {
        for (AccountRecord record : accountRecords) {
            System.out.println(record);
        }
    }

    private BigDecimal caculateBy(int month, AccountType type) {
        return accountRecords.stream()
                .filter(record -> record.getRecordTime().getMonthValue() == month)
                .filter(record -> record.getAccountType() == type)
                .map(AccountRecord::getAmount)
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }
}

