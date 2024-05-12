package barqrcode;

import com.barcodelib.barcode.Linear;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Frame extends javax.swing.JFrame {
    public Frame() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageLabel = new javax.swing.JLabel();
        TextField = new javax.swing.JTextField();
        Barcode = new javax.swing.JButton();
        QRcode = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(435, 235));
        setPreferredSize(new java.awt.Dimension(435, 375));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 370, 130));

        TextField.setBorder(null);
        getContentPane().add(TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 370, 20));

        Barcode.setBorder(null);
        Barcode.setContentAreaFilled(false);
        Barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarcodeActionPerformed(evt);
            }
        });
        getContentPane().add(Barcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 180, 30));

        QRcode.setBorder(null);
        QRcode.setContentAreaFilled(false);
        QRcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QRcodeActionPerformed(evt);
            }
        });
        getContentPane().add(QRcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 190, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barqrcode/bg.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 435, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QRcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QRcodeActionPerformed
    try {
        ByteArrayOutputStream out = QRCode.from(TextField.getText()).to(ImageType.PNG).stream();
        String fileName = TextField.getText();

        String pathName = "C:\\Users\\FARHAN\\Documents\\GitHub\\BarQrCode\\src\\hasilprint";
        FileOutputStream fount = new FileOutputStream(new File(pathName + File.separator + fileName + ".png"));
        fount.write(out.toByteArray());
        fount.flush();
        fount.close(); // Close the FileOutputStream

        // Load the image and set it to imageLabel
        ImageIcon icon = new ImageIcon(pathName + File.separator + fileName + ".png");
        imageLabel.setIcon(icon);

        // Center the image within the JLabel
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);


        // Menampilkan notifikasi
        JOptionPane.showMessageDialog(this, "QR Code berhasil dibuat", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
    }//GEN-LAST:event_QRcodeActionPerformed
    private void BarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarcodeActionPerformed
    try {
        Linear barcod = new Linear();
        barcod.setType(Linear.CODE128);
        barcod.setData(TextField.getText());
        barcod.setI(11.0f);
        String fileName = TextField.getText();

        // Path untuk menyimpan barcode
        String pathName = "C:\\Users\\FARHAN\\Documents\\GitHub\\BarQrCode\\src\\hasilprint";
        // File yang akan disimpan
        File file = new File(pathName + File.separator + fileName + ".png");
        // Render barcode pada file
        barcod.renderBarcode(file.getAbsolutePath());

        // Load the image and set it to imageLabel
        ImageIcon icon = new ImageIcon(file.getAbsolutePath());
        imageLabel.setIcon(icon);

        // Center the image within the JLabel
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        // Menampilkan notifikasi
        JOptionPane.showMessageDialog(this, "Barcode berhasil dibuat", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
    }//GEN-LAST:event_BarcodeActionPerformed
    public static void main(String args[]) {    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Barcode;
    private javax.swing.JButton QRcode;
    private javax.swing.JTextField TextField;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel imageLabel;
    // End of variables declaration//GEN-END:variables
}