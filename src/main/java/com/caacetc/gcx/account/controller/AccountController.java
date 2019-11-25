package com.caacetc.gcx.account.controller;

import com.caacetc.gcx.account.application.AccountRecordApp;
import com.caacetc.gcx.account.domain.AccountRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountRecordApp accountRecordApp;

    @GetMapping("/queryAll")
    public List<AccountRecord> queryAll() {
        List<AccountRecord> records = accountRecordApp.queryAllRecords();
        for (AccountRecord record : records) {
            System.out.println(record);
        }
        return records;
    }

    @PostMapping("/addRecord")
    public void addRecord(AccountRecord record){
        accountRecordApp.addRecord(record);
    }

    @PostMapping("/queryIncomeBy")
    public BigDecimal queryIncomeBy(int month){
        return accountRecordApp.incomingBy(month);
    }

    @PostMapping("/querySpendBy")
    public BigDecimal querySpendBy(int month){
        return accountRecordApp.spendingBy(month);
    }

    @PostMapping("/queryProfitBy")
    public BigDecimal queryProfitBy(int month){
        return accountRecordApp.profitBy(month);
    }

}
