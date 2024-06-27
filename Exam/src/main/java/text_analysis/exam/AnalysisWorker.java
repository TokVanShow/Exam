package text_analysis.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AnalysisWorker {

    public HashMap<String, Double> calcFreq(ArrayList<String> text) {
        HashMap<String, Double> frequency = new HashMap<>();
        double scale = Math.pow(10, 5);

        // Calculate raw frequencies
        for (String word : text) {
            frequency.put(word, frequency.getOrDefault(word, 0.0) + 1.0);
        }

        // Calculate relative frequencies
        for (String key : frequency.keySet()) {
            double freq = Math.ceil(frequency.get(key) / text.size() * scale) / scale;
            frequency.put(key, freq);
        }

        // Sort frequencies in descending order
        return frequency.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public DefaultTableModel populateTable(DefaultTableModel freqTableModel, HashMap<String, Double> frequency) {
        for (Map.Entry<String, Double> entry : frequency.entrySet()) {
            freqTableModel.addRow(new Object[]{entry.getKey(), entry.getValue()});
        }
        return freqTableModel;
    }

    public void analyzeText(ArrayList<String> originalText, ArrayList<String> processedText, JTable freqTable,
            JLabel numberWordsField, JLabel numberDelWordsField,
            JLabel popularWordField, JLabel unpopularWordField) {

        HashMap<String, Double> frequency = calcFreq(processedText);
        DefaultTableModel freqTableModel = (DefaultTableModel) freqTable.getModel();

        // Clear existing table data
        freqTableModel.setRowCount(0);

        // Populate table with new frequency data
        populateTable(freqTableModel, frequency);

        // Update labels with analysis results
        updateLabels(originalText, processedText, freqTableModel, numberWordsField, numberDelWordsField, popularWordField, unpopularWordField);
    }

    private void updateLabels(ArrayList<String> originalText, ArrayList<String> processedText,
            DefaultTableModel freqTableModel, JLabel numberWordsField,
            JLabel numberDelWordsField, JLabel popularWordField, JLabel unpopularWordField) {

        numberWordsField.setText("Количество слов в исходном файле: " + originalText.size());
        numberDelWordsField.setText("Количество удаленных слов в файле: " + (originalText.size() - processedText.size()));

        if (freqTableModel.getRowCount() > 0) {
            Object popularWord = freqTableModel.getValueAt(0, 0);
            Object unpopularWord = freqTableModel.getValueAt(freqTableModel.getRowCount() - 1, 0);

            popularWordField.setText("Самое часто встречающееся слово: " + popularWord);
            unpopularWordField.setText("Самое редко встречающееся слово: " + unpopularWord);
        } else {
            popularWordField.setText("Самое часто встречающееся слово: нет данных");
            unpopularWordField.setText("Самое редко встречающееся слово: нет данных");
        }
    }
}
