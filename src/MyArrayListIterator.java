import java.util.Iterator;

/**
 * Класс, описывающий стандартную реализацию интерфейса Iterator
 * @param <T>
 */
public class MyArrayListIterator<T> implements Iterator<T> {

    private int index = 0;
    T[] values;

    public MyArrayListIterator(T[] values) {
        this.values = values;
    }

    public void set(T t){

    }
    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public T next() {
        return values[index++];
    }
}
