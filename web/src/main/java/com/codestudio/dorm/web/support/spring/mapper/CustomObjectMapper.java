/*
 * Copyright 2014 Diqitian.com All right reserved. This software is the
 * confidential and proprietary information of Diqitian.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Diqitian.com.
 */
package com.codestudio.dorm.web.support.spring.mapper;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类CustomObjectMapper.java的实现描述：TODO 类实现描述
 * 
 * @author J 2014-6-2 下午4:11:07
 */
public class CustomObjectMapper extends ObjectMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomObjectMapper.class);

    public CustomObjectMapper(){
        CustomSerializerFactory factory = new CustomSerializerFactory();
        factory.addGenericMapping(Date.class, new JsonSerializer<Date>() {

            @Override
            public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider provider) {
                try {
                    if (value == null) {
                        jsonGenerator.writeString("");
                        return;
                    }
                    jsonGenerator.writeString(DateFormatUtils.format(value, "yyyy-MM-dd HH:mm:ss"));
                } catch (JsonGenerationException e) {
                    LOGGER.error("日期格式转换出错", e);
                } catch (IOException e) {
                    LOGGER.error("日期格式转换出错", e);
                }
            }
        });
        this.setSerializerFactory(factory);
    }
}
