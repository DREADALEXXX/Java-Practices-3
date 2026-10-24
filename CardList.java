// CardList.java
import java.io.*;
import java.util.Scanner;

public class CardList {
    private CardNode head;   // указатель на первый узел
    private int size;        // удобно хранить размер

    // a) Создание пустого списка
    public CardList() {
        this.head = null;
        this.size = 0;
    }

    // f) Проверка на пустоту
    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    // b) Добавление элемента в конец
    public void add(CardNode node) {
        if (head == null) {
            head = node;
        } else {
            CardNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    // c) Удаление элемента по имени (первое совпадение)
    public boolean remove(String name) {
        if (head == null) return false;

        if (head.getName().equalsIgnoreCase(name)) {
            head = head.next;
            size--;
            return true;
        }

        CardNode current = head;
        while (current.next != null) {
            if (current.next.getName().equalsIgnoreCase(name)) {
                current.next = current.next.next;   // «перепрыгиваем» удаляемый
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // d) Вывод всех элементов
    public void printAll() {
        if (isEmpty()) {
            System.out.println("(список пуст)");
            return;
        }
        System.out.printf("%-20s | %3s | %-10s%n", "Имя", "Возр", "Группа");
        System.out.println("-".repeat(40));
        CardNode current = head;
        while (current != null) {
            current.print();
            current = current.next;
        }
    }

    // e) Очистка списка
    public void clear() {
        head = null;
        size = 0;
    }

    // g) Запись в файл
    public void saveToFile(String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            CardNode current = head;
            while (current != null) {
                pw.println(current.getName() + ";" + current.getAge() + ";" + current.getGroup());
                current = current.next;
            }
        }
    }

    // h) Чтение из файла
    public void loadFromFile(String fileName) throws IOException {
        clear();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p.length == 3) {
                    add(new CardNode(p[0], Integer.parseInt(p[1]), p[2]));
                }
            }
        }
    }
}