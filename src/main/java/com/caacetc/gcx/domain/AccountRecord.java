package com.caacetc.gcx.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("账户记录实体类")
public class AccountRecord {
    @ApiModelProperty("账户名称")
    private String accountName;
    @ApiModelProperty("记录的类型")
    private AccountType accountType;
    @ApiModelProperty("账户明细的类型")
    private String contentType;
    @ApiModelProperty("账户明细")
    private String note;
    @ApiModelProperty("金额")
    private BigDecimal amount;
    @ApiModelProperty("记录时间")
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
