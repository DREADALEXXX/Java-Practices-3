// CircularTester.java
import java.util.Scanner;

public class CircularTester {
    private static final Scanner SC = new Scanner(System.in);
    private static final CircularList list = new CircularList();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Картотека (кольцевой) ===");
            System.out.println("1. Добавить  2. Удалить  3. Показать");
            System.out.println("4. Очистить  5. isEmpty  6. Сохранить");
            System.out.println("7. Загрузить  0. Выход");
            System.out.print("Выбор: ");
            switch (SC.nextLine().trim()) {
                case "1" -> { CNode n = new CNode(); n.readFromConsole(SC); list.add(n); System.out.println("OK: " + n); }
                case "2" -> { System.out.print("Имя: "); System.out.println(list.remove(SC.nextLine().trim()) ? "Удалено" : "Не найдено"); }
                case "3" -> list.printAll();
                case "4" -> { list.clear(); System.out.println("Очищено"); }
                case "5" -> System.out.println(list.isEmpty() ? "Пуст" : "Элементов: " + list.size());
                case "6" -> save();
                case "7" -> load();
                case "0" -> running = false;
                default  -> System.out.println("Неверный выбор");
            }
        }
        SC.close();
    }

    private static void save() {
        System.out.print("Файл: ");
        try { list.saveToFile(SC.nextLine().trim()); System.out.println("Сохранено"); }
        catch (Exception e) { System.out.println("Ошибка: " + e.getMessage()); }
    }

    private static void load() {
        System.out.print("Файл: ");
        try { list.loadFromFile(SC.nextLine().trim()); System.out.println("Загружено: " + list.size()); }
        catch (Exception e) { System.out.println("Ошибка: " + e.getMessage()); }
    }
}