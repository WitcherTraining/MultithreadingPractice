import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.FutureTask;

public class Runner {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new CopyOnWriteArrayList<>();

        Thread addNumber = new AddNumberThread(list);
        Thread setNumber = new Thread(new SetNumberRunnable(list));
        Callable<String> callable = new ReadNumberCallable(list);
        FutureTask readNumber = new FutureTask(callable);

        addNumber.start();
        Thread thread = new Thread(readNumber);
        thread.start();
        setNumber.start();
    }
}
