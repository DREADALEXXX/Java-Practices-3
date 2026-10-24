// MergeSortStudents.java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSortStudents {

    // ============================================================
    // ЧАСТЬ 1. СОРТИРОВКА СЛИЯНИЕМ (Merge Sort) для одного списка
    // ============================================================

    /** Сортирует список по естественному порядку (compareTo). */
    public static List<Student> mergeSort(List<Student> list) {
        return mergeSort(list, Comparator.naturalOrder());
    }

    /** Сортирует список по произвольному компаратору. */
    public static List<Student> mergeSort(List<Student> list, Comparator<Student> cmp) {
        if (list.size() <= 1) {
            return new ArrayList<>(list);   // база рекурсии
        }
        int mid = list.size() / 2;
        List<Student> left  = mergeSort(list.subList(0, mid), cmp);
        List<Student> right = mergeSort(list.subList(mid, list.size()), cmp);
        return merge(left, right, cmp);
    }

    // ============================================================
    // ЧАСТЬ 2. СЛИЯНИЕ ДВУХ ОТСОРТИРОВАННЫХ СПИСКОВ (merge)
    // ============================================================

    /**
     * Сливает два ОТСОРТИРОВАННЫХ списка в один отсортированный.
     * Сложность O(n + m).
     * @throws NullPointerException если любой из списков null
     */
    public static List<Student> merge(List<Student> a, List<Student> b,
                                      Comparator<Student> cmp) {
        List<Student> result = new ArrayList<>(a.size() + b.size());
        int i = 0, j = 0;

        // пока есть элементы в обоих списках — берём меньший
        while (i < a.size() && j < b.size()) {
            if (cmp.compare(a.get(i), b.get(j)) <= 0) {
                result.add(a.get(i++));
            } else {
                result.add(b.get(j++));
            }
        }

        // докидываем остаток одного из списков
        while (i < a.size()) result.add(a.get(i++));
        while (j < b.size()) result.add(b.get(j++));

        return result;
    }
}