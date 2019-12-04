package com.caacetc.gcx.controller;

import com.caacetc.gcx.application.AccountRecordApplicationService;
import com.caacetc.gcx.application.message.AccountRecordResponse;
import com.caacetc.gcx.application.message.CreatingAccountRecordRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/accountRecord")
public class AccountController {
    @Autowired
    private AccountRecordApplicationService applicationService;

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ApiOperation("列出所有账户的记录")
    public List<AccountRecordResponse> queryAll() {
        return applicationService.queryAllRecords();
    }

    @PostMapping("/addRecord")
    @ApiOperation("增加一条记录")
    public void addRecord(CreatingAccountRecordRequest record){
        applicationService.addRecord(record);
    }

    @PostMapping("/queryIncomeBy")
    @ApiOperation("按月份查询收入")
    public BigDecimal queryIncomeBy(@ApiParam("月份") int month){
        return applicationService.incomingBy(month);
    }

    @PostMapping("/querySpendBy")
    @ApiOperation("按月份查询支出")
    public BigDecimal querySpendBy(@ApiParam("月份") int month){
        return applicationService.spendingBy(month);
    }

    @PostMapping("/queryProfitBy")
    @ApiOperation("按月份查询收益")
    public BigDecimal queryProfitBy(@ApiParam("月份") int month){
        return applicationService.profitBy(month);
    }

}
