import java.util.List;

public class SetNumberRunnable implements Runnable {
    private volatile List<Integer> list;

    public SetNumberRunnable(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            try {
                list.wait(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int newNumber = 10;
            for (int i = 0; i < 10; i++) {
                setNewNumber(list, i, newNumber);
                newNumber++;
                System.out.println("set number: " + list.get(i));
            }
        }
    }

    synchronized public void setNewNumber(List<Integer> list, int index, int number) {
        list.set(index, number);
    }
}
