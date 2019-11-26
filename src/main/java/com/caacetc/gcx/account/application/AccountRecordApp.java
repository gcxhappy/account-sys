package com.caacetc.gcx.account.application;

import com.caacetc.gcx.account.domain.Account;
import com.caacetc.gcx.account.domain.AccountRecord;
import com.caacetc.gcx.account.domain.AccountRecordMapper;
import com.caacetc.gcx.account.domain.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRecordApp extends Account {
    @Autowired
    AccountRecordMapper mapper;

    public List<AccountRecord> queryAllRecords() {
        return mapper.queryAllRecords();
    }

    public void addRecord(AccountRecord record){
        mapper.addRecord(record);
    }

    private  BigDecimal calBy(int month, AccountType type){
        return mapper.queryAllRecords().stream()
                .filter(record -> record.getRecordTime().getMonthValue() == month)
                .filter(record -> record.getAccountType() == type)
                .map(AccountRecord::getAmount)
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }

    @Override
    public BigDecimal profitBy(int month) {
        return incomingBy(month).subtract(spendingBy(month));
    }

    @Override
    public BigDecimal incomingBy(int month) {
        return calBy(month, AccountType.Incoming);
    }

    @Override
    public BigDecimal spendingBy(int month) {
        return calBy(month, AccountType.Spending);
    }
}
