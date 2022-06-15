import java.util.Comparator;

public class QuickSort {

    /**
     * Перегруженный метод быстрой сортировки для дополнительного объекта Comparator,
     * рекурсивно вызывающий себя для двух разделённых частей массива
     * @param arr Сам массив
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator,  int start, int end){
        if (start >= end) {
            return;
        }
        int number = partition(arr, start, end);

        quickSort(arr, comparator, start, number - 1);
        quickSort(arr,comparator, number + 1, end);
    }

    /**
     * Перегруженный метод для дополнительного объекта Comparator,
     * разделяющий массив на два, относительно переменной pivot, которую выбрали для разделения:
     * правая часть массива - всё, что больше pivot, левая, всё что меньше, таким образом, pivot так и останется по середине
     * после сортировки
     * @param arr Сам массив
     * @param start Начало массива
     * @param end Конец массива
     * @return Возвращает индекс переменной pivot
     */
    public static <T> int partition(Object[] arr, Comparator<Object> comparator, int start, int end) {
        T pivot = (T) arr[end];
        int ptr = start - 1;
        for (int i = start; i < end; i++) {
            if(comparator.compare(start, pivot) < 0){
                ptr++;
                swap(ptr, i, arr);
            }
        }
        swap(ptr + 1, end, arr);
        return ptr + 1;
    }




    /**
     * Метод быстрой сортировки, рекурсивно вызывающий себя для двух разделённых частей массива
     * @param arr Сам массив
     */
    public static <T> void quickSort(T[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int number = partition(arr, start, end);

        quickSort(arr, start, number - 1);
        quickSort(arr, number + 1, end);
    }

    /**
     * Метод, разделяющий массив на два, относительно переменной pivot, которую выбрали для разделения:
     * правая часть массива - всё, что больше pivot, левая, всё что меньше, таким образом, pivot так и останется по середине
     * после сортировки
     * @param arr Сам массив
     * @param start Начало массива
     * @param end Конец массива
     * @return Возвращает индекс переменной pivot
     */
    public static <T> int partition(Object[] arr, int start, int end) {
        T pivot = (T) arr[end];
        int ptr = start - 1;
        for (int i = start; i < end; i++) {
            if(((Comparable)arr[i]).compareTo(pivot) < 0){
                ptr++;
                swap(ptr, i, arr);
            }
        }
        swap(ptr + 1, end, arr);
        return ptr + 1;
    }

    /**
     *  Метод, реализующий замену местами счётчика(ptr) и переменной i
     * @param ptr Переменная счётчик
     * @param i
     * @param arr Сам массив
     */
    public static <T> void swap(int ptr, int i, T[] arr) {
        T temp = arr[ptr];
        arr[ptr] = arr[i];
        arr[i] = temp;
    }


}

