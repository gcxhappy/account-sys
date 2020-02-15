package com.caacetc.gcx.domain.enums;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author: ganchangxin
 * @create: 2020-01-12 17:20
 **/
public class ContentTypeTest {
    @Test
    public void should_transform_string_to_enum_success(){
        String str = "PAY_MEAL";
        assertThat(ContentType.valueOf(str)).isEqualTo(ContentType.PAY_MEAL);
    }
}
