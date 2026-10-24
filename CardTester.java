// CardTester.java
import java.util.Scanner;

public class CardTester {
    private static final Scanner SC = new Scanner(System.in);
    private static final CardList list = new CardList();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = SC.nextLine().trim();
            switch (choice) {
                case "1" -> addStudent();
                case "2" -> removeStudent();
                case "3" -> list.printAll();
                case "4" -> { list.clear(); System.out.println("Список очищен."); }
                case "5" -> System.out.println(list.isEmpty() ? "Список пуст" : "В списке " + list.size() + " элем.");
                case "6" -> saveToFile();
                case "7" -> loadFromFile();
                case "0" -> running = false;
                default -> System.out.println("Неверный выбор.");
            }
        }
        SC.close();
        System.out.println("Выход.");
    }

    private static void printMenu() {
        System.out.println("\n=== Картотека студентов ===");
        System.out.println("1. Добавить студента");
        System.out.println("2. Удалить студента по имени");
        System.out.println("3. Показать всех");
        System.out.println("4. Очистить список");
        System.out.println("5. Проверить на пустоту");
        System.out.println("6. Сохранить в файл");
        System.out.println("7. Загрузить из файла");
        System.out.println("0. Выход");
        System.out.print("Выбор: ");
    }

    private static void addStudent() {
        CardNode node = new CardNode();
        node.readFromConsole(SC);
        list.add(node);
        System.out.println("Добавлено: " + node);
    }

    private static void removeStudent() {
        System.out.print("Имя для удаления: ");
        String name = SC.nextLine().trim();
        System.out.println(list.remove(name) ? "Удалено" : "Не найдено");
    }

    private static void saveToFile() {
        System.out.print("Имя файла: ");
        String f = SC.nextLine().trim();
        try {
            list.saveToFile(f);
            System.out.println("Сохранено в " + f);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        System.out.print("Имя файла: ");
        String f = SC.nextLine().trim();
        try {
            list.loadFromFile(f);
            System.out.println("Загружено " + list.size() + " элементов");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}