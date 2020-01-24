package com.caacetc.gcx.integration;

import com.alibaba.fastjson.JSONObject;
import com.caacetc.gcx.application.message.CreatingAccountRecordRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * @author: ganchangxin
 * @create: 2020-01-22 16:22
 **/
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRecordIntegerationTests {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private CreatingAccountRecordRequest record;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        record = new CreatingAccountRecordRequest();
        record.setAmount(BigDecimal.valueOf(50d));
        record.setAccountName("GCX");
        record.setContentType("PAY_TRAFFIC");
        record.setRecordType("Spending");
        record.setNote("bus card charge");
        record.setRecordTime(LocalDateTime.now().minusHours(16));
    }

    @Test
    public void should_query_all_records() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/account-records"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void should_add_one_record() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/account-records")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(record)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void should_calculate_income_monthly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/income/year/{year}/month/{month}", 2020, 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("amount").value(BigDecimal.ZERO))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void should_calculate_spending_monthly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/spending/year/{year}/month/{month}", 2020, 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("amount").value(BigDecimal.valueOf(50d)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void should_calculate_profit_monthly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/profit/year/{year}/month/{month}", 2020, 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("amount").value(BigDecimal.valueOf(-50d)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void not_should_calculate_income_monthly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/income/year/{year}/month/{month}", 2020, 13))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }
}
