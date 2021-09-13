import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class QueueImplement < T > implements Queue < T > {

    private T[] elements;
    private int dim = 0;
    private final int INITIAL_DIM = 5;

    public QueueImplement() {
        elements = (T[]) new Comparable[INITIAL_DIM];
    }

    @Override public String pop() throws EmptyQueueException {
        T a = elements[0];
        remove(0);
        return a.toString();
    }

    @Override public String peek() {
        return elements[0].toString();
    }

    @Override public boolean isEmpty() {
        return dim == 0;
    }

    @Override public void add(T element) {
        if (dim >= elements.length) resize();
        elements[dim++] = element;
    }

    @Override public void sort() {
        Arrays.sort(elements);
    }

    @Override public T min(Comparator < T > comparator) {
        T ultimo = elements[0];
        for (int i = 0; i < dim; i++) {
            if (comparator.compare(ultimo, elements[i]) < 0)
                ultimo = elements[i];
        }
        return ultimo;
    }

    public void remove(int index) {
        if (!(index < 0 && index >= dim)) {
            System.arraycopy(elements, index + 1, elements, index, dim - 1 - index);
            dim--;
        }
    }

    private void resize() {
        Arrays.copyOf(elements, dim + INITIAL_DIM);
    }

    @Override
    public Iterator < T > iterator() {
        return new Iterator() {

            private int i = 0;

            @Override
            public T next() {
                if (hasNext()) return elements[i++];
                else throw new Error("No hay nada despues");
            }

            @Override
            public boolean hasNext() {
                if (i < dim) return true;
                else return false;
            }
        };
    }
}