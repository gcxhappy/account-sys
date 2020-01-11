package com.caacetc.gcx.application;

import com.caacetc.gcx.application.message.AccountRecordResponse;
import com.caacetc.gcx.application.message.AmountResponse;
import com.caacetc.gcx.domain.AccountRecordService;
import com.caacetc.gcx.domain.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author: ganchangxin
 * @create: 2020-01-11 08:05
 **/
@Service
public class AccountAppService {
    private final String MONTH_ERROR_MSG = "！！！The value of month is illegal！！！";
    @Autowired
    private AccountRecordService accountRecordService;

    public AmountResponse incomingBy(int year, int month) throws ApplicationException {
        if (month > 12 || month < 1) {
            throw new ApplicationException(MONTH_ERROR_MSG);
        }
        BigDecimal income = accountRecordService.queryAllRecords().stream()
                .map(AccountRecordResponse::from)
                .filter(accord -> accord.getRecordTime().getYear() == year)
                .filter(accord -> accord.getRecordTime().getMonthValue() == month)
                .filter(accord -> accord.getAccountType() == AccountType.Incoming)
                .map(AccountRecordResponse::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new AmountResponse(year, month, income);
    }

    public AmountResponse spendingBy(int year, int month) throws ApplicationException {
        if (month > 12 || month < 1) {
            throw new ApplicationException(MONTH_ERROR_MSG);
        }
        BigDecimal spending = accountRecordService.queryAllRecords().stream()
                .map(AccountRecordResponse::from)
                .filter(accord -> accord.getRecordTime().getYear() == year)
                .filter(accord -> accord.getRecordTime().getMonthValue() == month)
                .filter(accord -> accord.getAccountType() == AccountType.Spending)
                .map(AccountRecordResponse::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new AmountResponse(year, month, spending);
    }

    public AmountResponse profitBy(int year, int month) throws ApplicationException {
        if (month > 12 || month < 1) {
            throw new ApplicationException(MONTH_ERROR_MSG);
        }
        return incomingBy(year, month).subtract(spendingBy(year, month));
    }
}
