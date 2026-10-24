// Task_MergeStudents.java
import java.util.*;

public class Task_MergeStudents {
    public static void main(String[] args) {
        // === Список 1 (уже отсортирован по GPA) ===
        List<Student> list1 = new ArrayList<>(List.of(
                new Student("Alice",   101, 3.5),
                new Student("Charlie", 103, 4.2),
                new Student("Eve",     105, 4.9)
        ));

        // === Список 2 (уже отсортирован по GPA) ===
        List<Student> list2 = new ArrayList<>(List.of(
                new Student("Bob",   102, 3.8),
                new Student("Dave",  104, 4.0),
                new Student("Frank", 106, 4.5)
        ));

        // Сортировка по GPA по УБЫВАНИЮ
        Comparator<Student> byGpaDesc =
                (a, b) -> Double.compare(b.getGpa(), a.getGpa());

        // ⚠️ merge требует ОТСОРТИРОВАННЫХ входов — на всякий случай сортируем
        list1 = MergeSortStudents.mergeSort(list1, byGpaDesc);
        list2 = MergeSortStudents.mergeSort(list2, byGpaDesc);

        System.out.println("=== Список 1 (GPA ↓) ===");
        list1.forEach(System.out::println);

        System.out.println("\n=== Список 2 (GPA ↓) ===");
        list2.forEach(System.out::println);

        // === Слияние ===
        List<Student> merged =
                MergeSortStudents.merge(list1, list2, byGpaDesc);

        System.out.println("\n=== Объединённый отсортированный список ===");
        merged.forEach(System.out::println);

        // === Дополнительно: полная merge sort «с нуля» ===
        System.out.println("\n=== Merge sort неотсортированного списка ===");
        List<Student> unsorted = new ArrayList<>(List.of(
                new Student("Zoe",   201, 3.1),
                new Student("Yan",   202, 4.8),
                new Student("Xena",  203, 3.7)
        ));
        System.out.println("До:");
        unsorted.forEach(System.out::println);
        List<Student> sorted = MergeSortStudents.mergeSort(unsorted, byGpaDesc);
        System.out.println("После:");
        sorted.forEach(System.out::println);
    }
}
