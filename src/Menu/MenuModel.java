package Menu;

import LastResultsReader.LastResultsStorage;

import java.util.Arrays;
import java.util.List;

public class MenuModel {

    List<Character> russianChars = Arrays.asList('а', 'А', 'Е', 'е', 'и','И','я', 'Я', 'Ё', 'ё', 'Ы', 'ы', 'У', 'у', 'О', 'о', 'ю', 'Ю', 'э', 'Э');
    LastResultsStorage lastResultsStorage;

    public MenuModel(LastResultsStorage lastResultsStorage) {
        this.lastResultsStorage = lastResultsStorage;
    }

    public String getNonRussianText(String text) {
        StringBuilder nonRussianTextBuilder = new StringBuilder();

        for(int i = 0;i < text.length();i++){
            char currentChar = text.charAt(i);

            if(!russianChars.contains(currentChar)){
                nonRussianTextBuilder.append(currentChar);
            };


        }

        String nonRussianText = nonRussianTextBuilder.toString();

        lastResultsStorage.addValueToHistory(text, nonRussianText);

        return nonRussianText;
    }

}
