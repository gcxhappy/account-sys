package com.caacetc.gcx;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class AccountSysApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() {
    }

}
