package com.github.huxinghai1988;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.huxinghai1988.json.ObjectMapperFactory;

/**
 * Created by huxinghai on 15/4/24.
 */
public class Worker implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8310484531276432471L;

    SecureRandom random = new SecureRandom();

    private String jid;
    private Object[] args = new Object[]{};
    private double enqueued_at;
    private boolean retry = true;
    private String queue = "default";
    private String className;


    public Worker(String className, List<?> args){
        this.defaultInit();
        this.className = className;
        this.args = args.toArray();
    }

    public Worker(String className, Object[] args){
        this.defaultInit();
        this.className = className;
        this.args = args;
    }
    
    public Worker() {
        this.defaultInit();
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
    public double getEnqueued_at() {
        return enqueued_at;
    }

    public void setEnqueued_at(double enqueued_at) {
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

    public Worker withQueue(String queue){
        this.queue = queue;
        return this;
    }

    public Worker withEnqueuedAt(long enqueued_at){
        this.enqueued_at = enqueued_at;
        return this;
    }

    public Worker withRetry(boolean retry){
        this.retry = retry;
        return this;
    }

    @JsonProperty
    public String getJid(){
        return this.jid;
    }
    
    public void setJid(String jid) {
        this.jid = jid;
    }

    public Worker withJid(String jid){
        this.jid = jid;
        return this;
    }

    public String toJSON(){
        try{
            return ObjectMapperFactory.get().writeValueAsString(this);
        }catch (Exception err){
            System.out.printf(err.getMessage());
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    public static Worker parse(String json){
        try{
            Map<String, Object> m = ObjectMapperFactory.get().readValue(json, new TypeReference<Map<String, Object>>() {});
            return new Worker((String)m.get("class"), (ArrayList) m.get("args")).withEnqueuedAt(((Number) m.get("enqueued_at")).longValue()).withQueue((String)m.get("queue")).withRetry((Boolean) m.get("retry")).withJid((String)m.get("jid"));
        }catch (Exception err){
            System.out.printf(err.getMessage());
        }
        return null;
    }

    private void defaultInit(){
        this.jid = new BigInteger(130, random).toString(16);
    }
    
}
