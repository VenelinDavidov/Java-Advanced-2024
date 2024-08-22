package List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Custom_List<String> customList = new Custom_List<String>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] commandParts = input.split("\\s+");
            String commandName = commandParts[0];
            switch (commandName) {
                case "Add":
                    String elementToAdd = commandParts[1];
                    customList.add(elementToAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(commandParts[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String elementToSearch = commandParts[1];
                    System.out.println(customList.contains(elementToSearch));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(commandParts[1]);
                    int secondIndex = Integer.parseInt(commandParts[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String elements = commandParts[1];
                    System.out.println(customList.countGreaterThan(elements));
                    break;
                case "Max":
                    System.out.println(customList.max());
                    break;
                case "Min":
                    System.out.println(customList.min());
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
                default:
                    System.out.println("invalid command");
            }
            input = scanner.nextLine();

        }
    }
}
