import java.util.*;

/**
 * Это основной класс реализации наисанного ArrayList
 */
public class MyArrayList<T extends Comparable <T>> implements MyList<T>  {


    /**
     * Поле, характеризующее типизированный массив
     */
    private T[] array;
    /**
     * Поле, которое указывает на размер массива
     */
    private int size = 0;
    /**
     * Поле, указывающее начальное значение размера массива для применения
     * контструктора по умолчанию
     */
    private final int CAPACITY = 16;
    /**
     * Поле, указывающее начальное значение размера массива при объявлении в конструкторе с параметром
     */
    private int capacity = 0;

    /**
     * Конструктор по умолчанию, в котором задаётся массив размером 16 (размер по умолчанию)
     */
    public MyArrayList() {
        capacity = CAPACITY;
        array = (T[]) new Comparable[capacity];
    }

    /**
     * Конструктор, при помощи которого задаётся размер массива при объявлении
     * @param capacity
     */
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    /**
     * Метод, увеличивающий размер массива вдвое(как в java.util.ArrayList) при достижении
     * большего количество элементов, чем изначальный размер массива
     */
    public void increaseSize() {
        capacity = capacity * 2;
        T[] newArray;
        newArray = Arrays.copyOf(array, capacity);
        array = newArray;
    }

    /**
     * Метод, возвращающий величину массива
     * @return Возврпащает размер массива
     */
    @Override
    public int size() {
        return array.length;
    }

    /**
     * Метод, Заменяющий значение в массиве на новое
     * @param index Индекс, на который необходимо поместить элемент
     * @param t Элемент, который необходимо поместить в индекс
     */
    @Override
    public void set(int index, T t) {
        if ((index < size) && (index >= 0)) {
            array[index] = t;
        }
    }

    /**
     * Метод, реализующий вставку элемента в массив без замены, со сдвигом на 1 вперёд
     * @param index Индекс, на который нужно поместить элемент
     * @param t Элемент, который необходимо поместить в индекс
     * @return Возвращает bool: true - при успешном выполнении, false - при неуспешном.
     */
    @Override
    public boolean add(int index, T t) {
        if (index < 0) {
            return false;
        }
        if (size + 1 >= capacity) {
            increaseSize();
        }
        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = t;
        size++;
        return true;
    }

    /**
     * Метод, реализующий вставку в конец списка
     * @param t Элемент, который необходимо вставить в конец списка
     * @return Возвращает bool: true - при успешном выполнении, false - при неуспешном.
     */
    @Override
    public boolean add(T t) {
        if (size >= capacity) {
            increaseSize();
        }
        array[size++] = t;
        return true;
    }

    /**
     * Метод, реализующий удаление из списка с сокращением списка на 1 элемент
     * @param index Элемент, который необходимо удалить
     */
    @Override
    public void delete(int index) {
        int element; //количество элементов после индекса для копирования второй части массива
        T[] temp = array;
        array = (T[]) new Object[temp.length - 1];
        System.arraycopy(temp, 0, array, 0, index);
        element = temp.length - index - 1;
        System.arraycopy(temp, index + 1, array, index, element);
    }

    /**
     * Метод, реалтизующий выбор элемента из списка
     * @param index Индекс элемента, который нужно выбрать
     * @return Возвращает элемент, который необходимо было выбрать по индексу
     */
    @Override
    public T get(int index) {
        return (T) array[index];
    }

    /**
     * Метод интерфейса java.lang.Iterable
     * @return Возвращает итератор
     */
    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator<T>(array);
    }


    /**
     * Метод, конвертирующий ArrayList в обычный массив
     * @return Возвращает массив, который был получен конвертированием ArrayList
     */
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    /**
     * Метод, интерфейса java.lang.Comparable
     * @return Возвращает значение сравнения дву элементов массива
     */
    @Override
    public int compareTo(T o) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = array[i].compareTo(o);
        }
        return result;
    }

    /**
     * Метод, реализующий сортировку массива методом быстрой сортировки
     */
    public void sort() {
        Object[] a = this.toArray();
        QuickSort.quickSort(a, 0 ,a.length - 1);
        for (Object e : a) {
            System.out.print(" " + e);
        }
    }

}
