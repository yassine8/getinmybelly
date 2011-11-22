package GUI;

import Jama.Matrix;
import Transforms.*;
import Signals.Reader;
import java.awt.Container;
import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author Tom Pepels - 25-9-2011
 */
public class ECGFrame extends javax.swing.JFrame {

    private String selectedFile;
    private double[] samples;
    private double[] transformed;
    private String yAxis;
    private String signalName;
    private boolean graph1Drawn = false;
    private boolean graph2Drawn = false;

    /** Creates new form ECGFrame */
    public ECGFrame() {
        initComponents();

        drawButton.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        transformButtonGroup = new javax.swing.ButtonGroup();
        graphOperationGroup = new javax.swing.ButtonGroup();
        graphSelectionGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        signalNamesList = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        drawButton = new javax.swing.JButton();
        fileTextField = new javax.swing.JTextField();
        sigCountText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        clear2Button = new javax.swing.JButton();
        clear1Button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        graphPanel2 = new GUI.GraphPanel();
        graphPanel1 = new GUI.GraphPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        haarRadioButton = new javax.swing.JRadioButton();
        d4RadioButton = new javax.swing.JRadioButton();
        fourierRadioButton = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        medianFilterButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        filterTxt = new javax.swing.JTextField();
        meanFilterButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        addToRadio = new javax.swing.JRadioButton();
        replaceRadio = new javax.swing.JRadioButton();
        graph1Radio = new javax.swing.JRadioButton();
        graph2Radio = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        fastICAButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        signalList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        componentsTxt = new javax.swing.JTextField();
        FourierDomain = new javax.swing.JCheckBox();
        dwtPreFilter = new javax.swing.JCheckBox();
        dwtPostFilter = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuration"));

        jButton1.setText("Select File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Signal:");

        drawButton.setText("Draw graph");
        drawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawButtonActionPerformed(evt);
            }
        });

        sigCountText.setText("4096");

        jLabel2.setText("Signal count:");

        resetButton.setText("Reset samples");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        clear2Button.setText("Clear graph 2");
        clear2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear2ButtonActionPerformed(evt);
            }
        });

        clear1Button.setText("Clear Graph 1");
        clear1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signalNamesList, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sigCountText, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drawButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clear2Button)
                    .addComponent(clear1Button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(clear1Button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(signalNamesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(sigCountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(drawButton)
                    .addComponent(resetButton)
                    .addComponent(clear2Button))
                .addContainerGap())
        );

        jPanel2.setLayout(new java.awt.BorderLayout());

        graphPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Graph 2"));
        graphPanel2.setPreferredSize(new java.awt.Dimension(412, 270));
        jPanel2.add(graphPanel2, java.awt.BorderLayout.SOUTH);

        graphPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Graph 1"));
        graphPanel1.setPreferredSize(new java.awt.Dimension(412, 270));
        jPanel2.add(graphPanel1, java.awt.BorderLayout.NORTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Operations"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Transforms"));

        transformButtonGroup.add(haarRadioButton);
        haarRadioButton.setSelected(true);
        haarRadioButton.setText("Haar");

        transformButtonGroup.add(d4RadioButton);
        d4RadioButton.setText("Daubechies D4");

        transformButtonGroup.add(fourierRadioButton);
        fourierRadioButton.setText("Fourier");
        fourierRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourierRadioButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Transform");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Filter");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(haarRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fourierRadioButton))
                    .addComponent(d4RadioButton)
                    .addComponent(jButton3))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(haarRadioButton)
                    .addComponent(fourierRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(d4RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Filters"));

        medianFilterButton.setText("Median Filter");
        medianFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medianFilterButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Filter neighbours:");

        filterTxt.setText("3");

        meanFilterButton.setText("Mean Filter");
        meanFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meanFilterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(meanFilterButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(medianFilterButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(filterTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(medianFilterButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(meanFilterButton)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Graphs"));

        graphOperationGroup.add(addToRadio);
        addToRadio.setText("Add to");

        graphOperationGroup.add(replaceRadio);
        replaceRadio.setSelected(true);
        replaceRadio.setText("Replace");

        graphSelectionGroup.add(graph1Radio);
        graph1Radio.setText("Graph 1");

        graphSelectionGroup.add(graph2Radio);
        graph2Radio.setSelected(true);
        graph2Radio.setText("Graph2");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(replaceRadio)
                    .addComponent(addToRadio)
                    .addComponent(graph2Radio)
                    .addComponent(graph1Radio))
                .addContainerGap(6, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(addToRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(replaceRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(graph1Radio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(graph2Radio)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Blind source separation"));

        fastICAButton.setText("FastICA");
        fastICAButton.setEnabled(false);
        fastICAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fastICAButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(signalList);

        jLabel3.setText("Components:");

        componentsTxt.setText("2");

        FourierDomain.setText("Fourier Domain");

        dwtPreFilter.setText("DWT pre-filter");

        dwtPostFilter.setText("DWT post-filter");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(componentsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FourierDomain)
                    .addComponent(dwtPreFilter)
                    .addComponent(dwtPostFilter)
                    .addComponent(fastICAButton, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(FourierDomain)
                        .addGap(3, 3, 3)
                        .addComponent(dwtPreFilter)
                        .addGap(4, 4, 4)
                        .addComponent(dwtPostFilter))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(componentsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fastICAButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            fileTextField.setText(file.getName());
            this.selectedFile = file.getPath();
            Reader.closeEDFFile();
            Reader.openEDFFile(selectedFile);
            fillComboBox();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void drawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawButtonActionPerformed
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        readSamples();
        drawGraph(signalName, false);
    }//GEN-LAST:event_drawButtonActionPerformed

    private void readSamples() {
        Reader.openEDFFile(selectedFile);
        int signal = ((ComboItem) signalNamesList.getSelectedItem()).getId();
        int sigCount = Integer.parseInt(sigCountText.getText());
        samples = Reader.readSamples(signal, sigCount);
        yAxis = Reader.physicalDimension(signal);
        signalName = Reader.signalName(signal);
        Reader.closeEDFFile();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (fourierRadioButton.isSelected()) {
            drawGraph("Fourier Transform", true);
        } else {
            drawGraph("Wavelet Transform", true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        double[] trans = doTransform();
        double[] newSigD = NoiseReduction.reduceNoiseDynamicT(trans);
        samples = Arrays.copyOf(doInvTransform(newSigD), newSigD.length);

        drawGraph("Dynamic Threshold", false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void medianFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medianFilterButtonActionPerformed
        int n = Integer.parseInt(filterTxt.getText());
        samples = NoiseReduction.medianFilter(samples, n);
        drawGraph("Median filtered, " + n, false);
    }//GEN-LAST:event_medianFilterButtonActionPerformed

    private void meanFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meanFilterButtonActionPerformed
        int n = Integer.parseInt(filterTxt.getText());
        samples = NoiseReduction.meanFilter(samples, n);
        drawGraph("Mean filtered, " + n, false);
    }//GEN-LAST:event_meanFilterButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        readSamples();
        //drawGraph(signalName, false);
    }//GEN-LAST:event_resetButtonActionPerformed

    private void clear1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ButtonActionPerformed
        graphPanel1.removeAll();
        graph1Drawn = false;
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_clear1ButtonActionPerformed

    private void clear2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2ButtonActionPerformed
        graphPanel2.removeAll();
        graph2Drawn = false;
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_clear2ButtonActionPerformed

    private void fastICAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastICAButtonActionPerformed
        int sigCount = Integer.parseInt(sigCountText.getText());

        Reader.openEDFFile(selectedFile);

        Object[] selItems = signalList.getSelectedValues();
        int sigs = selItems.length;
        int components = Integer.parseInt(componentsTxt.getText());

        int runs = 1;
        if (sigs < components) {
            runs = components / sigs;
        }
        // Build a matrix containing all the signals in the file.
        double[][] signals = new double[sigs * runs][sigCount];

        for (int k = 0; k < runs; k++) {
            for (int i = (k * sigs); i < (sigs + (k * sigs)); i++) {
                int signalId = ((ComboItem) selItems[i - (k * sigs)]).getId();
                signals[i] = Reader.readSamples(signalId, sigCount);

                if (FourierDomain.isSelected()) {
                    signals[i] = DFT.forward(signals[i]);
                }

                if (dwtPreFilter.isSelected()) {
                    // Do some noise-reduction
                    DWT.d4CompleteTransform(signals[i]);
                    signals[i] = NoiseReduction.reduceNoiseDynamicT(signals[i]);
                    DWT.d4CompleteInvTransform(signals[i]);
                }
            }
        }
        Reader.closeEDFFile();

        signals = FastICA.fastICA(signals, 50, 0.001, components);


        for (int i = 0; i < signals.length; i++) {
            if (FourierDomain.isSelected()) {
                signals[i] = DFT.reverse(signals[i]);
            }
            if (dwtPostFilter.isSelected()) {
                DWT.d4CompleteTransform(signals[i]);
                signals[i] = NoiseReduction.reduceNoiseDynamicT(signals[i]);
                DWT.d4CompleteInvTransform(signals[i]);
            }
        }
        drawComponents("ICA extracted signal", signals);
    }//GEN-LAST:event_fastICAButtonActionPerformed

    private void fourierRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourierRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fourierRadioButtonActionPerformed

    private void drawComponents(String name, double[][] components) {

        for (int i = 0; i < components.length; i++) {
            JFrame graphForm = new JFrame();
            graphForm.setSize(500, 300);
            graphForm.setLocation(100, i * 100);
            Container cPane = graphForm.getContentPane();
            GraphPanel gPanel = new GraphPanel();
            gPanel.setSize(500, 300);
            cPane.add(gPanel);
            gPanel.drawGraph(components[i], yAxis, name);
            graphForm.setVisible(true);
            graphForm.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        }
    }

    private void drawGraph(String name, boolean transform) {
        double[] signal;
        if (transform) {
            doTransform();
            signal = transformed;
        } else {
            signal = samples;
        }

        if (graph1Radio.isSelected()) {
            if (addToRadio.isSelected() && graph1Drawn) {
                graphPanel1.addGraph(signal, name);
            } else {
                graphPanel1.drawGraph(signal, yAxis, name);
                graph1Drawn = true;
            }
        } else {
            if (addToRadio.isSelected() && graph2Drawn) {
                graphPanel2.addGraph(signal, name);
            } else {
                graphPanel2.drawGraph(signal, yAxis, name);
                graph2Drawn = true;
            }
        }
    }

    private double[] doTransform() {
        if (haarRadioButton.isSelected()) {
            double weight = Math.sqrt(2);
            Matrix result = DWT.waveletTransform(weight, samples);
            transformed = result.transpose().getArray()[0];
            return transformed;

        } else if (d4RadioButton.isSelected()) {

            transformed = Arrays.copyOf(samples, samples.length);
            DWT.d4CompleteTransform(transformed);
            return transformed;

        } else { //Fourier here!
            double[] newSig = Arrays.copyOf(samples, samples.length);
            transformed = DFT.DiscreteFourier(newSig);
            return transformed;
//            Complex[] cSig = new Complex[samples.length];
//            for (int i = 0; i < samples.length; i++) {
//                cSig[i] = new Complex(samples[i],0);
//            }
//            DFT.DiscreteFourier(cSig);
//            transformed = new double[samples.length];
//            for (int i = 0; i < samples.length; i++) {
//                transformed[i] = cSig[i].mod();
//            }
//            return transformed; 
        }
    }

    private double[] doInvTransform(double[] signal) {
        if (haarRadioButton.isSelected()) {

            double weight = Math.sqrt(2);
            return DWT.inverseHaarWaveletTransform(signal, weight);

        } else if (d4RadioButton.isSelected()) {

            double[] newSig = Arrays.copyOf(signal, signal.length);
            DWT.d4CompleteInvTransform(newSig);
            return newSig;

        } else { //Fourier here!
            return new double[0];
        }
    }

    private void fillComboBox() {
        int signals = Reader.noOfSignals();
        ComboItem items[] = new ComboItem[signals];
        signalNamesList.removeAllItems();
        if (signals > 0) {

            for (int i = 0; i < signals; i++) {
                this.signalNamesList.addItem(new ComboItem(Reader.signalName(i), i));
                items[i] = new ComboItem(Reader.signalName(i), i);
            }
            signalList.setListData(items);
            signalList.setSelectionInterval(0, signals - 1);
            drawButton.setEnabled(true);
            fastICAButton.setEnabled(true);
        } else {
            drawButton.setEnabled(false);
            fastICAButton.setEnabled(false);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ECGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ECGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ECGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ECGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                        try {
                            UIManager.setLookAndFeel(info.getClassName());
                        } catch (Exception ex) {
                        }
                        break;
                    }
                }
                new ECGFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox FourierDomain;
    private javax.swing.JRadioButton addToRadio;
    private javax.swing.JButton clear1Button;
    private javax.swing.JButton clear2Button;
    private javax.swing.JTextField componentsTxt;
    private javax.swing.JRadioButton d4RadioButton;
    private javax.swing.JButton drawButton;
    private javax.swing.JCheckBox dwtPostFilter;
    private javax.swing.JCheckBox dwtPreFilter;
    private javax.swing.JButton fastICAButton;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JTextField filterTxt;
    private javax.swing.JRadioButton fourierRadioButton;
    private javax.swing.JRadioButton graph1Radio;
    private javax.swing.JRadioButton graph2Radio;
    private javax.swing.ButtonGroup graphOperationGroup;
    private GUI.GraphPanel graphPanel1;
    private GUI.GraphPanel graphPanel2;
    private javax.swing.ButtonGroup graphSelectionGroup;
    private javax.swing.JRadioButton haarRadioButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton meanFilterButton;
    private javax.swing.JButton medianFilterButton;
    private javax.swing.JRadioButton replaceRadio;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextField sigCountText;
    private javax.swing.JList signalList;
    private javax.swing.JComboBox signalNamesList;
    private javax.swing.ButtonGroup transformButtonGroup;
    // End of variables declaration//GEN-END:variables
}