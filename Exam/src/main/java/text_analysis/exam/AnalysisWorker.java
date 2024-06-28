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

/**
 * Класс предоставляет методы для анализа текстовых данных, вычисления частот слов,
 * а также обновления JTable с данными частот. Также обновляет компоненты JLabel
 * с результатами анализа.
 */
public class AnalysisWorker {

    /**
     * Вычисляет относительную частоту каждого слова в данном тексте.
     *
     * @param text Список слов для анализа.
     * @return HashMap, содержащий слова в качестве ключей и их относительные частоты в качестве значений.
     */
    public HashMap<String, Double> calcFreq(ArrayList<String> text) {
        HashMap<String, Double> frequency = new HashMap<>();
        double scale = Math.pow(10, 5);

        // Вычисление сырых частот
        for (String word : text) {
            frequency.put(word, frequency.getOrDefault(word, 0.0) + 1.0);
        }

        // Вычисление относительных частот
        for (String key : frequency.keySet()) {
            double freq = Math.ceil(frequency.get(key) / text.size() * scale) / scale;
            frequency.put(key, freq);
        }

        // Сортировка частот в порядке убывания
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

    /**
     * Заполняет переданную модель таблицы данными частот слов.
     *
     * @param freqTableModel Модель таблицы для заполнения.
     * @param frequency Данные частот для заполнения таблицы.
     * @return Заполненная модель таблицы.
     */
    public DefaultTableModel populateTable(DefaultTableModel freqTableModel, HashMap<String, Double> frequency) {
        for (Map.Entry<String, Double> entry : frequency.entrySet()) {
            freqTableModel.addRow(new Object[]{entry.getKey(), entry.getValue()});
        }
        return freqTableModel;
    }

    /**
     * Анализирует текст и обновляет компоненты JTable и JLabel с результатами анализа.
     *
     * @param originalText Исходный текст.
     * @param processedText Обработанный текст.
     * @param freqTable Таблица для отображения частот.
     * @param numberWordsField Метка для отображения количества слов.
     * @param numberDelWordsField Метка для отображения количества удаленных слов.
     * @param popularWordField Метка для отображения самого популярного слова.
     * @param unpopularWordField Метка для отображения самого редкого слова.
     */
    public void analyzeText(ArrayList<String> originalText, ArrayList<String> processedText, JTable freqTable,
            JLabel numberWordsField, JLabel numberDelWordsField,
            JLabel popularWordField, JLabel unpopularWordField) {

        HashMap<String, Double> frequency = calcFreq(processedText);
        DefaultTableModel freqTableModel = (DefaultTableModel) freqTable.getModel();

        // Очистка данных таблицы
        freqTableModel.setRowCount(0);

        // Заполнение таблицы новыми данными частот
        populateTable(freqTableModel, frequency);

        // Обновление меток с результатами анализа
        updateLabels(originalText, processedText, freqTableModel, numberWordsField, numberDelWordsField, popularWordField, unpopularWordField);
    }

    /**
     * Обновляет метки с результатами анализа текста.
     *
     * @param originalText Исходный текст.
     * @param processedText Обработанный текст.
     * @param freqTableModel Модель таблицы с частотами слов.
     * @param numberWordsField Метка для отображения количества слов.
     * @param numberDelWordsField Метка для отображения количества удаленных слов.
     * @param popularWordField Метка для отображения самого популярного слова.
     * @param unpopularWordField Метка для отображения самого редкого слова.
     */
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
