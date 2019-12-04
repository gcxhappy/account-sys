package com.caacetc.gcx.infrastructure;

import com.caacetc.gcx.domain.AccountRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountRecordMapper {
    List<AccountRecord> queryAllRecords();

    void addRecord(AccountRecord record);
}
