package com.caacetc.gcx.controller;

import com.caacetc.gcx.application.AccountRecordAppService;
import com.caacetc.gcx.application.message.AccountRecordResponse;
import com.caacetc.gcx.application.message.CreatingAccountRecordRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/account-records")
public class AccountRecordController {
    @Autowired
    private AccountRecordAppService accountRecordService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation("列出所有账户的记录")
    @ResponseBody
    public ResponseEntity<?> queryAll() {
        List<AccountRecordResponse> accountRecordResponses = accountRecordService.queryAllRecords();
        if (Objects.isNull(accountRecordResponses) || accountRecordResponses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accountRecordResponses, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("增加一条记录")
    public ResponseEntity<?> addRecord(@RequestBody CreatingAccountRecordRequest record) {
        if(Objects.isNull(record)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        accountRecordService.addRecord(record);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
