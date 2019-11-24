package com.caacetc.gcx.account.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRecord {
    private String accountName;
    private AccountType accountType;
    private String contentType;
    private String note;
    private BigDecimal amount;
    private LocalDate recordTime;

    @Override
    public String toString() {
        return "AccountRecord{" +
                "accountName=" + accountName +
                ", accountType=" + accountType +
                ", contentType='" + contentType + '\'' +
                ", Note='" + note + '\'' +
                ", Amount=" + amount +
                ", RecordingTime=" + recordTime +
                '}';
    }
}
