package com.caacetc.gcx.application.message;

import com.caacetc.gcx.domain.AccountRecord;
import com.caacetc.gcx.domain.AccountType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: ganchangxin
 * @create: 2019-12-04 21:21
 **/
@Data
@ApiModel("创建账户记录请求类")
public class CreatingAccountRecordRequest {
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
    private LocalDateTime recordTime;

    public AccountRecord to() {
        return new AccountRecord(accountName, accountType, contentType, note, amount, recordTime);
    }
}
