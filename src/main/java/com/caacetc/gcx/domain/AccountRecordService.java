package com.caacetc.gcx.domain;

import com.caacetc.gcx.infrastructure.AccountRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: ganchangxin
 * @create: 2019-12-04 21:25
 **/
@Component
public class AccountRecordService {
    @Autowired
    private AccountRecordMapper mapper;

    public void addRecord(AccountRecord record) {
        mapper.addOne(record);
    }

    public List<AccountRecord> queryAllRecords() {
        return mapper.queryAllRecords();
    }

}
