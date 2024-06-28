package text_analysis.exam;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class JFrame extends javax.swing.JFrame {

    public JFrame() {
        initComponents();
        textWorker = new TextWorker();

        allCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                boolean selected = (e.getStateChange() == ItemEvent.SELECTED);
                singleRegisterCB.setSelected(selected);
                removeNumbersCB.setSelected(selected);
                singleRegisterCB.setEnabled(!selected);
                removeNumbersCB.setEnabled(!selected);
            }
        });
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        MainJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        MainJFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        String gifPath = System.getProperty("user.dir") + "/resources/Welcome.gif";
        File gifFile = new File(gifPath);

        if (gifFile.exists() && !gifFile.isDirectory()) {
            ImageIcon gif = new ImageIcon(gifPath);
            welcomeLabel.setIcon(gif);
        } else {
            System.out.println("Файл не найден: " + gifPath);
        }

        loadingFrame.pack();
        loadingFrame.setLocationRelativeTo(null); // Центрируем окно на экране
    }
    
    ArrayList<String> text;
    ArrayList<String> changed_text;
    ArrayList<String> ru_stop_words;
    ArrayList<String> eng_stop_words;

    DefaultTableModel freq_table;
    FileWorker fileWorker;
    TextWorker textWorker;
    AnalysisWorker analyst;
    String gifPath = System.getProperty("user.dir") + "/resources/Welcome.gif";
        File gifFile = new File(gifPath);


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guide = new javax.swing.JDialog();
        guidePanel = new javax.swing.JPanel();
        exitFromGuideButton = new javax.swing.JButton();
        guideLabel1 = new javax.swing.JLabel();
        guideLabel2 = new javax.swing.JLabel();
        guideLabel3 = new javax.swing.JLabel();
        guideLabel4 = new javax.swing.JLabel();
        guideLabel5 = new javax.swing.JLabel();
        guideLabel6 = new javax.swing.JLabel();
        guideLabel7 = new javax.swing.JLabel();
        guideLabel8 = new javax.swing.JLabel();
        guideLabel9 = new javax.swing.JLabel();
        guideLabel10 = new javax.swing.JLabel();
        guideLabel11 = new javax.swing.JLabel();
        MainJFrame = new javax.swing.JFrame();
        mainPanel = new javax.swing.JPanel();
        scrollPanel = new javax.swing.JScrollPane();
        FreqTable = new javax.swing.JTable();
        numberDelWordsField = new javax.swing.JLabel();
        popularWordField = new javax.swing.JLabel();
        unpopularWordField = new javax.swing.JLabel();
        numberWordsField = new javax.swing.JLabel();
        guideButton = new javax.swing.JButton();
        singleRegisterCB = new javax.swing.JCheckBox();
        removeNumbersCB = new javax.swing.JCheckBox();
        allCB = new javax.swing.JCheckBox();
        menu = new javax.swing.JMenuBar();
        loadStopWord = new javax.swing.JMenu();
        importButton = new javax.swing.JMenuItem();
        importStopWords = new javax.swing.JMenuItem();
        analyzeButton = new javax.swing.JMenuItem();
        exportButton = new javax.swing.JMenuItem();
        exitButton = new javax.swing.JMenuItem();
        settingsMenu = new javax.swing.JMenu();
        useStopWords = new javax.swing.JMenu();
        useRuStopWordsButton = new javax.swing.JCheckBoxMenuItem();
        editRuStopWordsButton = new javax.swing.JMenuItem();
        useEngStopWordsButton = new javax.swing.JCheckBoxMenuItem();
        editEngStopWordsButton = new javax.swing.JMenuItem();
        moreSettingsMenu = new javax.swing.JMenu();
        useEngButton = new javax.swing.JRadioButtonMenuItem();
        useRusButton = new javax.swing.JRadioButtonMenuItem();
        deleteSelectionsButton = new javax.swing.JMenuItem();
        ruStopWordsFrame = new javax.swing.JFrame();
        ruStopWordsScrollPanel = new javax.swing.JScrollPane();
        ruStopWordsList = new javax.swing.JList<>();
        engStopWordsFrame = new javax.swing.JFrame();
        engStopWordsScrollPanel = new javax.swing.JScrollPane();
        engStopWordsList = new javax.swing.JList<>();
        uploadFileMessage = new javax.swing.JDialog();
        uploadFilePanel = new javax.swing.JPanel();
        uploadMessageLabel = new javax.swing.JLabel();
        okUploadFileButton = new javax.swing.JButton();
        saveReportMessage = new javax.swing.JDialog();
        savePanel = new javax.swing.JPanel();
        saveMessageLabel = new javax.swing.JLabel();
        okSaveReportButton = new javax.swing.JButton();
        uploadStopWordsMessage = new javax.swing.JDialog();
        uploadWordsPanel = new javax.swing.JPanel();
        stopwordsMessageLabel = new javax.swing.JLabel();
        okUploadStopWordsButton = new javax.swing.JButton();
        loadingFrame = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        loadingLabel1 = new javax.swing.JLabel();
        loadingLabel2 = new javax.swing.JLabel();
        gifLabel = new javax.swing.JLabel();
        group = new javax.swing.ButtonGroup();
        startFrame = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        welcomeLabel2 = new javax.swing.JLabel();
        welcomeLabel3 = new javax.swing.JLabel();
        welcomeLabel1 = new javax.swing.JLabel();

        guidePanel.setBackground(new java.awt.Color(0, 0, 0));

        exitFromGuideButton.setBackground(new java.awt.Color(204, 0, 0));
        exitFromGuideButton.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        exitFromGuideButton.setText("OK");
        exitFromGuideButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exitFromGuideButton.setFocusPainted(false);
        exitFromGuideButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitFromGuideButton.setPreferredSize(new java.awt.Dimension(25, 25));
        exitFromGuideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitFromGuideButtonActionPerformed(evt);
            }
        });

        guideLabel1.setBackground(new java.awt.Color(153, 0, 0));
        guideLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        guideLabel1.setForeground(new java.awt.Color(153, 0, 0));
        guideLabel1.setText("Инструкция");

        guideLabel2.setBackground(new java.awt.Color(0, 0, 0));
        guideLabel2.setForeground(new java.awt.Color(204, 0, 0));
        guideLabel2.setText("1. В главном меню \"Файл\" нажмите кнопку \"Загрузить файл\" и загрузите файл txt для анализа.");

        guideLabel3.setBackground(new java.awt.Color(0, 0, 0));
        guideLabel3.setForeground(new java.awt.Color(204, 0, 0));
        guideLabel3.setText("2. В меню \"Настройки\" можно применить фильтр для очистки текста от стоп-слов, ");

        guideLabel4.setForeground(new java.awt.Color(204, 0, 0));
        guideLabel4.setText("а в расширенных настройках есть функция использования только русского или английского языка. ");

        guideLabel5.setForeground(new java.awt.Color(204, 0, 0));
        guideLabel5.setText("Если вы хотите применить удаление стоп-слов, то загрузите файл со стоп-словами как в пункте 1.");

        guideLabel6.setForeground(new java.awt.Color(204, 0, 0));
        guideLabel6.setText("3. Нажмите кнопку \"Провести анализ\". В результате появится таблица со списком слов и их частотами и ");

        guideLabel7.setForeground(new java.awt.Color(204, 0, 0));
        guideLabel7.setText("основная информация о выполненном анализе текста.");

        guideLabel8.setForeground(new java.awt.Color(204, 0, 0));
        guideLabel8.setText("выбрав опцию \"Использовать стоп-слова\" для удаления лишних слов из текста,");

        guideLabel9.setForeground(new java.awt.Color(204, 0, 0));
        guideLabel9.setText("4. Нажмите кнопку \"Сохранить отчет\", если вы хотите сохранить выполненный анализ текст. ");

        guideLabel10.setForeground(new java.awt.Color(204, 0, 0));
        guideLabel10.setText("+  Также нажав кнопку \"Редактировать стоп-слова\", вы можете выделить стоп-слова, которые");

        guideLabel11.setForeground(new java.awt.Color(204, 0, 0));
        guideLabel11.setText("не будут учитываться при фильтрации текста.");

        javax.swing.GroupLayout guidePanelLayout = new javax.swing.GroupLayout(guidePanel);
        guidePanel.setLayout(guidePanelLayout);
        guidePanelLayout.setHorizontalGroup(
            guidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guidePanelLayout.createSequentialGroup()
                .addGroup(guidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(guidePanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(guidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guideLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                            .addComponent(guideLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(guidePanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(guidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(guideLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(guideLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(guideLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                            .addComponent(guideLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(guidePanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(guidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(guidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(guideLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(guideLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(guidePanelLayout.createSequentialGroup()
                                .addComponent(guideLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(exitFromGuideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(guidePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(guideLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, guidePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guideLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265))
        );
        guidePanelLayout.setVerticalGroup(
            guidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guidePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(guideLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guideLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guideLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guideLabel8)
                .addGap(8, 8, 8)
                .addComponent(guideLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guideLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guideLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guideLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guideLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guideLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(guidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guideLabel9)
                    .addComponent(exitFromGuideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout guideLayout = new javax.swing.GroupLayout(guide.getContentPane());
        guide.getContentPane().setLayout(guideLayout);
        guideLayout.setHorizontalGroup(
            guideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(guidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        guideLayout.setVerticalGroup(
            guideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(guidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MainJFrame.setBackground(new java.awt.Color(0, 0, 0));

        mainPanel.setBackground(new java.awt.Color(0, 0, 0));
        mainPanel.setForeground(new java.awt.Color(0, 0, 0));
        mainPanel.setPreferredSize(new java.awt.Dimension(450, 412));

        scrollPanel.setBackground(new java.awt.Color(153, 0, 0));
        scrollPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        scrollPanel.setForeground(new java.awt.Color(255, 51, 51));

        FreqTable.setBackground(new java.awt.Color(153, 0, 0));
        FreqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Слово", "Частота"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPanel.setViewportView(FreqTable);

        numberDelWordsField.setForeground(new java.awt.Color(204, 0, 0));

        popularWordField.setForeground(new java.awt.Color(204, 0, 0));

        unpopularWordField.setForeground(new java.awt.Color(204, 0, 0));

        numberWordsField.setForeground(new java.awt.Color(204, 0, 0));

        guideButton.setBackground(new java.awt.Color(153, 0, 0));
        guideButton.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        guideButton.setText("?");
        guideButton.setBorder(null);
        guideButton.setFocusPainted(false);
        guideButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guideButton.setPreferredSize(new java.awt.Dimension(30, 30));
        guideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guideButtonActionPerformed(evt);
            }
        });

        singleRegisterCB.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        singleRegisterCB.setForeground(new java.awt.Color(204, 0, 0));
        singleRegisterCB.setText("to a single register");
        singleRegisterCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleRegisterCBActionPerformed(evt);
            }
        });

        removeNumbersCB.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        removeNumbersCB.setForeground(new java.awt.Color(204, 0, 0));
        removeNumbersCB.setText("removing numbers and signs");

        allCB.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        allCB.setForeground(new java.awt.Color(229, 0, 0));
        allCB.setText("All at once");
        allCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(unpopularWordField, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                        .addComponent(popularWordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numberDelWordsField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numberWordsField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guideButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addComponent(singleRegisterCB)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(allCB)
                            .addGap(11, 11, 11)))
                    .addComponent(removeNumbersCB))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(guideButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(numberWordsField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(numberDelWordsField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(popularWordField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(unpopularWordField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(singleRegisterCB)
                            .addComponent(allCB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeNumbersCB)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
                .addContainerGap())
        );

        menu.setBackground(new java.awt.Color(0, 0, 0));
        menu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        menu.setForeground(new java.awt.Color(0, 0, 0));
        menu.setAlignmentX(1.0F);
        menu.setPreferredSize(new java.awt.Dimension(95, 35));

        loadStopWord.setBackground(new java.awt.Color(0, 0, 0));
        loadStopWord.setForeground(new java.awt.Color(204, 0, 0));
        loadStopWord.setText("        File        ");
        loadStopWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadStopWord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        importButton.setForeground(new java.awt.Color(153, 0, 0));
        importButton.setText("Загрузить файл");
        importButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });
        loadStopWord.add(importButton);

        importStopWords.setForeground(new java.awt.Color(153, 0, 0));
        importStopWords.setText("Загрузить \"стоп-слово\"");
        importStopWords.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        importStopWords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importStopWordsActionPerformed(evt);
            }
        });
        loadStopWord.add(importStopWords);

        analyzeButton.setForeground(new java.awt.Color(153, 0, 0));
        analyzeButton.setText("Провести анализ");
        analyzeButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        analyzeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyzeButtonActionPerformed(evt);
            }
        });
        loadStopWord.add(analyzeButton);

        exportButton.setForeground(new java.awt.Color(153, 0, 0));
        exportButton.setText("Сохранить отчет");
        exportButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });
        loadStopWord.add(exportButton);

        exitButton.setForeground(new java.awt.Color(153, 0, 0));
        exitButton.setText("Выход");
        exitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        loadStopWord.add(exitButton);

        menu.add(loadStopWord);

        settingsMenu.setBackground(new java.awt.Color(0, 0, 0));
        settingsMenu.setForeground(new java.awt.Color(204, 0, 0));
        settingsMenu.setText("Settings");
        settingsMenu.setActionCommand("    Настройки    ");
        settingsMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingsMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        useStopWords.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        useStopWords.setForeground(new java.awt.Color(153, 0, 0));
        useStopWords.setText("Использовать стоп-слова");

        useRuStopWordsButton.setForeground(new java.awt.Color(153, 0, 0));
        useRuStopWordsButton.setText("Русские стоп-слова");
        useRuStopWordsButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        useRuStopWordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useRuStopWordsButtonActionPerformed(evt);
            }
        });
        useStopWords.add(useRuStopWordsButton);

        editRuStopWordsButton.setForeground(new java.awt.Color(153, 0, 0));
        editRuStopWordsButton.setText("Редактировать русские стоп-слова");
        editRuStopWordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRuStopWordsButtonActionPerformed(evt);
            }
        });
        useStopWords.add(editRuStopWordsButton);

        useEngStopWordsButton.setForeground(new java.awt.Color(153, 0, 0));
        useEngStopWordsButton.setText("Английские стоп-слова");
        useEngStopWordsButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        useEngStopWordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useEngStopWordsButtonActionPerformed(evt);
            }
        });
        useStopWords.add(useEngStopWordsButton);

        editEngStopWordsButton.setForeground(new java.awt.Color(153, 0, 0));
        editEngStopWordsButton.setText("Редактировать английские стоп-слова");
        editEngStopWordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEngStopWordsButtonActionPerformed(evt);
            }
        });
        useStopWords.add(editEngStopWordsButton);

        settingsMenu.add(useStopWords);

        moreSettingsMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        moreSettingsMenu.setForeground(new java.awt.Color(153, 0, 0));
        moreSettingsMenu.setText("Расширенные настройки");

        useEngButton.setForeground(new java.awt.Color(153, 0, 0));
        useEngButton.setText("Очистить русский язык");
        useEngButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        useEngButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useEngButtonActionPerformed(evt);
            }
        });
        moreSettingsMenu.add(useEngButton);

        useRusButton.setForeground(new java.awt.Color(153, 0, 0));
        useRusButton.setText("Очистить английский язык");
        useRusButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        useRusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useRusButtonActionPerformed(evt);
            }
        });
        moreSettingsMenu.add(useRusButton);

        deleteSelectionsButton.setForeground(new java.awt.Color(153, 0, 0));
        deleteSelectionsButton.setText("Отменить выбор");
        deleteSelectionsButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteSelectionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectionsButtonActionPerformed(evt);
            }
        });
        moreSettingsMenu.add(deleteSelectionsButton);

        settingsMenu.add(moreSettingsMenu);

        menu.add(settingsMenu);

        MainJFrame.setJMenuBar(menu);

        javax.swing.GroupLayout MainJFrameLayout = new javax.swing.GroupLayout(MainJFrame.getContentPane());
        MainJFrame.getContentPane().setLayout(MainJFrameLayout);
        MainJFrameLayout.setHorizontalGroup(
            MainJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        MainJFrameLayout.setVerticalGroup(
            MainJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        ruStopWordsScrollPanel.setViewportView(ruStopWordsList);

        javax.swing.GroupLayout ruStopWordsFrameLayout = new javax.swing.GroupLayout(ruStopWordsFrame.getContentPane());
        ruStopWordsFrame.getContentPane().setLayout(ruStopWordsFrameLayout);
        ruStopWordsFrameLayout.setHorizontalGroup(
            ruStopWordsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ruStopWordsScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        ruStopWordsFrameLayout.setVerticalGroup(
            ruStopWordsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ruStopWordsScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        engStopWordsScrollPanel.setViewportView(engStopWordsList);

        javax.swing.GroupLayout engStopWordsFrameLayout = new javax.swing.GroupLayout(engStopWordsFrame.getContentPane());
        engStopWordsFrame.getContentPane().setLayout(engStopWordsFrameLayout);
        engStopWordsFrameLayout.setHorizontalGroup(
            engStopWordsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(engStopWordsScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        engStopWordsFrameLayout.setVerticalGroup(
            engStopWordsFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(engStopWordsScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        uploadFileMessage.setBackground(new java.awt.Color(0, 0, 0));

        uploadFilePanel.setBackground(new java.awt.Color(0, 0, 0));
        uploadFilePanel.setForeground(new java.awt.Color(0, 0, 0));

        uploadMessageLabel.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        uploadMessageLabel.setForeground(new java.awt.Color(204, 0, 0));
        uploadMessageLabel.setText("The file for analysis is up!");

        okUploadFileButton.setBackground(new java.awt.Color(204, 0, 0));
        okUploadFileButton.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        okUploadFileButton.setForeground(new java.awt.Color(255, 255, 255));
        okUploadFileButton.setText("OK");
        okUploadFileButton.setBorder(null);
        okUploadFileButton.setFocusPainted(false);
        okUploadFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okUploadFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout uploadFilePanelLayout = new javax.swing.GroupLayout(uploadFilePanel);
        uploadFilePanel.setLayout(uploadFilePanelLayout);
        uploadFilePanelLayout.setHorizontalGroup(
            uploadFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadFilePanelLayout.createSequentialGroup()
                .addGroup(uploadFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(uploadFilePanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(uploadMessageLabel))
                    .addGroup(uploadFilePanelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(okUploadFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        uploadFilePanelLayout.setVerticalGroup(
            uploadFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadFilePanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(uploadMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(okUploadFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout uploadFileMessageLayout = new javax.swing.GroupLayout(uploadFileMessage.getContentPane());
        uploadFileMessage.getContentPane().setLayout(uploadFileMessageLayout);
        uploadFileMessageLayout.setHorizontalGroup(
            uploadFileMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(uploadFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        uploadFileMessageLayout.setVerticalGroup(
            uploadFileMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(uploadFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        saveReportMessage.setBackground(new java.awt.Color(0, 0, 0));

        savePanel.setBackground(new java.awt.Color(0, 0, 0));
        savePanel.setForeground(new java.awt.Color(0, 0, 0));

        saveMessageLabel.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        saveMessageLabel.setForeground(new java.awt.Color(204, 0, 0));
        saveMessageLabel.setText("Report Save");

        okSaveReportButton.setBackground(new java.awt.Color(204, 0, 0));
        okSaveReportButton.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        okSaveReportButton.setText("OK");
        okSaveReportButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        okSaveReportButton.setFocusPainted(false);
        okSaveReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okSaveReportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout savePanelLayout = new javax.swing.GroupLayout(savePanel);
        savePanel.setLayout(savePanelLayout);
        savePanelLayout.setHorizontalGroup(
            savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savePanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(saveMessageLabel)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, savePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okSaveReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        savePanelLayout.setVerticalGroup(
            savePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(saveMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(okSaveReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout saveReportMessageLayout = new javax.swing.GroupLayout(saveReportMessage.getContentPane());
        saveReportMessage.getContentPane().setLayout(saveReportMessageLayout);
        saveReportMessageLayout.setHorizontalGroup(
            saveReportMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(savePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        saveReportMessageLayout.setVerticalGroup(
            saveReportMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(savePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        uploadStopWordsMessage.setBackground(new java.awt.Color(255, 255, 255));

        uploadWordsPanel.setBackground(new java.awt.Color(0, 0, 0));

        stopwordsMessageLabel.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        stopwordsMessageLabel.setForeground(new java.awt.Color(204, 0, 0));
        stopwordsMessageLabel.setText("The file is loaded with stop words");

        okUploadStopWordsButton.setBackground(new java.awt.Color(204, 0, 0));
        okUploadStopWordsButton.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        okUploadStopWordsButton.setText("OK");
        okUploadStopWordsButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        okUploadStopWordsButton.setFocusPainted(false);
        okUploadStopWordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okUploadStopWordsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout uploadWordsPanelLayout = new javax.swing.GroupLayout(uploadWordsPanel);
        uploadWordsPanel.setLayout(uploadWordsPanelLayout);
        uploadWordsPanelLayout.setHorizontalGroup(
            uploadWordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadWordsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stopwordsMessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(uploadWordsPanelLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(okUploadStopWordsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        uploadWordsPanelLayout.setVerticalGroup(
            uploadWordsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadWordsPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(stopwordsMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(okUploadStopWordsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout uploadStopWordsMessageLayout = new javax.swing.GroupLayout(uploadStopWordsMessage.getContentPane());
        uploadStopWordsMessage.getContentPane().setLayout(uploadStopWordsMessageLayout);
        uploadStopWordsMessageLayout.setHorizontalGroup(
            uploadStopWordsMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(uploadWordsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        uploadStopWordsMessageLayout.setVerticalGroup(
            uploadStopWordsMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(uploadWordsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        loadingFrame.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        loadingLabel1.setFont(new java.awt.Font("Algerian", 1, 15)); // NOI18N
        loadingLabel1.setForeground(new java.awt.Color(204, 0, 0));
        loadingLabel1.setText("The text is being analyzed...");

        loadingLabel2.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        loadingLabel2.setForeground(new java.awt.Color(204, 0, 0));
        loadingLabel2.setText("Look into the darkness and it will start looking at you");

        gifLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loadingLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(loadingLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gifLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(loadingLabel1)
                .addGap(12, 12, 12)
                .addComponent(loadingLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gifLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout loadingFrameLayout = new javax.swing.GroupLayout(loadingFrame.getContentPane());
        loadingFrame.getContentPane().setLayout(loadingFrameLayout);
        loadingFrameLayout.setHorizontalGroup(
            loadingFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        loadingFrameLayout.setVerticalGroup(
            loadingFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startFrame.setBackground(new java.awt.Color(0, 0, 0));
        startFrame.setForeground(new java.awt.Color(204, 0, 0));
        startFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        startButton.setBackground(new java.awt.Color(204, 0, 0));
        startButton.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        startButton.setForeground(new java.awt.Color(0, 0, 0));
        startButton.setText("Start");
        startButton.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        welcomeLabel2.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        welcomeLabel2.setForeground(new java.awt.Color(204, 0, 0));
        welcomeLabel2.setText("This program will allow you to analyze text ");

        welcomeLabel3.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        welcomeLabel3.setForeground(new java.awt.Color(204, 0, 0));
        welcomeLabel3.setText("and thus take one step closer to reaching Lord Maximov");

        welcomeLabel1.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        welcomeLabel1.setForeground(new java.awt.Color(204, 0, 0));
        welcomeLabel1.setText("Dear User");

        javax.swing.GroupLayout startFrameLayout = new javax.swing.GroupLayout(startFrame);
        startFrame.setLayout(startFrameLayout);
        startFrameLayout.setHorizontalGroup(
            startFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startFrameLayout.createSequentialGroup()
                .addGroup(startFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(startFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(welcomeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(startFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(welcomeLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(startFrameLayout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(startFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(startFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(startFrameLayout.createSequentialGroup()
                        .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(startFrameLayout.createSequentialGroup()
                        .addComponent(welcomeLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(201, 201, 201))))
        );
        startFrameLayout.setVerticalGroup(
            startFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(welcomeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(welcomeLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(welcomeLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(startFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(startFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        MainJFrame.setVisible(true);
        MainJFrame.setBounds(200, 100, 850, 700);
        JComponent comp = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }//GEN-LAST:event_startButtonActionPerformed

    private void exitFromGuideButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitFromGuideButtonActionPerformed
        guide.dispose();
    }//GEN-LAST:event_exitFromGuideButtonActionPerformed

    private void guideButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guideButtonActionPerformed
        guide.setVisible(true);
        guide.setBounds(300, 200, 660, 390);
    }//GEN-LAST:event_guideButtonActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        fileWorker = new FileWorker();

        JFileChooser filechooser = new JFileChooser();
        filechooser.setDialogTitle("Выбор файлов");
        filechooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int showDialog = filechooser.showDialog(null, "Выбрать");
        if (showDialog == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filechooser.getSelectedFile();
            String extension = getFileExtension(selectedFile.toString());
            if (extension.equals("txt")) {
                text = (ArrayList<String>) fileWorker.importFile(selectedFile.toString());
                uploadFileMessage.setVisible(true);
                uploadFileMessage.setBounds(300, 300, 230, 150);
            } else {
                JOptionPane.showMessageDialog(null, "Неверное расширение файла! Выберите файл txt", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        } else if (showDialog == JFileChooser.CANCEL_OPTION) {
            filechooser.setVisible(false);
        }
    }//GEN-LAST:event_importButtonActionPerformed

    private void analyzeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyzeButtonActionPerformed
        analyst = new AnalysisWorker();
        textWorker = new TextWorker();
        try {
            changed_text = new ArrayList<>();
            changed_text = textWorker.changeText(text, ru_stop_words, eng_stop_words, useRusButton,
                    useEngButton, useRuStopWordsButton, useEngStopWordsButton, singleRegisterCB, removeNumbersCB, ruStopWordsList, engStopWordsList);
            if (!changed_text.isEmpty()) {
                loadingProcess();
                timer.setRepeats(false);
                timer.start();

                analyst.analyzeText(text, changed_text, FreqTable, numberWordsField, numberDelWordsField, popularWordField, unpopularWordField);
            } else {
                JOptionPane.showMessageDialog(null, "Вы удалили все слова!", "Oшибка", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при анализе текста!", "Oшибка", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_analyzeButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        fileWorker = new FileWorker();
        JFileChooser filechooser = new JFileChooser();
        filechooser.setDialogTitle("Выбор папки");
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        filechooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int showDialog = filechooser.showDialog(this, "Выбрать");
        if (showDialog == JFileChooser.APPROVE_OPTION) {
            String selectedFile = filechooser.getSelectedFile().toString();
            freq_table = (DefaultTableModel) FreqTable.getModel();
            fileWorker.ExportResults(selectedFile, freq_table, numberWordsField, numberDelWordsField, popularWordField, unpopularWordField);

            saveReportMessage.setVisible(true);
            saveReportMessage.setBounds(300, 300, 200, 150);
        } else if (showDialog == JFileChooser.CANCEL_OPTION) {
            filechooser.setVisible(false);
        }
    }//GEN-LAST:event_exportButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void useRuStopWordsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useRuStopWordsButtonActionPerformed
        if (useRuStopWordsButton.getState() && ru_stop_words == null) {
            JOptionPane.showMessageDialog(null, "Вы не выбрали файл со стоп-словами!", "Oшибка", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_useRuStopWordsButtonActionPerformed

    private void editRuStopWordsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRuStopWordsButtonActionPerformed
        ruStopWordsFrame.setVisible(true);
        ruStopWordsFrame.setBounds(300, 200, 400, 300);
    }//GEN-LAST:event_editRuStopWordsButtonActionPerformed

    private void useEngStopWordsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useEngStopWordsButtonActionPerformed
        if (useEngStopWordsButton.getState() && eng_stop_words == null) {
            JOptionPane.showMessageDialog(null, "Вы не выбрали файл со стоп-словами!", "Oшибка", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_useEngStopWordsButtonActionPerformed

    private void editEngStopWordsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEngStopWordsButtonActionPerformed
        engStopWordsFrame.setVisible(true);
        engStopWordsFrame.setBounds(300, 200, 400, 300);
    }//GEN-LAST:event_editEngStopWordsButtonActionPerformed

    private void useEngButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useEngButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useEngButtonActionPerformed

    private void useRusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useRusButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useRusButtonActionPerformed

    private void deleteSelectionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSelectionsButtonActionPerformed
        group.add(useEngButton);
        group.add(useRusButton);
        group.clearSelection();
    }//GEN-LAST:event_deleteSelectionsButtonActionPerformed

    private void okSaveReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okSaveReportButtonActionPerformed
        saveReportMessage.dispose();
    }//GEN-LAST:event_okSaveReportButtonActionPerformed

    private void okUploadFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okUploadFileButtonActionPerformed
        uploadFileMessage.dispose();
    }//GEN-LAST:event_okUploadFileButtonActionPerformed

    private void okUploadStopWordsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okUploadStopWordsButtonActionPerformed
        uploadStopWordsMessage.dispose();
    }//GEN-LAST:event_okUploadStopWordsButtonActionPerformed

    private void singleRegisterCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleRegisterCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_singleRegisterCBActionPerformed

    private void importStopWordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importStopWordsActionPerformed
        ru_stop_words = new ArrayList<>();
        eng_stop_words = new ArrayList<>();
        textWorker.importStopWords(ru_stop_words, eng_stop_words, ruStopWordsList, engStopWordsList, uploadStopWordsMessage, stopwordsMessageLabel);
    }//GEN-LAST:event_importStopWordsActionPerformed

    private void allCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allCBActionPerformed

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    Timer timer = new Timer(5000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            loadingFrame.dispose();
        }
    });

    public void loadingProcess() {
        loadingFrame.setVisible(true);
        // Устанавливаем путь к файлу гифки
        String gifPath = System.getProperty("user.dir") + "/resources/Loading.gif";
        File gifFile = new File(gifPath);

        if (gifFile.exists() && !gifFile.isDirectory()) {
            ImageIcon gif = new ImageIcon(gifPath);
            gifLabel.setIcon(gif);
        } else {
            System.out.println("Файл не найден: " + gifPath);
        }

        // Устанавливаем размер окна в соответствии с содержимым
        loadingFrame.pack();
        loadingFrame.setLocationRelativeTo(null); // Центрируем окно на экране
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FreqTable;
    private javax.swing.JFrame MainJFrame;
    private javax.swing.JCheckBox allCB;
    private javax.swing.JMenuItem analyzeButton;
    private javax.swing.JMenuItem deleteSelectionsButton;
    private javax.swing.JMenuItem editEngStopWordsButton;
    private javax.swing.JMenuItem editRuStopWordsButton;
    private javax.swing.JFrame engStopWordsFrame;
    private javax.swing.JList<String> engStopWordsList;
    private javax.swing.JScrollPane engStopWordsScrollPanel;
    private javax.swing.JMenuItem exitButton;
    private javax.swing.JButton exitFromGuideButton;
    private javax.swing.JMenuItem exportButton;
    private javax.swing.JLabel gifLabel;
    private javax.swing.ButtonGroup group;
    private javax.swing.JDialog guide;
    private javax.swing.JButton guideButton;
    private javax.swing.JLabel guideLabel1;
    private javax.swing.JLabel guideLabel10;
    private javax.swing.JLabel guideLabel11;
    private javax.swing.JLabel guideLabel2;
    private javax.swing.JLabel guideLabel3;
    private javax.swing.JLabel guideLabel4;
    private javax.swing.JLabel guideLabel5;
    private javax.swing.JLabel guideLabel6;
    private javax.swing.JLabel guideLabel7;
    private javax.swing.JLabel guideLabel8;
    private javax.swing.JLabel guideLabel9;
    private javax.swing.JPanel guidePanel;
    private javax.swing.JMenuItem importButton;
    private javax.swing.JMenuItem importStopWords;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu loadStopWord;
    private javax.swing.JFrame loadingFrame;
    private javax.swing.JLabel loadingLabel1;
    private javax.swing.JLabel loadingLabel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu moreSettingsMenu;
    private javax.swing.JLabel numberDelWordsField;
    private javax.swing.JLabel numberWordsField;
    private javax.swing.JButton okSaveReportButton;
    private javax.swing.JButton okUploadFileButton;
    private javax.swing.JButton okUploadStopWordsButton;
    private javax.swing.JLabel popularWordField;
    private javax.swing.JCheckBox removeNumbersCB;
    private javax.swing.JFrame ruStopWordsFrame;
    private javax.swing.JList<String> ruStopWordsList;
    private javax.swing.JScrollPane ruStopWordsScrollPanel;
    private javax.swing.JLabel saveMessageLabel;
    private javax.swing.JPanel savePanel;
    private javax.swing.JDialog saveReportMessage;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JMenu settingsMenu;
    private javax.swing.JCheckBox singleRegisterCB;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel startFrame;
    private javax.swing.JLabel stopwordsMessageLabel;
    private javax.swing.JLabel unpopularWordField;
    private javax.swing.JDialog uploadFileMessage;
    private javax.swing.JPanel uploadFilePanel;
    private javax.swing.JLabel uploadMessageLabel;
    private javax.swing.JDialog uploadStopWordsMessage;
    private javax.swing.JPanel uploadWordsPanel;
    private javax.swing.JRadioButtonMenuItem useEngButton;
    private javax.swing.JCheckBoxMenuItem useEngStopWordsButton;
    private javax.swing.JCheckBoxMenuItem useRuStopWordsButton;
    private javax.swing.JRadioButtonMenuItem useRusButton;
    private javax.swing.JMenu useStopWords;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel welcomeLabel1;
    private javax.swing.JLabel welcomeLabel2;
    private javax.swing.JLabel welcomeLabel3;
    // End of variables declaration//GEN-END:variables
}
