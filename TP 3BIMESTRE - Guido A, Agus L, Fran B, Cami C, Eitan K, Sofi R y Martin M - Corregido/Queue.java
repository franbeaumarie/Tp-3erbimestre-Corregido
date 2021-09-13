import java.util.Comparator;
import java.util.Iterator;

public interface Queue<T> extends Iterable<T> {

    public void add(T element);

    public void sort();

    public boolean isEmpty();

    public String peek();

    public String pop() throws EmptyQueueException;

    public T min(Comparator<T> comparator);

    @Override public Iterator<T> iterator();
}
