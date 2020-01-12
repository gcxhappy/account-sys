package com.caacetc.gcx.domain;

import com.caacetc.gcx.domain.enums.RecordType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public abstract class Account {
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
                .filter(record -> record.getRecordType() == RecordType.Incoming)
                .collect(Collectors.toList());
    }

    public List<AccountRecord> getAllSpendingRecords() {
        return accountRecords.stream()
                .filter(record -> record.getRecordType() == RecordType.Spending)
                .collect(Collectors.toList());
    }

    public List<AccountRecord> getRecordsBy(int month) {
        return accountRecords.stream()
                .filter(record -> record.getRecordTime().getMonthValue() == month)
                .collect(Collectors.toList());
    }

}
