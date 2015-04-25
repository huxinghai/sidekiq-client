package com.sidekiq.jqueue;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.security.SecureRandom;

/**
 * Created by huxinghai on 15/4/24.
 */
public class Worker implements Serializable {

    SecureRandom random = new SecureRandom();

//    @JsonProperty
    private final String jid = new BigInteger(130, random).toString(16);;

    private Object[] args;
    private long enqueued_at;
    private boolean retry;
    private String queue;
    private String className;

    public Worker(String className, List<?> args){
        this.args = args.toArray();
    }

    public Worker(String className, Object[] args){
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public long getEnqueued_at() {
        return enqueued_at;
    }

    public void setEnqueued_at(long enqueued_at) {
        this.enqueued_at = enqueued_at;
    }

    public boolean isRetry() {
        return retry;
    }

    public void setRetry(boolean retry) {
        this.retry = retry;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }
}
