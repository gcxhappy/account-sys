package com.caacetc.gcx.domain.enums;


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author: ganchangxin
 * @create: 2020-01-12 17:20
 **/
public class ContentTypeTest {
    @Test
    public void shoud_transform_enum(){
        String str = "PAY_MEAL";
        Assert.isTrue(ContentType.valueOf(str).equals(ContentType.PAY_MEAL),"enum转换成功");
    }
}
