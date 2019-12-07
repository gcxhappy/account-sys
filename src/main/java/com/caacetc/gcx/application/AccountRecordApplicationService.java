package com.caacetc.gcx.application;

import com.caacetc.gcx.application.message.AccountRecordResponse;
import com.caacetc.gcx.application.message.CreatingAccountRecordRequest;
import com.caacetc.gcx.domain.AccountRecordService;
import com.caacetc.gcx.domain.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BinaryOperator;
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

    public void addRecord(CreatingAccountRecordRequest record) {
        accountRecordService.addRecord(record.to());
    }

    public BigDecimal incomingBy(int year, int month) throws ApplicationException {
        if(month > 12 || month < 1){
            throw new ApplicationException("The value of Month is illegal");
        }
        return accountRecordService.queryAllRecords().stream()
                .map(AccountRecordResponse::from)
                .filter(accord -> accord.getRecordTime().getYear() == year)
                .filter(accord -> accord.getRecordTime().getMonthValue() == month)
                .filter(accord -> accord.getAccountType() == AccountType.Incoming)
                .map(AccountRecordResponse::getAmount)
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }

    public BigDecimal spendingBy(int year, int month) throws ApplicationException {
        if(month > 12 || month < 1){
            throw new ApplicationException("The value of Month is illegal");
        }
        return accountRecordService.queryAllRecords().stream()
                .map(AccountRecordResponse::from)
                .filter(accord -> accord.getRecordTime().getYear() == year)
                .filter(accord -> accord.getRecordTime().getMonthValue() == month)
                .filter(accord -> accord.getAccountType() == AccountType.Spending)
                .map(AccountRecordResponse::getAmount)
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }

    public BigDecimal profitBy(int year, int month) throws ApplicationException {
        if(month > 12 || month < 1){
            throw new ApplicationException("The value of Month is illegal");
        }
        return accountRecordService.queryAllRecords().stream()
                .map(AccountRecordResponse::from)
                .filter(accord -> accord.getRecordTime().getYear() == year)
                .filter(accord -> accord.getRecordTime().getMonthValue() == month)
                .map(AccountRecordResponse::getAmount)
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }
}
