package com.sidekiq.jqueue.json;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public final class ObjectMapperFactory {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        final DateFormat jsonDateFormat = new CompositeDateFormat();
//        mapper.getDeserializationConfig().with(jsonDateFormat);
//        mapper.getSerializationConfig().with(jsonDateFormat);
    }

    /**
     * @return a fully-configured ObjectMapper
     */
    public static ObjectMapper get() {
        return mapper;
    }

    private ObjectMapperFactory() {
        // Utility class
    }
}