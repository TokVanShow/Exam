import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import text_analysis.exam.TextWorker;

public class TextWorkerTest {

    /**
     * Проверяет, что метод toLowerCase корректно переводит все слова в нижний регистр.
     */
    @Test
    public void testToLowerCase() {
        TextWorker worker = new TextWorker();
        ArrayList<String> input = new ArrayList<>(Arrays.asList("Hello", "WORLD"));
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("hello", "world"));
        assertEquals(expected, worker.toLowerCase(input));
    }

    /**
     * Проверяет, что метод deleteSigns корректно удаляет знаки препинания и цифры из текста.
     */
    @Test
    public void testDeleteSigns() {
        TextWorker worker = new TextWorker();
        ArrayList<String> input = new ArrayList<>(Arrays.asList("hello!", "world123", "java@program"));
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("hello", "world", "javaprogram"));
        assertEquals(expected, worker.deleteSigns(input));
    }

    /**
     * Проверяет, что метод deleteNotRus корректно удаляет все не русские слова.
     */
    @Test
    public void testDeleteNotRus() {
        TextWorker worker = new TextWorker();
        ArrayList<String> input = new ArrayList<>(Arrays.asList("привет", "world", "мир"));
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("привет", "мир"));
        assertEquals(expected, worker.deleteNotRus(input));
    }

    /**
     * Проверяет, что метод deleteNotEng корректно удаляет все не английские слова.
     */
    @Test
    public void testDeleteNotEng() {
        TextWorker worker = new TextWorker();
        ArrayList<String> input = new ArrayList<>(Arrays.asList("hello", "мир", "world"));
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("hello", "world"));
        assertEquals(expected, worker.deleteNotEng(input));
    }

    /**
     * Проверяет, что метод useStopWords корректно удаляет стоп-слова из текста,
     * кроме тех, которые выделены в списке.
     */
    @Test
    public void testUseStopWords() {
        TextWorker worker = new TextWorker();
        ArrayList<String> input = new ArrayList<>(Arrays.asList("hello", "world", "java", "program"));
        ArrayList<String> stopWords = new ArrayList<>(Arrays.asList("world", "program"));
        JList<String> stopWordsList = new JList<>(new String[]{"java"});
        worker.useStopWords(input, stopWords, stopWordsList);
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("hello", "java"));
        assertEquals(expected, input);
    }

    /**
     * Проверяет, что метод createStopWordsList корректно создает список стоп-слов.
     */
    @Test
    public void testCreateStopWordsList() {
        TextWorker worker = new TextWorker();
        ArrayList<String> stopWords = new ArrayList<>(Arrays.asList("the", "and", "is"));
        DefaultListModel<String> listModel = worker.createStopWordsList(stopWords);
        assertEquals(3, listModel.size());
        assertEquals("the", listModel.get(0));
        assertEquals("and", listModel.get(1));
        assertEquals("is", listModel.get(2));
    }

    /**
     * Проверяет, что метод changeText корректно обрабатывает текст в соответствии с заданными параметрами.
     */
    @Test
    public void testChangeText() {
        TextWorker worker = new TextWorker();
        ArrayList<String> text = new ArrayList<>(Arrays.asList("Hello!", "This", "is", "a", "test123"));
        ArrayList<String> ruStopWords = new ArrayList<>(Arrays.asList("это", "тест"));
        ArrayList<String> engStopWords = new ArrayList<>(Arrays.asList("this", "is", "a"));
        JRadioButtonMenuItem useRusButton = new JRadioButtonMenuItem();
        JRadioButtonMenuItem useEngButton = new JRadioButtonMenuItem();
        JCheckBoxMenuItem useRuStopWordsButton = new JCheckBoxMenuItem();
        JCheckBoxMenuItem useEngStopWordsButton = new JCheckBoxMenuItem();
        JCheckBox toLowerCaseButton = new JCheckBox();
        JCheckBox deleteSignsButton = new JCheckBox();
        JList<String> ruStopWordsList = new JList<>();
        JList<String> engStopWordsList = new JList<>();

        toLowerCaseButton.setSelected(true);
        deleteSignsButton.setSelected(true);
        useEngButton.setSelected(true);
        useEngStopWordsButton.setSelected(true);

        ArrayList<String> expected = new ArrayList<>(Arrays.asList("hello", "test"));
        ArrayList<String> result = worker.changeText(text, ruStopWords, engStopWords, useRusButton, useEngButton, useRuStopWordsButton, useEngStopWordsButton, toLowerCaseButton, deleteSignsButton, ruStopWordsList, engStopWordsList);
        assertEquals(expected, result);
    }
}
