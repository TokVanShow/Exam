package text_analysis.exam;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

public class TextWorker {

    public ArrayList<String> changeText(ArrayList<String> text, ArrayList<String> ruStopWords, ArrayList<String> engStopWords,
            JRadioButtonMenuItem useRusButton, JRadioButtonMenuItem useEngButton,
            JCheckBoxMenuItem useRuStopWordsButton, JCheckBoxMenuItem useEngStopWordsButton,
            JCheckBox toLowerCaseButton, JCheckBox deleteSignsButton,
            JList<String> ruStopWordsList, JList<String> engStopWordsList) {
        
        if (toLowerCaseButton.isSelected()) {
            text = toLowerCase(text);
        }
        if (deleteSignsButton.isSelected()) {
            text = deleteSigns(text);
        }
        if (useRusButton.isSelected()) {
            text = deleteNotRus(text);
        }
        if (useEngButton.isSelected()) {
            text = deleteNotEng(text);
        }
        if (useRuStopWordsButton.isSelected()) {
            useStopWords(text, ruStopWords, ruStopWordsList);
        }
        if (useEngStopWordsButton.isSelected()) {
            useStopWords(text, engStopWords, engStopWordsList);
        }

        return text;
    }

    public ArrayList<String> toLowerCase(ArrayList<String> text) {
        ArrayList<String> newText = new ArrayList<>();
        for (String word : text) {
            newText.add(word.toLowerCase());
        }
        return newText;
    }

    public ArrayList<String> deleteSigns(ArrayList<String> text) {
        ArrayList<String> newText = new ArrayList<>();
        for (String word : text) {
            String cleanedWord = word.replaceAll("[^\\wа-я]", "").replaceAll("\\d", "");
            if (!cleanedWord.isEmpty()) {
                newText.add(cleanedWord);
            }
        }
        return newText;
    }

    public ArrayList<String> deleteNotRus(ArrayList<String> text) {
        ArrayList<String> newText = new ArrayList<>();
        for (String word : text) {
            String cleanedWord = word.replaceAll("[^а-я]", "");
            if (!cleanedWord.isEmpty()) {
                newText.add(cleanedWord);
            }
        }
        return newText;
    }

    public ArrayList<String> deleteNotEng(ArrayList<String> text) {
        ArrayList<String> newText = new ArrayList<>();
        for (String word : text) {
            String cleanedWord = word.replaceAll("[^a-z]", "");
            if (!cleanedWord.isEmpty()) {
                newText.add(cleanedWord);
            }
        }
        return newText;
    }

    public void useStopWords(ArrayList<String> text, ArrayList<String> stopWords, JList<String> stopWordsList) {
        List<String> selectedValues = stopWordsList.getSelectedValuesList();
        text.removeIf(word -> stopWords.contains(word) && !selectedValues.contains(word));
    }

    public DefaultListModel<String> createStopWordsList(ArrayList<String> stopWords) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String word : stopWords) {
            listModel.addElement(word);
        }
        return listModel;
    }

    public void importStopWords(ArrayList<String> ruStopWords, ArrayList<String> engStopWords,
            JList<String> ruStopWordsList, JList<String> engStopWordsList,
            JDialog uploadStopWordsMessage, JLabel stopwordsMessageLabel) {

        File selectedFile = chooseFile();
        if (selectedFile == null) {
            return;
        }

        if (!getFileExtension(selectedFile.getName()).equals("txt")) {
            JOptionPane.showMessageDialog(null, "Неверное расширение файла! Выберите файл txt", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            List<String> lines = Files.readAllLines(selectedFile.toPath(), Charset.forName("Windows-1251"));
            if (lines.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Файл пустой!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String firstLine = lines.get(0).trim().toUpperCase();
            if (!firstLine.equals("RU") && !firstLine.equals("ENG")) {
                JOptionPane.showMessageDialog(null, "Неверный формат файла! Первая строка должна быть 'RU' или 'ENG'", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<String> stopWords = lines.subList(1, lines.size());
            if (firstLine.equals("RU")) {
                updateStopWords(ruStopWords, stopWords, ruStopWordsList, stopwordsMessageLabel, "Русский список стоп-слов загружен!");
            } else {
                updateStopWords(engStopWords, stopWords, engStopWordsList, stopwordsMessageLabel, "Английский список стоп-слов загружен!");
            }

            showUploadStopWordsMessage(uploadStopWordsMessage);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка чтения файла!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private File chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Выбор файла со стоп-словами");
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int showDialog = fileChooser.showDialog(null, "Выбрать");
        return showDialog == JFileChooser.APPROVE_OPTION ? fileChooser.getSelectedFile() : null;
    }

    private void updateStopWords(ArrayList<String> stopWordsList, List<String> stopWords, JList<String> listComponent, JLabel messageLabel, String message) {
        stopWordsList.clear();
        stopWordsList.addAll(stopWords);
        listComponent.setListData(stopWordsList.toArray(new String[0]));
    }

    private void showUploadStopWordsMessage(JDialog uploadStopWordsMessage) {
        uploadStopWordsMessage.pack();
        uploadStopWordsMessage.setLocationRelativeTo(null);
        uploadStopWordsMessage.setVisible(true);
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
}
