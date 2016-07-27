# sidekiq-client

sidekiq queue client support java language

maven install
```xml
<dependency>
  <groupId>com.github.huxinghai1988</groupId>
  <artifactId>sidekiq-client-plugin</artifactId>
  <version>1.3</version>
</dependency>
```


Example usage

```java
ClientImpl client = new ClientImpl("namespace", new Jedis("localhost"));

Worker worker = new Worker("TestWorker", new Object[]{ "arg1" , "arg1", Arrays.asList("inner", 4.5) }).withQueue("notify");
client.enqueue(worker);


//add schedule
DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd H:m:s");
Date d = formatter.parse("2015-04-25 22:19:00");

ClientImpl client = new ClientImpl("namespace", new Jedis("localhost"));

Worker worker = new Worker("TestWorker", new Object[]{ "arg1" , "arg1", "arg2" }).withQueue("notify").withEnqueuedAt(d.getTime());
client.enqueue(worker);


//delete scheduled
client.delete(jid)
 ```