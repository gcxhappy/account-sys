package com.caacetc.gcx.controller;

import com.caacetc.gcx.application.AccountAppService;
import com.caacetc.gcx.application.ApplicationException;
import com.caacetc.gcx.application.message.AmountResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: ganchangxin
 * @create: 2020-01-11 08:07
 **/

@Controller
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountAppService accountService;

    @RequestMapping(value = "/income/year/{year}/month/{month}", method = RequestMethod.GET)
    @ApiOperation("按月份查询收入")
    @ResponseBody
    public ResponseEntity<?> queryIncomeBy(@ApiParam("年份") @PathVariable int year, @ApiParam("月份") @PathVariable int month) {
        try {
            AmountResponse result = accountService.incomingBy(year, month);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/spending/year/{year}/month/{month}", method = RequestMethod.GET)
    @ApiOperation("按月份查询支出")
    @ResponseBody
    public ResponseEntity<?> querySpendingBy(@ApiParam("年份") @PathVariable int year, @ApiParam("月份") @PathVariable int month) {
        try {
            AmountResponse result = accountService.spendingBy(year, month);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/profit/year/{year}/month/{month}", method = RequestMethod.GET)
    @ApiOperation("按月份查询收益")
    @ResponseBody
    public ResponseEntity<?> queryProfitBy(@ApiParam("年份") @PathVariable int year, @ApiParam("月份") @PathVariable int month) {
        try {
            AmountResponse result = accountService.profitBy(year, month);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ApplicationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
