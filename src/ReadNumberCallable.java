import java.util.List;
import java.util.concurrent.Callable;

public class ReadNumberCallable implements Callable<String> {
    private List<Integer> list;

    public ReadNumberCallable(List<Integer> list){
        this.list = list;
    }

    @Override
    public String call() throws Exception {
        synchronized (list){
            list.wait(300);
            for (int i = 0; i < 10; i++){
                System.out.println("read number: " + readNumber(list,i));
            }
        }
        return list.toString();
    }

    synchronized public Integer readNumber(List<Integer> list, int number){
        return list.get(number);
    }
}
