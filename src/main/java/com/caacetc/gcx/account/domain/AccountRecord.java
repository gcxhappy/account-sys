package com.caacetc.gcx.account.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRecord {
    private String accountName;
    private AccountType accountType;
    private String contentType;
    private String note;
    private BigDecimal amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordTime;

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
