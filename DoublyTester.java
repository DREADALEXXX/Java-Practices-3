// DoublyTester.java
import java.util.Scanner;

public class DoublyTester {
    private static final Scanner SC = new Scanner(System.in);
    private static final DoublyList list = new DoublyList();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Картотека (двусвязный) ===");
            System.out.println("1. Добавить  2. Удалить  3. Показать →");
            System.out.println("4. Показать ←  5. Очистить  6. isEmpty");
            System.out.println("7. Сохранить  8. Загрузить  0. Выход");
            System.out.print("Выбор: ");
            switch (SC.nextLine().trim()) {
                case "1" -> { DNode n = new DNode(); n.readFromConsole(SC); list.add(n); System.out.println("OK: " + n); }
                case "2" -> { System.out.print("Имя: "); System.out.println(list.remove(SC.nextLine().trim()) ? "Удалено" : "Не найдено"); }
                case "3" -> list.printForward();
                case "4" -> list.printBackward();
                case "5" -> { list.clear(); System.out.println("Очищено"); }
                case "6" -> System.out.println(list.isEmpty() ? "Пуст" : "Элементов: " + list.size());
                case "7" -> save();
                case "8" -> load();
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