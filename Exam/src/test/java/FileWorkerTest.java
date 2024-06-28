import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import text_analysis.exam.FileWorker;

public class FileWorkerTest {

    /**
     * Проверяет, что метод importFile корректно импортирует текст из файла.
     */
    @Test
    public void testImportFile(@TempDir Path tempDir) throws IOException {
        FileWorker worker = new FileWorker();
        File file = tempDir.resolve("test.txt").toFile();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Hello world\nThis is a test file.");
        }
        List<String> text = worker.importFile(file.getAbsolutePath());
        assertEquals(7, text.size()); // обновлено до ожидаемого количества слов
        assertEquals("Hello", text.get(0));
        assertEquals("world", text.get(1));
        assertEquals("This", text.get(2));
        assertEquals("is", text.get(3));
        assertEquals("a", text.get(4));
        assertEquals("test", text.get(5));
        assertEquals("file.", text.get(6)); // обновлено до ожидаемого последнего слова
    }

    /**
     * Проверяет, что метод ExportResults корректно экспортирует результаты анализа в файл Excel.
     */
    @Test
    public void testExportResults(@TempDir Path tempDir) throws IOException {
        FileWorker worker = new FileWorker();
        String path = tempDir.toString();
        DefaultTableModel model = new DefaultTableModel(new Object[][]{
            {"test", 0.5},
            {"word", 0.5}
        }, new String[]{"Слово", "Частота"});
        JLabel numberWordsField = new JLabel("Количество слов: 2");
        JLabel numberDelWordsField = new JLabel("Количество удаленных слов: 0");
        JLabel popularWordField = new JLabel("Самое часто встречающееся слово: test");
        JLabel unpopularWordField = new JLabel("Самое редко встречающееся слово: word");

        worker.ExportResults(path, model, numberWordsField, numberDelWordsField, popularWordField, unpopularWordField);

        File reportFile = tempDir.resolve("Report.xlsx").toFile();
        assertTrue(reportFile.exists());
        // Дополнительные проверки содержимого файла Excel можно добавить здесь
    }
}
