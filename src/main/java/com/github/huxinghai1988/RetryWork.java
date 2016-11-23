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
    
    /**
     * @return the created_at
     */
    @JsonProperty
    public double getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(double created_at) {
        this.created_at = created_at;
    }
    
    public RetryWork withCreatedAt(double created_at) {
        this.created_at = created_at;
        return this;
    }

    /**
     * @return the error_message
     */
    @JsonProperty
    public Object getError_message() {
        return error_message;
    }

    /**
     * @param error_message the error_message to set
     */
    public void setError_message(Object error_message) {
        this.error_message = error_message;
    }
    
    public RetryWork withErrorMessage(Object error_message) {
        this.error_message = error_message;
        return this;
    }

    /**
     * @return the error_class
     */
    @JsonProperty
    public String getError_class() {
        return error_class;
    }

    /**
     * @param error_class the error_class to set
     */
    public void setError_class(String error_class) {
        this.error_class = error_class;
    }
    
    public RetryWork withErrorClass(String error_class) {
        this.error_class = error_class;
        return this;
    }

    /**
     * @return the failed_at
     */
    @JsonProperty
    public double getFailed_at() {
        return failed_at;
    }

    /**
     * @param failed_at the failed_at to set
     */
    public void setFailed_at(double failed_at) {
        this.failed_at = failed_at;
    }
    
    public RetryWork withFailedAt(double failed_at) {
        this.failed_at = failed_at;
        return this;
    }

    /**
     * @return the retry_count
     */
    @JsonProperty
    public int getRetry_count() {
        return retry_count;
    }
    
    /**
     * @param retry_count the retry_count to set
     */
    public void setRetry_count(int retry_count) {
        this.retry_count = retry_count;
    }
    
    public RetryWork withRetryCount(int retry_count) {
        this.retry_count = retry_count;
        return this;
    }

    /**
     * @return the retired_at
     */
    @JsonProperty
    public double getRetried_at() {
        return retried_at;
    }

    /**
     * @param retired_at the retired_at to set
     */
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
