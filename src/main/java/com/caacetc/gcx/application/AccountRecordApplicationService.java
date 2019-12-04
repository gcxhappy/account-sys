package com.caacetc.gcx.application;

import com.caacetc.gcx.application.message.AccountRecordResponse;
import com.caacetc.gcx.application.message.CreatingAccountRecordRequest;
import com.caacetc.gcx.domain.AccountRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountRecordApplicationService {
    @Autowired
    private AccountRecordService accountRecordService;

    public List<AccountRecordResponse> queryAllRecords() {
        return accountRecordService.queryAllRecords().stream()
                .map(AccountRecordResponse::from)
                .collect(Collectors.toList());
    }

    public void addRecord(CreatingAccountRecordRequest record){
        accountRecordService.addRecord(record.to());
    }

    public BigDecimal incomingBy(int month) {
        return accountRecordService.incomingBy(month);
    }

    public BigDecimal spendingBy(int month) {
        return accountRecordService.spendingBy(month);
    }

    public BigDecimal profitBy(int month) {
        return accountRecordService.profitBy(month);
    }
}
