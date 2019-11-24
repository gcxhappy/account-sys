package com.accaetc.gcx.account.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Account {
    protected String accoutName;
    protected List<AccountRecord> accountRecords = new ArrayList<>();

    public void addOneRecord(AccountRecord record) {
        accountRecords.add(record);
    }

    public void addRecords(List<AccountRecord> records) {
        accountRecords.addAll(records);
    }

    public abstract BigDecimal profitBy(int month);

    public abstract BigDecimal incomingBy(int month);

    public abstract BigDecimal spendingBy(int month);

    public List<AccountRecord> getAllIncomingRecords() {
        return accountRecords.stream()
                .filter(record -> record.getAccountType() == AccountType.Incoming)
                .collect(Collectors.toList());
    }

    public List<AccountRecord> getAllSpendingRecords() {
        return accountRecords.stream()
                .filter(record -> record.getAccountType() == AccountType.Spending)
                .collect(Collectors.toList());
    }

    public List<AccountRecord> getRecordsBy(int month) {
        return accountRecords.stream()
                .filter(record -> record.getRecordingTime().getMonthValue() == month)
                .collect(Collectors.toList());
    }

}
