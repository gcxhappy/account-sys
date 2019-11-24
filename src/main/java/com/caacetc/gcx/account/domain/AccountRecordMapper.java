package com.caacetc.gcx.account.domain;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountRecordMapper {
    List<AccountRecord> queryAllRecords();

    List<AccountRecord> queryAllRecordsBy(int month);

    void addRecord(AccountRecord record);
}
