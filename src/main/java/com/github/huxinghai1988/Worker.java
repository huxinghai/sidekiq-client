package com.github.huxinghai1988;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.huxinghai1988.json.ObjectMapperFactory;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.security.SecureRandom;

/**
 * Created by huxinghai on 15/4/24.
 */
public class Worker implements Serializable {

    SecureRandom random = new SecureRandom();

    @JsonProperty
    private final String jid = new BigInteger(130, random).toString(16);
    private Object[] args = new Object[]{};
    private long enqueued_at;
    private boolean retry = true;
    private String queue = "default";
    private String className;

    public Worker(String className, List<?> args){
        this.className = className;
        this.args = args.toArray();
    }

    public Worker(String className, Object[] args){
        this.className = className;
        this.args = args;
    }

    @JsonProperty(value = "class", required = true)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @JsonProperty
    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    @JsonProperty
    public long getEnqueued_at() {
        return enqueued_at;
    }

    public void setEnqueued_at(long enqueued_at) {
        this.enqueued_at = enqueued_at;
    }

    @JsonProperty
    public boolean isRetry() {
        return retry;
    }

    public void setRetry(boolean retry) {
        this.retry = retry;
    }

    @JsonProperty
    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    @JsonProperty
    public String getJid(){
        return this.jid;
    }

    public String toJSON(){
        try{
            return ObjectMapperFactory.get().writeValueAsString(this);
        }catch (Exception err){
            System.out.printf(err.getMessage());
        }
        return null;
    }
}
