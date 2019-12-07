package com.caacetc.gcx.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LocalDateTime recordTime;
}
