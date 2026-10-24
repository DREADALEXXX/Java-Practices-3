// CNode.java
import java.util.Scanner;

public class CNode {
    private String name;
    private int age;
    private String group;

    CNode next;   // одна ссылка

    public CNode() { }
    public CNode(String name, int age, String group) {
        this.name = name; this.age = age; this.group = group;
    }

    public void readFromConsole(Scanner sc) {
        System.out.print("Имя: ");    this.name = sc.nextLine().trim();
        System.out.print("Возраст: "); this.age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Группа: "); this.group = sc.nextLine().trim();
    }

    public void print() { System.out.printf("%-20s | %3d | %-10s%n", name, age, group); }
    public String getName() { return name; }
    public int getAge()     { return age; }
    public String getGroup(){ return group; }
    @Override public String toString() { return name + " (" + age + ", " + group + ")"; }
}