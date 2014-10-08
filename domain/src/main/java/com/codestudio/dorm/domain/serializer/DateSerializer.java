/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.domain.serializer;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * 类CustomObjectMapper.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-6-2 下午4:11:07
 */
public class DateSerializer extends JsonSerializer<Date> {

    // private static final Logger LOGGER = LoggerFactory.getLogger(CustomObjectMapper.class);
    @Override
    public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider arg2) throws IOException,
                                                                                           JsonProcessingException {
        jsonGenerator.writeString(DateFormatUtils.format(value, "yyyy-MM-dd HH:mm"));
    }
}
