// CircularList.java
import java.io.*;
import java.util.Scanner;

public class CircularList {
    private CNode tail;   // в кольцевом удобно хранить ХВОСТ, т.к. tail.next == head
    private int size;

    public CircularList() { tail = null; size = 0; }

    public boolean isEmpty() { return tail == null; }
    public int size()        { return size; }

    // b) Добавление в конец — O(1)
    public void add(CNode node) {
        if (tail == null) {
            tail = node;
            node.next = node;          // сам на себя — кольцо из 1 элемента
        } else {
            node.next = tail.next;     // node.next = head
            tail.next = node;          // старый хвост → node
            tail = node;               // node — новый хвост
        }
        size++;
    }

    // c) Удаление по имени
    public boolean remove(String name) {
        if (tail == null) return false;

        CNode head = tail.next;
        CNode current = head;
        CNode prev = tail;

        // обходим кольцо ровно size раз — иначе зациклимся
        for (int i = 0; i < size; i++) {
            if (current.getName().equalsIgnoreCase(name)) {
                if (size == 1) {
                    tail = null;
                } else {
                    prev.next = current.next;
                    if (current == tail) tail = prev;   // удалили хвост
                    if (current == head) { /* head сместился, но tail.next уже указывает на новый head */ }
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    // d) Вывод — обход ровно size раз
    public void printAll() {
        if (isEmpty()) { System.out.println("(список пуст)"); return; }
        System.out.printf("%-20s | %3s | %-10s%n", "Имя", "Возр", "Группа");
        System.out.println("-".repeat(40));
        CNode head = tail.next;
        CNode current = head;
        do {
            current.print();
            current = current.next;
        } while (current != head);
    }

    // e) Очистка
    public void clear() { tail = null; size = 0; }

    // g) Сохранение
    public void saveToFile(String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            if (isEmpty()) return;
            CNode head = tail.next, current = head;
            do {
                pw.println(current.getName() + ";" + current.getAge() + ";" + current.getGroup());
                current = current.next;
            } while (current != head);
        }
    }

    // h) Загрузка
    public void loadFromFile(String fileName) throws IOException {
        clear();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p.length == 3) add(new CNode(p[0], Integer.parseInt(p[1]), p[2]));
            }
        }
    }
}