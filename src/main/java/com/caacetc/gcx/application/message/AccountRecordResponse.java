package com.caacetc.gcx.application.message;

import com.caacetc.gcx.domain.AccountRecord;
import com.caacetc.gcx.domain.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: ganchangxin
 * @create: 2019-12-04 21:19
 **/
@Data
@AllArgsConstructor
public class AccountRecordResponse {
    private String accountName;
    private AccountType accountType;
    private String contentType;
    private String note;
    private BigDecimal amount;
    private LocalDateTime recordTime;

    public static AccountRecordResponse from(AccountRecord record){
        return new AccountRecordResponse(record.getAccountName(), record.getAccountType(),record.getContentType(),record.getNote(),record.getAmount(),record.getRecordTime());
    }
}
