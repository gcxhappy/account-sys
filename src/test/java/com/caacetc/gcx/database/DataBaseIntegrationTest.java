package com.caacetc.gcx.database;

import com.caacetc.gcx.domain.AccountRecord;
import com.caacetc.gcx.domain.enums.ContentType;
import com.caacetc.gcx.domain.enums.RecordType;
import com.caacetc.gcx.infrastructure.AccountRecordMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author: ganchangxin
 * @create: 2020-01-22 14:01
 **/
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBaseIntegrationTest {
    @Autowired
    private AccountRecordMapper accountRecordMapper;

    private AccountRecord record;

    @Before
    public void setup(){
        record = new AccountRecord();
        record.setAccountName("GCX");
        record.setRecordType(RecordType.Spending);
        record.setContentType(ContentType.PAY_TRAFFIC);
        record.setNote("bus card charge");
        record.setRecordTime(LocalDateTime.now());
        record.setAmount(BigDecimal.valueOf(50d));
    }

    @Test
    public void should_query_records() {
        List<AccountRecord> accountRecords = accountRecordMapper.queryAllRecords();
        assertThat(accountRecords).isNotNull().hasSize(1);
    }

    @Test
    public void should_query_single_record() {
        AccountRecord accountRecord = accountRecordMapper.queryBy(1).orElse(new AccountRecord());
        assertThat(accountRecord.getRecordType()).isEqualTo(RecordType.Spending);
        assertThat(accountRecord.getContentType()).isEqualTo(ContentType.PAY_MEAL);
        assertThat(accountRecord.getAmount()).isEqualTo(BigDecimal.valueOf(50d));
    }

    @Test
    public void should_add_data_success() {
        accountRecordMapper.addOne(record);
        List<AccountRecord> accountRecords = accountRecordMapper.queryAllRecords();
        assertThat(accountRecords).isNotNull().hasSize(2);
    }
}
