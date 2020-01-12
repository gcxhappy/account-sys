package com.caacetc.gcx.infrastructure;

import com.caacetc.gcx.domain.AccountRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface AccountRecordMapper {
    List<AccountRecord> queryAllRecords();

    void addOne(AccountRecord record);

//    Optional<AccountRecord> queryBy(Integer id);
}
