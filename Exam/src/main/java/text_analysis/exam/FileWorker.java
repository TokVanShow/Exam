package text_analysis.exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Класс предоставляет методы для импорта текстовых данных из файла и экспорта
 * результатов анализа в файл Excel.
 */
public class FileWorker {

    private List<String> text;

    /**
     * Импортирует текст из указанного файла.
     *
     * @param path Путь к файлу.
     * @return Список строк, содержащих текст из файла.
     */
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

    /**
     * Экспортирует результаты анализа в файл Excel.
     *
     * @param path Путь к файлу для сохранения.
     * @param freq_table Модель таблицы с частотами слов.
     * @param NumberWordsField Метка для отображения количества слов.
     * @param NumberDelWordsField Метка для отображения количества удаленных слов.
     * @param PopularWordField Метка для отображения самого популярного слова.
     * @param UnpopularWordField Метка для отображения самого редкого слова.
     */
public void ExportResults(String path, DefaultTableModel freq_table, JLabel NumberWordsField, JLabel NumberDelWordsField, JLabel PopularWordField, JLabel UnpopularWordField) {
    try (XSSFWorkbook workbook = new XSSFWorkbook()) {
        XSSFSheet sheet = workbook.createSheet("Report");
        AtomicInteger rowIndex = new AtomicInteger(0);
        Row headerRow = sheet.createRow(rowIndex.getAndIncrement());
        for (int i = 0; i < freq_table.getColumnCount(); i++) {
            headerRow.createCell(i).setCellValue(freq_table.getColumnName(i));
        }
        for (int i = 0; i < freq_table.getRowCount(); i++) {
            XSSFRow row = sheet.createRow(rowIndex.getAndIncrement());
            for (int j = 0; j < freq_table.getColumnCount(); j++) {
                XSSFCell cell = row.createCell(j);
                cell.setCellValue(freq_table.getValueAt(i, j).toString());
            }
        }
        JLabel[] mass = new JLabel[]{NumberWordsField, NumberDelWordsField, PopularWordField, UnpopularWordField};
        for (int i = 0; i < 4; i++) {
            XSSFRow row1 = sheet.createRow(rowIndex.getAndIncrement());
            XSSFCell cell1 = row1.createCell(0);
            cell1.setCellValue(mass[i].getText());
        }

        String fileLocation = path + "/Report.xlsx";
        try (FileOutputStream outputStream = new FileOutputStream(fileLocation)) {
            workbook.write(outputStream);
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Ошибка в сохранении отчета!", "Oшибка", JOptionPane.ERROR_MESSAGE);
    }
}

}
