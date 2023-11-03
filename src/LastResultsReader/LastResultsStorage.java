package LastResultsReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class LastResultsStorage {

    public void lookHistory() {
        try {
            String file = "history.txt";
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("У вас ещё нет значений");
        }
    }

    public void addValueToHistory(String startValue, String value) {
        try {
            String file = "history.txt";
            BufferedReader reader;
            try  {
                reader = new BufferedReader(new FileReader(file));
            }  catch (IOException noFileErr) {
                new PrintWriter("history.txt", StandardCharsets.UTF_8);
                reader = new BufferedReader(new FileReader(file));
            }
            String currentLine;
            ArrayList<String> oldHistory = new ArrayList<>();
            while ((currentLine = reader.readLine()) != null) {
                oldHistory.add(currentLine);
            }
            reader.close();
            PrintWriter writer = new PrintWriter("history.txt", StandardCharsets.UTF_8);
            writer.println(startValue + " = " + value);
            for(int i = oldHistory.toArray().length - 1;i >= 0;i--){
                writer.println(oldHistory.get(i));
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
