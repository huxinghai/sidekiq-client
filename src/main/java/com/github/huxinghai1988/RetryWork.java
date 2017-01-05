package com.github.huxinghai1988;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.huxinghai1988.json.ObjectMapperFactory;

/**
 * 创建时间：2016年11月23日
 * <p>修改时间：2016年11月23日
 * <p>类说明：重试work
 * 
 * @author huangxingwei
 * @version 1.0
 */
public class RetryWork extends Worker implements Serializable {

    private static final long serialVersionUID = -7011503395038850232L;
    
    private double created_at;
    
    private Object error_message;
    
    private String error_class;
    
    private double failed_at;
    
    private int retry_count;
    
    private double retried_at;
    
    public RetryWork(String className, List<?> args){
        super(className, args);
    }

    public RetryWork(String className, Object[] args){
        super(className, args);
    }
    
    public RetryWork() {
        super();
    }
    
   
    @JsonProperty
    public double getCreated_at() {
        return created_at;
    }

    public void setCreated_at(double created_at) {
        this.created_at = created_at;
    }
    
    public RetryWork withCreatedAt(double created_at) {
        this.created_at = created_at;
        return this;
    }

    @JsonProperty
    public Object getError_message() {
        return error_message;
    }

    public void setError_message(Object error_message) {
        this.error_message = error_message;
    }
    
    public RetryWork withErrorMessage(Object error_message) {
        this.error_message = error_message;
        return this;
    }

    @JsonProperty
    public String getError_class() {
        return error_class;
    }

    public void setError_class(String error_class) {
        this.error_class = error_class;
    }
    
    public RetryWork withErrorClass(String error_class) {
        this.error_class = error_class;
        return this;
    }

    @JsonProperty
    public double getFailed_at() {
        return failed_at;
    }

    public void setFailed_at(double failed_at) {
        this.failed_at = failed_at;
    }
    
    public RetryWork withFailedAt(double failed_at) {
        this.failed_at = failed_at;
        return this;
    }

    @JsonProperty
    public int getRetry_count() {
        return retry_count;
    }
    
    public void setRetry_count(int retry_count) {
        this.retry_count = retry_count;
    }
    
    public RetryWork withRetryCount(int retry_count) {
        this.retry_count = retry_count;
        return this;
    }

    
    @JsonProperty
    public double getRetried_at() {
        return retried_at;
    }

    public void setRetried_at(double retried_at) {
        this.retried_at = retried_at;
    }
    
    public RetryWork withRetriedAt(double retried_at) {
        this.retried_at = retried_at;
        return this;
    }
    
    public RetryWork withJid(String jid){
        super.setJid(jid);
        return this;
    }
    
    public RetryWork withRetry(boolean retry){
        super.setRetry(retry);
        return this;
    }
    
    public RetryWork withQueue(String queue){
        super.setQueue(queue);
        return this;
    }

    public RetryWork withEnqueuedAt(double enqueued_at){
        super.setEnqueued_at(enqueued_at);
        return this;
    }
    
    @SuppressWarnings("rawtypes")
    public static RetryWork parse(String json){
        try{
            Map<String, Object> m = ObjectMapperFactory.get().readValue(json, new TypeReference<Map<String, Object>>() {});
            RetryWork work = new RetryWork((String)m.get("class"), (ArrayList) m.get("args")).withEnqueuedAt(((Number) m.get("enqueued_at")).doubleValue())
                    .withQueue((String)m.get("queue")).withRetry((Boolean) m.get("retry")).withJid((String)m.get("jid"))
                    .withCreatedAt(((Number) m.get("created_at")).doubleValue()).withErrorMessage(m.get("error_message"))
                    .withErrorClass((String)m.get("error_class")).withFailedAt(((Number) m.get("failed_at")).doubleValue())
                    .withRetryCount(((Number) m.get("retry_count")).intValue());
            if(m.get("retried_at") != null) {
                work = work.withRetriedAt(((Number) m.get("retried_at")).doubleValue());
            }
            return work;
        }catch (Exception err){
            System.out.printf(err.getMessage());
        }
        return null;
    }
    
}
