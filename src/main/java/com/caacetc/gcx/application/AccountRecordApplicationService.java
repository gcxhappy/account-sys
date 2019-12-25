package com.caacetc.gcx.application;

import com.caacetc.gcx.application.message.AccountRecordResponse;
import com.caacetc.gcx.application.message.CreatingAccountRecordRequest;
import com.caacetc.gcx.domain.AccountRecordService;
import com.caacetc.gcx.domain.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountRecordApplicationService {
    @Autowired
    private AccountRecordService accountRecordService;

    private final String MONTH_ERROR_MSG = "！！！The value of month is illegal！！！";

    public List<AccountRecordResponse> queryAllRecords() {
        return accountRecordService.queryAllRecords().stream()
                .map(AccountRecordResponse::from)
                .collect(Collectors.toList());
    }

    public void addRecord(CreatingAccountRecordRequest record) {
        accountRecordService.addRecord(record.to());
    }

    public BigDecimal incomingBy(int year, int month) throws ApplicationException {
        if (month > 12 || month < 1) {
            throw new ApplicationException(MONTH_ERROR_MSG);
        }
        return accountRecordService.queryAllRecords().stream()
                .map(AccountRecordResponse::from)
                .filter(accord -> accord.getRecordTime().getYear() == year)
                .filter(accord -> accord.getRecordTime().getMonthValue() == month)
                .filter(accord -> accord.getAccountType() == AccountType.Incoming)
                .map(AccountRecordResponse::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal spendingBy(int year, int month) throws ApplicationException {
        if (month > 12 || month < 1) {
            throw new ApplicationException(MONTH_ERROR_MSG);
        }
        return accountRecordService.queryAllRecords().stream()
                .map(AccountRecordResponse::from)
                .filter(accord -> accord.getRecordTime().getYear() == year)
                .filter(accord -> accord.getRecordTime().getMonthValue() == month)
                .filter(accord -> accord.getAccountType() == AccountType.Spending)
                .map(AccountRecordResponse::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal profitBy(int year, int month) throws ApplicationException {
        if (month > 12 || month < 1) {
            throw new ApplicationException(MONTH_ERROR_MSG);
        }
        return incomingBy(year, month).subtract(spendingBy(year, month));
    }
}
