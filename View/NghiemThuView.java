package View;
import Model.CanBo;
import Model.NghiemThu;
import Model.DangKyBienSoanGiaoTrinh;
import Model.TacGia;
import Model.FileController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class NghiemThuView extends javax.swing.JFrame {

    /**
     * Creates new form NghiemThu
     */
    
    List<DangKyBienSoanGiaoTrinh> dsnt = ReadtoFile("TienDo.DAT");
    DefaultTableModel model;
    public NghiemThuView() {
        initComponents();
        model = (DefaultTableModel) DSNT.getModel();
        showresult();
    }
    
    public void showresult() {
        for (DangKyBienSoanGiaoTrinh s : dsnt) {

            model.addRow(new Object[]{
                s.getMaGT(), s.getTenGT(),s.getThoiGianHT(),s.getThoiGianDK()
            });
        }
    }
    
    
    private List<DangKyBienSoanGiaoTrinh> ReadtoFile(String fileName){
        FileController fileController = new FileController();
        fileController.OpenFileToRead(fileName);
        List<DangKyBienSoanGiaoTrinh> dsnt = new ArrayList<>();
        while (fileController.getScanner().hasNext()) {
            String infor = fileController.getScanner().nextLine();
            String[] data = infor.split("\\|");
            String[] data2 = data[data.length - 2].split("\\*");
            List<TacGia> tgs = new ArrayList<>();
            for (int i = 0; i <= data2.length / 2; i += 2) {
                String ten = data2[i + 1];
                String vaiTro = data2[i + 2];
                tgs.add(new TacGia(ten, vaiTro));
            }
            DangKyBienSoanGiaoTrinh a = new DangKyBienSoanGiaoTrinh(data[1], tgs, data[2], data[3]);
            a.setMaGT(data[0]);
            dsnt.add(a);
        }
        fileController.CloseFileAfterRead();
        return dsnt;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DSNT = new javax.swing.JTable();
        NghiemThu = new javax.swing.JButton();
        nut_quaylai = new javax.swing.JButton();
        txtSoCB = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel2.setText("Danh sách nghiệm thu");

        DSNT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        DSNT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giáo trình", "Ten giáo trình", "Ngày đăng ký", "Ngày hoàn thành", "Nghiệm thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(DSNT);

        NghiemThu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        NghiemThu.setText("Nghiệm thu");
        NghiemThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NghiemThuActionPerformed(evt);
            }
        });

        nut_quaylai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        nut_quaylai.setText("Quay lại");
        nut_quaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nut_quaylaiActionPerformed(evt);
            }
        });

        txtSoCB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSoCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoCBActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Số cán bộ :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(txtSoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 180, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(NghiemThu)
                .addGap(114, 114, 114)
                .addComponent(nut_quaylai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NghiemThu)
                    .addComponent(nut_quaylai))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NghiemThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NghiemThuActionPerformed
        
        int index = 0;
        try {
            index = DSNT.getSelectedRow();
            if (index == -1) {
                throw new IOException("Bạn chưa chọn giáo trình muốn nghiệm thu!");
            }else {
                model.setValueAt("Đã nghiệm thu", index, 4);
                JOptionPane.showMessageDialog(this, "Bạn đã nghiệm thu thành công", "Thao tác thành công!", JOptionPane.INFORMATION_MESSAGE);
            }
            String t = (String) model.getValueAt(index, 0);
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Thao tác thất bại!", JOptionPane.ERROR_MESSAGE);
        }
        
        NghiemThu a = new NghiemThu();
        int n = Integer.parseInt(txtSoCB.getText());
        DangKyBienSoanGiaoTrinh gt = dsnt.get(index);
        a.Nhap(n);
        WriteFileBegin(gt, a.getDscb());
    }//GEN-LAST:event_NghiemThuActionPerformed

    
    
    private List<DangKyBienSoanGiaoTrinh> ReadtoFileNT(String fileName){
        FileController fileController = new FileController();
        fileController.OpenFileToRead(fileName);
        List<DangKyBienSoanGiaoTrinh> dsnt = new ArrayList<>();
        while (fileController.getScanner().hasNext()) {
            String infor = fileController.getScanner().nextLine();
            String[] data = infor.split("\\|");
            String[] data2 = data[data.length - 1].split("\\*");
            List<TacGia> tgs = new ArrayList<>();
            for (int i = 0; i <= data2.length / 2; i += 2) {
                String ten = data2[i + 1];
                String vaiTro = data2[i + 2];
                tgs.add(new TacGia(ten, vaiTro));
            }
            DangKyBienSoanGiaoTrinh a = new DangKyBienSoanGiaoTrinh(data[1], tgs, data[2], data[3]);
            a.setMaGT(data[0]);
            dsnt.add(a);
        }
        fileController.CloseFileAfterRead();
        return dsnt;
    }
    
    
    public void WriteFileBegin(DangKyBienSoanGiaoTrinh dkb,List<CanBo> dscb) {
        FileController fileController = new FileController();
        fileController.OpenFileToWrite("NghiemThu.DAT",true);
                String str = "";
                str += dkb.getMaGT() + "|" + dkb.getTenGT() + "|" + dkb.getNoiDung() + "|" + dkb.getThoiGianHT() + "|" + dkb.getThoiGianDK() + "|";
                for (TacGia tacGia : dkb.getTacGias()) {
                    String tmp = "*" + tacGia.getTenTacGia() + "*" + tacGia.getVaiTro();
                    str += tmp; 
                }              
                for (CanBo canBo : dscb) {
                    String tmp = "+" + canBo.getTenCB()+ "+" + canBo.getVaiTro();
                    str += tmp;
                }
                  fileController.getPrintWriter().println(str);
        fileController.CloseFileAfterWrite();
    }
    
    
    private void nut_quaylaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nut_quaylaiActionPerformed
        // TODO add your handling code here:
        menuChinh f = new menuChinh();
        f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_nut_quaylaiActionPerformed

    private void txtSoCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoCBActionPerformed

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
            java.util.logging.Logger.getLogger(NghiemThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NghiemThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NghiemThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NghiemThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NghiemThuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DSNT;
    private javax.swing.JButton NghiemThu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nut_quaylai;
    private javax.swing.JTextField txtSoCB;
    // End of variables declaration//GEN-END:variables

   
}
