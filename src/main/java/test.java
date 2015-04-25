import com.sidekiq.jqueue.Client;
import com.sidekiq.jqueue.ClientImpl;
import com.sidekiq.jqueue.Worker;
import com.sidekiq.jqueue.json.ObjectMapperFactory;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huxinghai on 15/4/24.
 */
public class test {

    public static void main(String args[]){
        Worker w = new Worker("TestTest", new Object[]{ "1" , "2", "3" });
        System.out.printf(w.getClassName());
        try{

            System.out.printf(ObjectMapperFactory.get().writeValueAsString(w));
            Map<String, String> m = new HashMap<String, String>();
            m.put("name", "zhangsan");
            m.put("sex", "lu");

            ArrayList<Map> ol = new ArrayList<Map>();
            ol.add(m);

            for (Map<String, String> mp:ol){
                System.out.println(mp.get("name"));

            }

            Date d = new Date();

            System.out.println("...." + (d.getTime() / 100));

            Jedis j = new Jedis("localhost");
            ClientImpl c = new ClientImpl("sidekiq_server", j);
            Worker cw = new Worker("TestWorker", new Object[]{ "arg1" , "arg1", "arg2" });
            c.enqueue(cw);

        }catch(Exception err){

        }

    }

}
