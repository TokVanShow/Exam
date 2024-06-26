package text_analysis.exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FileWorker {

    private List<String> text;

    public List<String> importFile(String path) {
        text = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "Cp1251"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        text.add(word);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка в чтении файла!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        return text;
    }
}

