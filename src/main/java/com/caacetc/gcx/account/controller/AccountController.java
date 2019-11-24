package com.caacetc.gcx.account.controller;

import com.caacetc.gcx.account.application.AccountRecordApp;
import com.caacetc.gcx.account.domain.AccountRecord;
import com.caacetc.gcx.account.domain.AccountType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountController {

    private AccountRecordApp accountRecordApp;

    @GetMapping("/qureyAll")
    public List<AccountRecord> qureyAll() {
        return accountRecordApp.qureyAllRecords();
    }

    @PostMapping("/addRecord")
    public void addRecord(AccountRecord record){
        accountRecordApp.addRecord(record);
    }

    @PostMapping("/qureyIncomeBy")
    public BigDecimal qureyIncomeBy(int month){
        return accountRecordApp.incomingBy(month);
    }

    @PostMapping("/qureySpendBy")
    public BigDecimal qureySpendBy(int month){
        return accountRecordApp.spendingBy(month);
    }

    @PostMapping("/qureyProfitBy")
    public BigDecimal qureyProfitBy(int month){
        return accountRecordApp.profitBy(month);
    }

}
