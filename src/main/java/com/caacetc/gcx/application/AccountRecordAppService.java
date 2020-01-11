package com.caacetc.gcx.application;

import com.caacetc.gcx.application.message.AccountRecordResponse;
import com.caacetc.gcx.application.message.AmountResponse;
import com.caacetc.gcx.application.message.CreatingAccountRecordRequest;
import com.caacetc.gcx.domain.AccountRecordService;
import com.caacetc.gcx.domain.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountRecordAppService {
    @Autowired
    private AccountRecordService accountRecordService;

    public List<AccountRecordResponse> queryAllRecords() {
        return accountRecordService.queryAllRecords().stream()
                .map(AccountRecordResponse::from)
                .collect(Collectors.toList());
    }

    public void addRecord(CreatingAccountRecordRequest record) {
        accountRecordService.addRecord(record.to());
    }

}
