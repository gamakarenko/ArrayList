import java.util.ArrayList;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>();
        MyArrayList<Integer> arrayList1 = new MyArrayList<>();
        arrayList.add("c ");
        arrayList.add("b ");
        arrayList.add("a ");
        arrayList.add("e ");
        arrayList.add("f ");
        arrayList.add("d ");
        arrayList.add("h ");
        arrayList.add("i ");
        arrayList.add("g ");
        arrayList1.add(12);
        arrayList1.add(5);
        arrayList1.add(-4);
        arrayList1.add(1);
        arrayList1.add(0);
        System.out.println("\n" +"First AL");
        for (Object o: arrayList) {
            System.out.print(" " + o);
        }
        System.out.println("\n" + " Second AL:");
        for (Object o: arrayList1) {
            System.out.print(" " + o);
        }
        System.out.println("\n" + "---------------------------");
        System.out.println("First Array sorted:");
        arrayList.sort();
        System.out.println("\n" +"Second Array sorted:");
        arrayList1.sort();
    }
}
