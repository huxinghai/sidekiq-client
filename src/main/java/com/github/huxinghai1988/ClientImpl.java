package com.github.huxinghai1988;

import redis.clients.jedis.Jedis;

/**
 * Created by huxinghai on 15/4/25.
 */
public class ClientImpl extends AbstractClient {


    public ClientImpl(String namespace, Jedis redis){
        super(namespace, redis);
    }

    public ClientImpl(Jedis redis){
        super(redis);
    }
}
