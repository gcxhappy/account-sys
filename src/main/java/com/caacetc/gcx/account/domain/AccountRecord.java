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
    private String Note;
    private BigDecimal Amount;
    private LocalDate RecordingTime;

    @Override
    public String toString() {
        return "AccountRecord{" +
                "accountName=" + accountName +
                ", accountType=" + accountType +
                ", contentType='" + contentType + '\'' +
                ", Note='" + Note + '\'' +
                ", Amount=" + Amount +
                ", RecordingTime=" + RecordingTime +
                '}';
    }
}
