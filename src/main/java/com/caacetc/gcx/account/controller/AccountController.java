package com.caacetc.gcx.account.controller;

import com.caacetc.gcx.account.application.AccountRecordApp;
import com.caacetc.gcx.account.domain.AccountRecord;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation("列出所有账户的记录")
    public List<AccountRecord> queryAll() {
        List<AccountRecord> records = accountRecordApp.queryAllRecords();
        for (AccountRecord record : records) {
            System.out.println(record);
        }
        return records;
    }

    @PostMapping("/addRecord")
    @ApiOperation("增加一条记录")
    public void addRecord(AccountRecord record){
        accountRecordApp.addRecord(record);
    }

    @PostMapping("/queryIncomeBy")
    @ApiOperation("按月份查询收入")
    public BigDecimal queryIncomeBy(@ApiParam("月份") int month){
        return accountRecordApp.incomingBy(month);
    }

    @PostMapping("/querySpendBy")
    @ApiOperation("按月份查询支出")
    public BigDecimal querySpendBy(@ApiParam("月份") int month){
        return accountRecordApp.spendingBy(month);
    }

    @PostMapping("/queryProfitBy")
    @ApiOperation("按月份查询收益")
    public BigDecimal queryProfitBy(@ApiParam("月份") int month){
        return accountRecordApp.profitBy(month);
    }

}
