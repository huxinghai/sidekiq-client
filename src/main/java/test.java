import com.sidekiq.jqueue.Worker;
import com.sidekiq.jqueue.json.ObjectMapperFactory;

/**
 * Created by huxinghai on 15/4/24.
 */
public class test {

    public static void main(String args[]){
        Worker w = new Worker("TestTest", new Object[]{ "1" , "2", "3" });
        System.out.printf(w.getClassName());
        try{

            System.out.printf(ObjectMapperFactory.get().writeValueAsString(w));
        }catch(Exception err){

        }

    }

}
