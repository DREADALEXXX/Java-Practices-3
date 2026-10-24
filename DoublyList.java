// DoublyList.java
import java.io.*;
import java.util.Scanner;

public class DoublyList {
    private DNode head;   // начало
    private DNode tail;   // конец
    private int size;

    public DoublyList() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() { return head == null; }
    public int size()        { return size; }

    // ===== b) Добавление в конец — O(1) благодаря tail =====
    public void add(DNode node) {
        node.prev = null;
        node.next = null;
        if (head == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    // ===== c) Удаление по имени =====
    public boolean remove(String name) {
        DNode current = head;
        while (current != null) {
            if (current.getName().equalsIgnoreCase(name)) {
                // 4 случая: единственный / голова / хвост / середина
                if (current.prev != null) current.prev.next = current.next;
                else                      head = current.next;   // голова
                if (current.next != null) current.next.prev = current.prev;
                else                      tail = current.prev;   // хвост
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // ===== d) Вывод вперёд =====
    public void printForward() {
        if (isEmpty()) { System.out.println("(список пуст)"); return; }
        System.out.printf("%-20s | %3s | %-10s%n", "Имя", "Возр", "Группа");
        System.out.println("-".repeat(40));
        DNode c = head;
        while (c != null) { c.print(); c = c.next; }
    }

    // ===== Вывод назад — ВОЗМОЖЕН только в двусвязном! =====
    public void printBackward() {
        if (isEmpty()) { System.out.println("(список пуст)"); return; }
        System.out.printf("%-20s | %3s | %-10s%n", "Имя", "Возр", "Группа");
        System.out.println("-".repeat(40));
        DNode c = tail;
        while (c != null) { c.print(); c = c.prev; }
    }

    // ===== e) Очистка =====
    public void clear() {
        head = tail = null;
        size = 0;
    }

    // ===== g) Запись =====
    public void saveToFile(String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            DNode c = head;
            while (c != null) {
                pw.println(c.getName() + ";" + c.getAge() + ";" + c.getGroup());
                c = c.next;
            }
        }
    }

    // ===== h) Чтение =====
    public void loadFromFile(String fileName) throws IOException {
        clear();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p.length == 3) add(new DNode(p[0], Integer.parseInt(p[1]), p[2]));
            }
        }
    }
}