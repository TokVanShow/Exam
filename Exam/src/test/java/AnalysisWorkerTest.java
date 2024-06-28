import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import text_analysis.exam.AnalysisWorker;

public class AnalysisWorkerTest {

    /**
     * Проверяет, что метод calcFreq корректно вычисляет относительные частоты слов.
     */
    @Test
    public void testCalcFreq() {
        AnalysisWorker worker = new AnalysisWorker();
        ArrayList<String> text = new ArrayList<>();
        text.add("test");
        text.add("test");
        text.add("word");
        HashMap<String, Double> expected = new HashMap<>();
        expected.put("test", 0.66667);
        expected.put("word", 0.33334);
        assertEquals(expected, worker.calcFreq(text));
    }

    /**
     * Проверяет, что метод populateTable корректно заполняет модель таблицы частотами слов.
     */
    @Test
    public void testPopulateTable() {
        AnalysisWorker worker = new AnalysisWorker();
        HashMap<String, Double> frequency = new HashMap<>();
        frequency.put("test", 0.5);
        frequency.put("word", 0.5);
        DefaultTableModel model = new DefaultTableModel(new String[]{"Слово", "Частота"}, 0);
        worker.populateTable(model, frequency);
        assertEquals("test", model.getValueAt(0, 0));
        assertEquals(0.5, model.getValueAt(0, 1));
        assertEquals("word", model.getValueAt(1, 0));
        assertEquals(0.5, model.getValueAt(1, 1));
    }

    /**
     * Проверяет, что метод analyzeText корректно анализирует текст и обновляет таблицу и метки.
     */
    @Test
    public void testAnalyzeText() {
        AnalysisWorker worker = new AnalysisWorker();
        ArrayList<String> originalText = new ArrayList<>();
        originalText.add("test");
        originalText.add("word");
        ArrayList<String> processedText = new ArrayList<>();
        processedText.add("test");
        processedText.add("test");
        processedText.add("word");
        JTable freqTable = new JTable(new DefaultTableModel(new String[]{"Слово", "Частота"}, 0));
        JLabel numberWordsField = new JLabel();
        JLabel numberDelWordsField = new JLabel();
        JLabel popularWordField = new JLabel();
        JLabel unpopularWordField = new JLabel();
        
        worker.analyzeText(originalText, processedText, freqTable, numberWordsField, numberDelWordsField, popularWordField, unpopularWordField);
        
        assertEquals("Количество слов в исходном файле: 2", numberWordsField.getText());
        assertEquals("Количество удаленных слов в файле: -1", numberDelWordsField.getText());
        assertEquals("Самое часто встречающееся слово: test", popularWordField.getText());
        assertEquals("Самое редко встречающееся слово: word", unpopularWordField.getText());
        assertEquals("test", freqTable.getValueAt(0, 0));
        assertEquals(0.66667, freqTable.getValueAt(0, 1));
    }
}
