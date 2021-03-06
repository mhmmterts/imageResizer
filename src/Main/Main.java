package Main;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    private String pathName = null;
    private int width = 0;
    private int height = 0;
    private String outputPathName = null;
    private String fileLocation = null;

    public Main() {
        initComponents();
        centerFrame();
        setIcon();
    }

    private void centerFrame() {
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
        setLocationRelativeTo(null);
    }

    private void setIcon() {
        Image image = new ImageIcon(this.getClass().getResource("/Images/github-peteruithoven-resizer-icon.png")).getImage();
        this.setIconImage(image);
    }

    private boolean controlInput() {
        if (widthComboBox.getSelectedItem() == null || widthComboBox.getSelectedItem() == "" || heightComboBox.getSelectedItem() == null || heightComboBox.getSelectedItem() == "") {
            JOptionPane.showMessageDialog(this, "Width or height not set!");
            return false;
        }
        String width1 = (String) widthComboBox.getSelectedItem();
        String height1 = (String) heightComboBox.getSelectedItem();
        if (width1.matches(".*[a-zA-Z]+.*") || height1.matches(".*[a-zA-Z]+.*")) {
            JOptionPane.showMessageDialog(this, "Invalid input for width or height!");
            return false;
        }
        if (outputPathName == null) {
            JOptionPane.showMessageDialog(this, "Output file destination not selected!");
            return false;
        }
        return true;
    }

    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight, String type) throws IOException {
        BufferedImage resizedImage = null;
        if (type.equals("jpg")) {
            resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        } else {
            resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        }
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    private void setCombobox() {
        int count1 = widthComboBox.getItemCount();
        boolean control1 = true;
        boolean control2 = true;
        int count2 = heightComboBox.getItemCount();
        String localWidth = (String) widthComboBox.getSelectedItem();
        String localHeight = (String) heightComboBox.getSelectedItem();
        widthComboBox.setSelectedItem(null);
        heightComboBox.setSelectedItem(null);
        for (int i = 0; i < count1; i++) {
            if (widthComboBox.getItemAt(i).equals(localWidth)) {
                control1 = false;
                break;
            }
        }
        for (int i = 0; i < count2; i++) {
            if (heightComboBox.getItemAt(i).equals(localHeight)) {
                control2 = false;
                break;
            }
        }
        if (control1) {
            widthComboBox.addItem(localWidth);
        }
        if (control2) {
            heightComboBox.addItem(localHeight);
        }
    }

    private void ImageWriting(BufferedImage img) {
        String fileName = outputPathName + "/" + pathName + "_" + width + "x" + height;
        fileName = fileName.replace("/", File.separator);
        try {
            System.out.println(filePathTextField.getText());
            if (filePathTextField.getText().endsWith("png")) {
                ImageIO.write(img, "png", new File(fileName + ".png"));
                fileLocation = fileName + ".png";
            } else if (filePathTextField.getText().endsWith("jpg")) {
                ImageIO.write(img, "jpg", new File(fileName + ".jpg"));
                fileLocation = fileName + ".jpg";
            } else {
                ImageIO.write(img, "gif", new File(fileName + ".gif"));
                fileLocation = fileName + ".gif";
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        selectImage = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        filePathTextField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        widthComboBox = new javax.swing.JComboBox<>();
        heightComboBox = new javax.swing.JComboBox<>();
        selectFileDestination = new javax.swing.JButton();
        resizeImage = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Resizer 1.1.0");
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(731, 486));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(121, 164, 140));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Image Resizer");

        selectImage.setBackground(new java.awt.Color(68, 56, 255));
        selectImage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        selectImage.setForeground(new java.awt.Color(255, 255, 255));
        selectImage.setText("Select Image");
        selectImage.setToolTipText("Select Image");
        selectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImageActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("X");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Dimensions:");

        filePathTextField.setEditable(false);

        clearButton.setBackground(new java.awt.Color(187, 218, 121));
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/supurge_36x36.png"))); // NOI18N
        clearButton.setToolTipText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        widthComboBox.setEditable(true);
        widthComboBox.setToolTipText("Width");

        heightComboBox.setEditable(true);
        heightComboBox.setToolTipText("Height");

        selectFileDestination.setBackground(new java.awt.Color(68, 56, 255));
        selectFileDestination.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        selectFileDestination.setForeground(new java.awt.Color(255, 255, 255));
        selectFileDestination.setText("<html>   &nbsp Select File <br>  Destination");
        selectFileDestination.setToolTipText("Not selected");
        selectFileDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileDestinationActionPerformed(evt);
            }
        });

        resizeImage.setBackground(new java.awt.Color(79, 208, 23));
        resizeImage.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        resizeImage.setForeground(new java.awt.Color(255, 255, 255));
        resizeImage.setText("Resize");
        resizeImage.setToolTipText("Resize Image");
        resizeImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resizeImageActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("With Image Resizer you can resize png, jpg and gif files.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(8, 8, 8)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(filePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(selectFileDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(widthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(heightComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(resizeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(274, 274, 274))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(widthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heightComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(selectFileDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resizeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImageActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select Image File");
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            filePathTextField.setText(f.getPath());
            pathName = f.getName().substring(0, f.getName().length() - 4);

        } else {
            // user changed their mind
        }
    }//GEN-LAST:event_selectImageActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        filePathTextField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void selectFileDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileDestinationActionPerformed
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.setDialogTitle("Select file destination");
        f.showSaveDialog(this);
        if (f.getSelectedFile() != null) {
            outputPathName = f.getSelectedFile().getAbsolutePath();
        }
        selectFileDestination.setToolTipText(outputPathName);
    }//GEN-LAST:event_selectFileDestinationActionPerformed

    private void resizeImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resizeImageActionPerformed
        if (!filePathTextField.getText().isEmpty()) {
            if (filePathTextField.getText().endsWith("png") || filePathTextField.getText().endsWith("jpg") || filePathTextField.getText().endsWith("gif")) {
                if (controlInput()) {
                    width = Integer.parseInt((String) widthComboBox.getSelectedItem());
                    height = Integer.parseInt((String) heightComboBox.getSelectedItem());
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new File(filePathTextField.getText()));
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        String type = filePathTextField.getText().substring(filePathTextField.getText().length() - 3, filePathTextField.getText().length());
                        img = resizeImage(img, width, height, type);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    setCombobox();
                    ImageWriting(img);
                    JOptionPane.showMessageDialog(this, "Image created.\nFile Location: " + fileLocation);
                }
            } else {
                JOptionPane.showMessageDialog(this, " File format not supported.\n Only png, jpg or gif files are supported.");
            }

        } else {
            JOptionPane.showMessageDialog(this, "No image selected!");
        }
    }//GEN-LAST:event_resizeImageActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField filePathTextField;
    private javax.swing.JComboBox<String> heightComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton resizeImage;
    private javax.swing.JButton selectFileDestination;
    private javax.swing.JButton selectImage;
    private javax.swing.JComboBox<String> widthComboBox;
    // End of variables declaration//GEN-END:variables
}
