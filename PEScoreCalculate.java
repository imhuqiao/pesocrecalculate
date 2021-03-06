/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pescorecalculate;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * @author HQ-Alien
 */
public class PEScoreCalculate extends JFrame {

    /**
     * Creates new form PEScoreCalculate
     */
    public PEScoreCalculate() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCreateStyle = new javax.swing.ButtonGroup();
        buttonGroupBySchool = new javax.swing.ButtonGroup();
        buttonGroupByCollege = new javax.swing.ButtonGroup();
        buttonGroupByMajorAndClass = new javax.swing.ButtonGroup();
        jLableTitle = new javax.swing.JLabel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelCreatExcel = new javax.swing.JPanel();
        jLabelIn = new javax.swing.JLabel();
        jLabelOut = new javax.swing.JLabel();
        jTextFieldOut = new javax.swing.JTextField();
        jTextFieldIn = new javax.swing.JTextField();
        jButtonIn = new javax.swing.JButton();
        jButtonOut = new javax.swing.JButton();
        jButtonCalculate = new javax.swing.JButton();
        jLabelBanquan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("国家大学生体能测试成绩统计");
        setBounds(new java.awt.Rectangle(150, 150, 0, 0));

        jLableTitle.setFont(new java.awt.Font("华文楷体", 0, 24)); // NOI18N
        jLableTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLableTitle.setText("国家大学生体能测试合计——财大简版");

        jTabbedPane.setToolTipText("");
        jTabbedPane.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jTabbedPane.setName(""); // NOI18N

        jLabelIn.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabelIn.setText("输出文件");

        jLabelOut.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabelOut.setText("源文件");

        jTextFieldOut.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N

        jTextFieldIn.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N

        jButtonIn.setText("选择");
        jButtonIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInActionPerformed(evt);
            }
        });

        jButtonOut.setText("浏览");
        jButtonOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutActionPerformed(evt);
            }
        });

        jButtonCalculate.setFont(new java.awt.Font("华文新魏", 0, 26)); // NOI18N
        jButtonCalculate.setText("开始计算");
        jButtonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCreatExcelLayout = new javax.swing.GroupLayout(jPanelCreatExcel);
        jPanelCreatExcel.setLayout(jPanelCreatExcelLayout);
        jPanelCreatExcelLayout.setHorizontalGroup(
            jPanelCreatExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreatExcelLayout.createSequentialGroup()
                .addGroup(jPanelCreatExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCreatExcelLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jButtonCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCreatExcelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelCreatExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIn)
                            .addComponent(jLabelOut, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCreatExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIn, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldOut, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCreatExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonOut)
                            .addComponent(jButtonIn))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCreatExcelLayout.setVerticalGroup(
            jPanelCreatExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreatExcelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelCreatExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCreatExcelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButtonOut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCreatExcelLayout.createSequentialGroup()
                        .addGroup(jPanelCreatExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelOut, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldIn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonIn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanelCreatExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelIn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldOut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(jButtonCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("生成成绩", jPanelCreatExcel);

        jLabelBanquan.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabelBanquan.setText("By HQ_Alien 萧易-桥 ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLableTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelBanquan)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLableTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelBanquan)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInActionPerformed
        // TODO add your handling code here:
        /**
         * 新建文件过滤器
         */
        FileFilter ffilter = new FileFilter(){

            @Override
            public boolean accept(File f) {
                if(f.toString().endsWith("xls")){
                 return true;
                }
                if(f.isDirectory()){
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription() {
                return ".xls (03版Excel表格)";
            }
        };
        
        JFileChooser jfc = new JFileChooser();//新建打开窗口
        //jfc.setFileSelectionMode(FILES_AND_DIRECTORIES);
        jfc.setFileFilter(ffilter);
        jfc.showOpenDialog(jfc);
        if(jfc.getSelectedFile() != null){
            String strFile=jfc.getSelectedFile().toString();
            jTextFieldIn.setText(strFile);
            strFile = strFile.replace(".xls", "_含成绩.xls");
            jTextFieldOut.setText(strFile);
        }
    }//GEN-LAST:event_jButtonInActionPerformed

    private void jButtonOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutActionPerformed
        // TODO add your handling code here:
        /**
         * 新建文件过滤器
         */
        FileFilter ffilter = new FileFilter(){

            @Override
            public boolean accept(File f) {
                if(f.toString().endsWith("xls")){
                 return true;
                }
                return f.isDirectory();
            }

            @Override
            public String getDescription() {
                return ".xls (03版Excel表格)";
            }
        };
        
        JFileChooser jfc = new JFileChooser();//新建打开窗口
        //jfc.setFileSelectionMode(FILES_AND_DIRECTORIES);
        jfc.setFileFilter(ffilter);
        jfc.showSaveDialog(jfc);
        if(jfc.getSelectedFile() != null){
            String strFile=jfc.getSelectedFile().toString();
            String strDes = "";
            if(jfc.getFileFilter() != null){
                strDes = jfc.getFileFilter().getDescription();
                if(strDes != null)
                    if(!strDes.contains(" ")){
                        strDes = "";
                    }else{
                        strDes = strDes.substring(0, strDes.indexOf(" "));
                    }
            }
            if(!strFile.endsWith(".xls"))
                strFile += strDes;
            jTextFieldOut.setText(strFile);
        }
    }//GEN-LAST:event_jButtonOutActionPerformed

    SportItem item[] = new SportItem[9];
    University university ;
    
    private void jButtonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculateActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < 9; i++) {
            item[i] = new SportItem();
        }
        university = new University(0,"山西财经大学");
        Start start = new Start();
        try {
            start.start(item,university,jTextFieldIn.getText(), jTextFieldOut.getText());
        } catch (BiffException | IOException | WriteException ex) {
            Logger.getLogger(PEScoreCalculate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCalculateActionPerformed

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
            java.util.logging.Logger.getLogger(PEScoreCalculate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PEScoreCalculate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PEScoreCalculate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PEScoreCalculate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//设置为windows感官效果
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PEScoreCalculate.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(PEScoreCalculate.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(PEScoreCalculate.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(PEScoreCalculate.class.getName()).log(Level.SEVERE, null, ex);
                }
                PEScoreCalculate frame = new PEScoreCalculate();
		frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupByCollege;
    private javax.swing.ButtonGroup buttonGroupByMajorAndClass;
    private javax.swing.ButtonGroup buttonGroupBySchool;
    private javax.swing.ButtonGroup buttonGroupCreateStyle;
    private javax.swing.JButton jButtonCalculate;
    private javax.swing.JButton jButtonIn;
    private javax.swing.JButton jButtonOut;
    private javax.swing.JLabel jLabelBanquan;
    private javax.swing.JLabel jLabelIn;
    private javax.swing.JLabel jLabelOut;
    private javax.swing.JLabel jLableTitle;
    private javax.swing.JPanel jPanelCreatExcel;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTextFieldIn;
    private javax.swing.JTextField jTextFieldOut;
    // End of variables declaration//GEN-END:variables
}
