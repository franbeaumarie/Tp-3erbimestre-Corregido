import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class QueueImplement < T > implements Queue < T > {

    private T[] elements; //Se crea la variable elements
    private int dim = 0;//Se crea una variable la que seria la dimension de la lista y se va a ir sumando o restando a medida que se vayan agregando o restando turnos
    private final int INITIAL_DIM = 5; //la variable que se usa luego para declarar el tamaño de la lista

    public QueueImplement() {
        elements = (T[]) new Comparable[INITIAL_DIM]; //se crea o se guarda en la variable elements una nueva lista con el tamaño de "initial_dim"(5)
    }

    @Override public String pop() throws EmptyQueueException {
        T a = elements[0]; //guarda en la variable "a" el primero de la lista
        remove(0); //Borra el primero de la lista
        return a.toString(); //devuelve el elemento guardado en la variable "a" como string
    }

    @Override public String peek() { //devuelve el elemento en la posicion 0 de la lista como string(el primero de la lista)
        return elements[0].toString();
    }

    @Override public boolean isEmpty() { //Devuelve si la lista esta vacia
        return dim == 0;
    }

    @Override public void add(T element) { //element = String name, Int number (el nombre y el numero de entrada)
        if (dim >= elements.length) resize();//Si la lista esta llena, hace un resize(hace una copia de la lista y agrega mas espacios)
        elements[dim++] = element; //Agrega el nuevo elemento a la lista y le suma 1 a dim
    }

    @Override public void sort() { //Hace un sort con los elementos, compara para ver cual tiene que estar mas arriba o como deben organizarse los elementos de la lista.
        Arrays.sort(elements);
    }//Cuando hace un sort, llama al CompareTo que es donde le decimos como va a ordenar los objetos(Aca compara de a 2 todos los items de la lista y va ordenando de mayor a menor)

    @Override public T min(Comparator < T > comparator) {
        T ultimo = elements[0];
        for (int i = 0; i < dim; i++) {
            if (comparator.compare(ultimo, elements[i]) < 0)
                ultimo = elements[i];
        }
        return ultimo;
    }

    public void remove(int index) { //la funcion donde se borra el primer item de la lista
        if (!(index < 0 && index >= dim)) {
            System.arraycopy(elements, index + 1, elements, index, dim - 1 - index);//Esto en realidad no borra, copia la lista evitando el primer elemento(el que se quiere borrar)
            dim--;//le resta 1 a dim ya que se borro un elemento de la lista
        }
    }

    private void resize() {
        Arrays.copyOf(elements, dim + INITIAL_DIM);//Hace una copia de los elementos de la lista agregando mas espacios(dim + INITIAL_DIM)
    }

    @Override//Este iterator lo que hace basicamente es un foreach, recorre los elemento de la lista
    public Iterator < T > iterator() { //Por cada item de la lista, se fija si hay uno siguiente y si hay uno, devuelve el elemento y suma 1 a "i".
        return new Iterator() {

            private int i = 0; //Crea la variable i igual a 0

            @Override
            public T next() {
                if (hasNext()) return elements[i++];//si hay un siguiente elemento, devuelve el elemento en la posicion i y le suma 1 a "i"
                else throw new Error("No hay nada despues");//si no hay un siguiente, tira error
            }

            @Override
            public boolean hasNext() {
                if (i < dim) return true;//si i es menor a la cantidad de items que hay en la lista, quiere decir que hay un siguiente
                else return false;
            }
        };
    }
}
