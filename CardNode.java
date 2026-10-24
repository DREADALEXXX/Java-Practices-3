// CardNode.java
import java.util.Scanner;

public class CardNode {
    // === Поля данных ===
    private String name;
    private int age;
    private String group;

    // === Ссылка на следующий узел ===
    CardNode next;   // package-private — доступна из CardList

    public CardNode() { }

    public CardNode(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    // a) Считать атрибуты с консоли
    public void readFromConsole(Scanner sc) {
        System.out.print("Имя: ");
        this.name = sc.nextLine().trim();
        System.out.print("Возраст: ");
        this.age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Группа: ");
        this.group = sc.nextLine().trim();
    }

    // b) Вывести атрибуты на экран
    public void print() {
        System.out.printf("%-20s | %3d | %-10s%n", name, age, group);
    }

    // Геттеры (для поиска/сравнения)
    public String getName()  { return name; }
    public int getAge()      { return age; }
    public String getGroup() { return group; }

    @Override
    public String toString() {
        return name + " (" + age + ", " + group + ")";
    }
}