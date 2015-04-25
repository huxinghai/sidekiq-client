# sidekiq-client

sidekiq queue client support java language


Example usage

```java
        ClientImpl client = new ClientImpl("namespace", new Jedis("localhost"));

        Worker worker = new Worker("TestWorker", new Object[]{ "arg1" , "arg1", Arrays.asList("inner", 4.5) });
        worker.setEnqueued_at(d.getTime());
        worker.setQueue("notify");
        client.enqueue(worker);


        //add schedule
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        Date d = formatter.parse("2015-04-25 22:19:00");

        ClientImpl client = new ClientImpl("namespace", new Jedis("localhost"));

        Worker worker = new Worker("TestWorker", new Object[]{ "arg1" , "arg1", "arg2" });
        worker.setEnqueued_at(d.getTime());
        worker.setQueue("notify");
        client.enqueue(worker);
 ```