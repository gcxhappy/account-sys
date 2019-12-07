package com.caacetc.gcx.controller;

import com.caacetc.gcx.application.AccountRecordApplicationService;
import com.caacetc.gcx.application.ApplicationException;
import com.caacetc.gcx.application.message.AccountRecordResponse;
import com.caacetc.gcx.application.message.CreatingAccountRecordRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/accountRecord")
public class AccountRecordController {
    @Autowired
    private AccountRecordApplicationService applicationService;

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ApiOperation("列出所有账户的记录")
    @ResponseBody
    public List<AccountRecordResponse> queryAll() {
        return applicationService.queryAllRecords();
    }

    @RequestMapping(value = "/addRecord", method = RequestMethod.POST)
    @ApiOperation("增加一条记录")
    public ResponseEntity addRecord(@RequestBody CreatingAccountRecordRequest record) {
        applicationService.addRecord(record);
        return new ResponseEntity<>("Insert Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/queryIncome/year/{year}/month/{month}", method = RequestMethod.GET)
    @ApiOperation("按月份查询收入")
    public ResponseEntity queryIncomeBy(@ApiParam("年份") @PathVariable int year, @ApiParam("月份") @PathVariable int month, Model model) {
        BigDecimal result = null;
        try {
            result = applicationService.incomingBy(year, month);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/querySpend/year/{year}/month/{month}", method = RequestMethod.GET)
    @ApiOperation("按月份查询支出")
    public ResponseEntity querySpendBy(@ApiParam("年份") @PathVariable int year, @ApiParam("月份") @PathVariable int month) {
        BigDecimal result = null;
        try {
            result = applicationService.spendingBy(year, month);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/queryProfit/year/{year}/month/{month}", method = RequestMethod.GET)
    @ApiOperation("按月份查询收益")
    public ResponseEntity queryProfitBy(@ApiParam("年份") @PathVariable int year, @ApiParam("月份") @PathVariable int month) {
        BigDecimal result = null;
        try {
            result = applicationService.profitBy(year, month);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
