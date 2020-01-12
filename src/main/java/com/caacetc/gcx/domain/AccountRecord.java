package com.caacetc.gcx.domain;


import com.caacetc.gcx.domain.enums.RecordType;
import com.caacetc.gcx.domain.enums.ContentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AccountRecord {
    private Integer id;
    private String accountName;
    private RecordType recordType;
    private ContentType contentType;
    private String note;
    private BigDecimal amount;
    private LocalDateTime recordTime;

    public AccountRecord(String accountName, RecordType recordType, ContentType contentType, String note, BigDecimal amount, LocalDateTime recordTime) {
        this.accountName = accountName;
        this.recordType = recordType;
        this.contentType = contentType;
        this.note = note;
        this.amount = amount;
        this.recordTime = recordTime;
    }
}
