package com.github.huxinghai1988;

import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.Set;

/**
 * Created by huxinghai on 15/4/25.
 */
public abstract class AbstractClient implements Client {

    private String namespace;
    private final Jedis redis;

    protected AbstractClient(String namespace, Jedis redis) {
        this.namespace = namespace;
        this.redis = redis;
    }

    protected AbstractClient(Jedis redis){
        this.redis = redis;
    }

    @Override
    public String enqueue(Worker w){
        if(w.getEnqueued_at() > 0){
            joinSchedule(w);
        }else{
            joinQueue(w);
        }
        return w.getJid();
    }

    @Override
    public Worker find(String jid){
        Set<String> list = this.redis.zrange(this.namespaceKey("schedule"), 0, -1);
        for(String json : list){
            Worker w = Worker.parse(json);
            if(w != null && w.getJid().equals(jid))
                return w;
        }
        return null;
    }

    @Override
    public long delete(String jid){
        Worker w = find(jid);
        String key = this.namespaceKey("schedule");
        this.redis.zrem(key, w.toJSON());
        return this.redis.zcard(key);
    }

    private void joinQueue(Worker w){
        w.setEnqueued_at(new Date().getTime() / 1000);
        this.redis.lpush(this.namespaceKey("queue:"+ w.getQueue()), w.toJSON());
        this.redis.sadd(this.namespaceKey("queues"), w.getQueue());
    }

    private void joinSchedule(Worker w){
        w.setEnqueued_at(w.getEnqueued_at() / 1000);
        this.redis.zadd(this.namespaceKey("schedule"), w.getEnqueued_at(), w.toJSON());
    }

    private String namespaceKey(String name){
        if(this.namespace == null || this.namespace.isEmpty()){
            return name;
        }
        return this.namespace + ":"+ name;
    }

}
