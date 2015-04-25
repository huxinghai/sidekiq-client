package com.sidekiq.jqueue;

/**
 * Created by huxinghai on 15/4/25.
 */
public interface Client {

    String enqueue(Worker worker);

}
