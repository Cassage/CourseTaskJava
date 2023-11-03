package Menu;

public class MenuView {

    MenuController menuController;
    String[] menuOptions = {"2 - Посмотреть историю", "1 - Ввести текст", "0 - Выход"};

    public MenuView() {
        menuController = new MenuController();
    }



    public void drawMenuOptions() {
        for(String menuItem : menuOptions) {
            System.out.println(menuItem);
        }
    }

    public void start() {

        while (true) {
            drawMenuOptions();
            boolean operationResult = menuController.executeMenuOperation();

            if(!operationResult) {
                break;
            }
        }

    }

}
