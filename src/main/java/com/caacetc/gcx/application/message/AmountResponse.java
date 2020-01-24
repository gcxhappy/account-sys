package com.caacetc.gcx.application.message;

import com.caacetc.gcx.application.ApplicationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: ganchangxin
 * @create: 2020-01-11 07:57
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AmountResponse {
    private int year;
    private int month;
    private BigDecimal amount;

    public AmountResponse subtract(AmountResponse amountResponse) throws ApplicationException {
        if(this.year != amountResponse.year || this.month != amountResponse.month){
            throw new ApplicationException("!!!substract month not same!!!");
        }

        this.amount = this.amount.subtract(amountResponse.amount);
        return this;
    }
}
