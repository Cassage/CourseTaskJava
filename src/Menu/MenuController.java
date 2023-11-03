package Menu;


import LastResultsReader.LastResultsStorage;

import java.util.Scanner;

public class MenuController {

    Scanner scanner;
    boolean isExit;
    MenuModel menuModel;

    LastResultsStorage lastResultsStorage;

    public MenuController() {
        isExit = false;
        scanner = new Scanner(System.in);
        this.lastResultsStorage = new LastResultsStorage();
        this.menuModel = new MenuModel(lastResultsStorage);
    }

    public boolean executeMenuOperation() {
        int command = getCommand();

        return getCommandResult(command);

    }

    private int getCommand() {
        System.out.print("Введите команду - ");
        return scanner.nextInt();
    }

    private boolean getCommandResult(int command) {
        switch (command) {
            case 2 -> {
                System.out.println("История использования приложения");
                lastResultsStorage.lookHistory();
            }
            case 1 -> {
                System.out.print("Введите текст - ");
                String userText = scanner.next();

                String nonRussianText = menuModel.getNonRussianText(userText);

                System.out.println("Текст без русских гласных - " + nonRussianText);
            }

            case 0 -> {
                return false;
            }

            default -> System.out.println("Такой команды нет");

        }

        return true;
    }

}
