/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.lang.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ruwan
 */
public class Stock extends javax.swing.JInternalFrame {

    /**
     * Creates new form Stock
     */
    
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String sqr;
    
    public Stock() {
        initComponents();
        conn=DBConnect.connect();
        tablelord();
        btndelete.setEnabled(false); 
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));        
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        txtitemname = new javax.swing.JTextField();
        btnfind = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblstock = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateex = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btndelete = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setMinimumSize(new java.awt.Dimension(880, 510));
        setPreferredSize(new java.awt.Dimension(880, 510));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(193, 222, 136));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Stocks");

        lblname.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        lblname.setForeground(new java.awt.Color(255, 255, 255));
        lblname.setText("ENTER NAME");

        txtitemname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtitemname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtitemnameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtitemname, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtitemname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(12, 12, 12))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(50, 30, 800, 50);

        btnfind.setBackground(new java.awt.Color(193, 222, 136));
        btnfind.setPreferredSize(new java.awt.Dimension(90, 40));
        btnfind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnfindMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search-12-24.png"))); // NOI18N
        jLabel8.setText("Find");

        javax.swing.GroupLayout btnfindLayout = new javax.swing.GroupLayout(btnfind);
        btnfind.setLayout(btnfindLayout);
        btnfindLayout.setHorizontalGroup(
            btnfindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(btnfindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnfindLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btnfindLayout.setVerticalGroup(
            btnfindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(btnfindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnfindLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(btnfind);
        btnfind.setBounds(260, 410, 90, 40);

        tblstock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblstock.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblstock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblstockMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblstock);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 100, 800, 250);

        jLabel6.setFont(new java.awt.Font("Sitka Text", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Expier Goods");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 380, 130, 20);

        jLabel7.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Date");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 410, 70, 21);

        dateex.setDateFormatString("yyyy-MM-dd");
        dateex.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                dateexComponentAdded(evt);
            }
        });
        dateex.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                dateexHierarchyChanged(evt);
            }
        });
        dateex.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dateexFocusGained(evt);
            }
        });
        dateex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateexMouseClicked(evt);
            }
        });
        dateex.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                dateexInputMethodTextChanged(evt);
            }
        });
        dateex.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateexPropertyChange(evt);
            }
        });
        dateex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dateexKeyTyped(evt);
            }
        });
        jPanel1.add(dateex);
        dateex.setBounds(140, 360, 210, 30);

        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 370, 320, 140);

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 90, 820, 270);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jButton4.setBackground(new java.awt.Color(193, 222, 136));
        jButton4.setPreferredSize(new java.awt.Dimension(90, 40));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rotate-24-24.png"))); // NOI18N
        jLabel2.setText("Reset");

        javax.swing.GroupLayout jButton4Layout = new javax.swing.GroupLayout(jButton4);
        jButton4.setLayout(jButton4Layout);
        jButton4Layout.setHorizontalGroup(
            jButton4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButton4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jButton4Layout.setVerticalGroup(
            jButton4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButton4Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(193, 222, 136));
        jButton1.setPreferredSize(new java.awt.Dimension(90, 40));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/printer-24.png"))); // NOI18N
        jLabel9.setText("Print");

        javax.swing.GroupLayout jButton1Layout = new javax.swing.GroupLayout(jButton1);
        jButton1.setLayout(jButton1Layout);
        jButton1Layout.setHorizontalGroup(
            jButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jButton1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jButton1Layout.setVerticalGroup(
            jButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jButton1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        btndelete.setBackground(new java.awt.Color(193, 222, 136));
        btndelete.setPreferredSize(new java.awt.Dimension(90, 40));
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete-24.png"))); // NOI18N
        jLabel1.setText("Delete");

        javax.swing.GroupLayout btndeleteLayout = new javax.swing.GroupLayout(btndelete);
        btndelete.setLayout(btndeleteLayout);
        btndeleteLayout.setHorizontalGroup(
            btndeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(btndeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btndeleteLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        btndeleteLayout.setVerticalGroup(
            btndeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(btndeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btndeleteLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(300, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(430, 400, 420, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void  taheader()
    {
        JTableHeader thead = tblstock.getTableHeader();
        thead.setForeground(Color.BLUE);    
        thead.setFont(new Font("Tahome", Font.BOLD, 14));       
        TableColumn col1=tblstock.getColumnModel().getColumn(0);
        col1.setPreferredWidth(95);
        TableColumn col2=tblstock.getColumnModel().getColumn(1);
        col2.setPreferredWidth(90);
        TableColumn col3=tblstock.getColumnModel().getColumn(2);
        col3.setPreferredWidth(85);
        TableColumn col4=tblstock.getColumnModel().getColumn(3);
        col4.setPreferredWidth(104);
        TableColumn col5=tblstock.getColumnModel().getColumn(4);
        col5.setPreferredWidth(90);
        TableColumn col6=tblstock.getColumnModel().getColumn(5);
        col6.setPreferredWidth(100);
        TableColumn col7=tblstock.getColumnModel().getColumn(6);
        col7.setPreferredWidth(110);
        TableColumn col8=tblstock.getColumnModel().getColumn(7);
        col8.setPreferredWidth(115);
    }
    
     private void tablelord()
    {
        try {
            String sql="SELECT stock.receive_no as 'RECEIVE NO', stock.item_number as 'ITEM NO', receivestock.item_name as 'ITEM NAME', receivestock.description as 'DESCRIPTION', stock.quentity as 'QUANTITY', receivestock.expire_date as 'EXPIER DATE', receivestock.buying_price as 'BUYING PRICE', receivestock.selling_price as 'SELLING PRICE' from stock,receivestock where stock.receive_no=receivestock.receive_no and stock.item_number=receivestock.item_number";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tblstock.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
        taheader();
    }
    
       
//    else
//    {
//    JOptionPane.showMessageDialog(rootPane, "Not details To Print");
//    }
   // }
    
    private void fullStock()
    {
        try {
             JasperDesign jasdi=JRXmlLoader.load("C:\\Users\\ccs\\Documents\\NetBeansProjects\\Inventory\\src\\report\\FullStock.jrxml");
            String sql="SELECT stock.receive_no as 'RECEIVE NO', stock.item_number as 'ITEM NO', receivestock.item_name as 'ITEM NAME', receivestock.description as 'DESCRIPTION', stock.quentity as 'QUANTITY', receivestock.expire_date as 'EXPIER DATE', receivestock.buying_price as 'BUYING PRICE', receivestock.selling_price as 'SELLING PRICE' from stock,receivestock where stock.receive_no=receivestock.receive_no and stock.item_number=receivestock.item_number";
            JRDesignQuery newQuery=new JRDesignQuery();
            newQuery.setText(sql);
            jasdi.setQuery(newQuery);              
            JasperReport js=JasperCompileManager.compileReport(jasdi);
            JasperPrint jp=JasperFillManager.fillReport(js,null,conn);
            // JasperExportManager.exportReportToHtmlFile(jp ,ore);
            JasperViewer.viewReport(jp);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }    
    }
    
    private void  filterStock()
    {
        String itemname=txtitemname.getText();
        try {
             JasperDesign jasdi=JRXmlLoader.load("C:\\Users\\ccs\\Documents\\NetBeansProjects\\Inventory\\src\\report\\FullStock.jrxml");
            String sql="SELECT stock.receive_no as 'RECEIVE NO', stock.item_number as 'ITEM NO', receivestock.item_name as 'ITEM NAME', receivestock.description as 'DESCRIPTION', stock.quentity as 'QUANTITY', receivestock.expire_date as 'EXPIER DATE', receivestock.buying_price as 'BUYING PRICE', receivestock.selling_price as 'SELLING PRICE' from stock,receivestock where stock.receive_no=receivestock.receive_no and stock.item_number=receivestock.item_number and receivestock.item_name LIKE'%"+ itemname +"%'";
            JRDesignQuery newQuery=new JRDesignQuery();
            newQuery.setText(sql);
            jasdi.setQuery(newQuery);                          
            JasperReport js=JasperCompileManager.compileReport(jasdi);
            JasperPrint jp=JasperFillManager.fillReport(js,null,conn);
            //JasperExportManager.exportReportToHtmlFile(jp ,ore);
            JasperViewer.viewReport(jp);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }    
    }
    
    private void expireStock()
    {
         String exdate=((JTextField)dateex.getDateEditor().getUiComponent()).getText();
    try {
            JasperDesign jasdi=JRXmlLoader.load("C:\\Users\\ccs\\Documents\\NetBeansProjects\\Inventory\\src\\report\\FullStock.jrxml");
            String sql="SELECT stock.receive_no as 'RECEIVE NO', stock.item_number as 'ITEM NO', receivestock.item_name as 'ITEM NAME', receivestock.description as 'DESCRIPTION', stock.quentity as 'QUANTITY', receivestock.expire_date as 'EXPIER DATE', receivestock.buying_price as 'BUYING PRICE', receivestock.selling_price as 'SELLING PRICE' from stock,receivestock where stock.receive_no=receivestock.receive_no and stock.item_number=receivestock.item_number and receivestock.expire_date <='"+exdate+"'";
            JRDesignQuery newQuery=new JRDesignQuery();
            newQuery.setText(sql);
            jasdi.setQuery(newQuery);              
            JasperReport js=JasperCompileManager.compileReport(jasdi);
            JasperPrint jp=JasperFillManager.fillReport(js,null,conn);
            // JasperExportManager.exportReportToHtmlFile(jp ,ore);
             JasperViewer.viewReport(jp);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
        
    private void dateexComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_dateexComponentAdded
     
    }//GEN-LAST:event_dateexComponentAdded

    private void dateexInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dateexInputMethodTextChanged
        
    }//GEN-LAST:event_dateexInputMethodTextChanged

    private void dateexPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateexPropertyChange
       
    }//GEN-LAST:event_dateexPropertyChange

    private void dateexHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_dateexHierarchyChanged
        
    }//GEN-LAST:event_dateexHierarchyChanged

    private void dateexKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateexKeyTyped
       
    }//GEN-LAST:event_dateexKeyTyped

    private void dateexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateexMouseClicked
        
    }//GEN-LAST:event_dateexMouseClicked

    private void dateexFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateexFocusGained
      
    }//GEN-LAST:event_dateexFocusGained

    private void txtitemnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtitemnameKeyReleased
        ((JTextField)dateex.getDateEditor().getUiComponent()).setText("");
        String itemname=txtitemname.getText();
        try {
            String sql="SELECT stock.receive_no as 'RECEIVE NO', stock.item_number as 'ITEM NO', receivestock.item_name as 'ITEM NAME', receivestock.description as 'DESCRIPTION', stock.quentity as 'QUANTITY', receivestock.expire_date as 'EXPIER DATE', receivestock.buying_price as 'BUYING PRICE', receivestock.selling_price as 'SELLING PRICE' from stock,receivestock where stock.receive_no=receivestock.receive_no and stock.item_number=receivestock.item_number and receivestock.item_name LIKE'%"+ itemname +"%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tblstock.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        taheader();
    }//GEN-LAST:event_txtitemnameKeyReleased

    private void tblstockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblstockMouseClicked
         btndelete.setEnabled(true);
    }//GEN-LAST:event_tblstockMouseClicked

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        DefaultTableModel tmodel=(DefaultTableModel)tblstock.getModel();
        int selectrowindex=tblstock.getSelectedRow();
        String reitm=(tmodel.getValueAt(selectrowindex, 0).toString());
        int x=JOptionPane.showConfirmDialog(rootPane, "Do you realy want to delete");
        if(x==0)
        {
        try {
                String sql="DELETE FROM stock where receive_no='"+ reitm +"'";
                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "successfully deleted");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane,e);
            }
       
        }
        tablelord();
        btndelete.setEnabled(false);
    }//GEN-LAST:event_btndeleteMouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        tablelord();
       ((JTextField)dateex.getDateEditor().getUiComponent()).setText("");
       txtitemname.setText("");            
       btndelete.setEnabled(false);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        int prcount=tblstock.getRowCount();
    if(prcount>0)
    {
        DefaultTableModel tableModel=(DefaultTableModel)tblstock.getModel();
        try {
            // HashMap<String, Object> para=new HashMap<>();
            // para.put("tittle","Sale Report");
            // TableModelData();
             JasperPrint jasperPrint = null;
             JasperCompileManager.compileReportToFile("C:\\Users\\ccs\\Documents\\NetBeansProjects\\Inventory\\src\\report\\stock.jrxml");
             jasperPrint = JasperFillManager.fillReport("C:\\Users\\ccs\\Documents\\NetBeansProjects\\Inventory\\src\\report\\stock.jasper", null,
             new JRTableModelDataSource(tableModel));
             JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    else
    {
        JOptionPane.showMessageDialog(rootPane, "Not Details to print");
    }    
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnfindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfindMouseClicked
       String exdate=((JTextField)dateex.getDateEditor().getUiComponent()).getText();
        if(exdate.length()>0)
        {
        txtitemname.setText("");
        try {
            String sql="SELECT stock.receive_no as 'RECEIVE NO', stock.item_number as 'ITEM NO', receivestock.item_name as 'ITEM NAME', receivestock.description as 'DESCRIPTION', stock.quentity as 'QUANTITY', receivestock.expire_date as 'EXPIER DATE', receivestock.buying_price as 'BUYING PRICE', receivestock.selling_price as 'SELLING PRICE' from stock,receivestock where stock.receive_no=receivestock.receive_no and stock.item_number=receivestock.item_number and receivestock.expire_date <='"+exdate+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tblstock.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        taheader();
        }
        else
        {
        JOptionPane.showMessageDialog(rootPane, "Select Date To Find Details");
        }
    }//GEN-LAST:event_btnfindMouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btndelete;
    private javax.swing.JPanel btnfind;
    private com.toedter.calendar.JDateChooser dateex;
    private javax.swing.JPanel jButton1;
    private javax.swing.JPanel jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblname;
    private javax.swing.JTable tblstock;
    private javax.swing.JTextField txtitemname;
    // End of variables declaration//GEN-END:variables
}
