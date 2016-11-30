package orderclass;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

class CreaClassi extends JFrame {

    // Variables declaration - do not modify
    private JScrollPane jScrollPane1;
    private JTable tabellaClassi;
    private JButton tornaMenu;
    private OrderClass orderClass;
    private Classe[] classe;
    private JButton jButton1;
    private CreaClassi cl = this;
    // End of variables declaration
    

    public CreaClassi(OrderClass orderClass, Classe[] classe) {
        super("Crea Classi");
        this.orderClass = orderClass;
        this.classe = classe;
        initComponents();
        setResizable(false);
        centra();
        run();
    }


    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaClassi = new javax.swing.JTable();
        tornaMenu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imageLogo/Immagine24.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabellaClassi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Classe", "Numero studenti"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabellaClassi.setName(""); // NOI18N
        jScrollPane1.setViewportView(tabellaClassi);

        tornaMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageLogo/back.png"))); // NOI18N
        tornaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaMenuActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageLogo/unnamed.png"))); // NOI18N
        jButton1.setText("Esporta in Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tornaMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tornaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        pack();
    }

    private void tornaMenuActionPerformed(java.awt.event.ActionEvent evt) {
        orderClass.setVisible(true);
        this.setVisible(false);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        if (JOptionPane.showConfirmDialog(this,
            "Vuoi chiudere il programma?", "Chiusura",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            System.exit(0);
        }else{
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

/*
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreaClassi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreaClassi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreaClassi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreaClassi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreaClassi().setVisible(true);
            }
        });
    }
*/

    public void centra(){
        Dimension dim=getToolkit().getScreenSize();
        setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2);
    }

    // Esporta in Excel
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
            new SalvaExcel(classe);
            Object[] options = {"OK"};
            JOptionPane.showOptionDialog(null ,
               "Esportazione eseguita",
                "Conferma",
               JOptionPane.PLAIN_MESSAGE,
               JOptionPane.INFORMATION_MESSAGE,
               null,
               options,
               options[0]);
    }

    DefaultTableModel model;
    public void run() {
        model = (DefaultTableModel)tabellaClassi.getModel();
        tabellaClassi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //tabellaClassi.setRowSelectionAllowed (true);
        //tabellaClassi.setColumnSelectionAllowed (true);
        tabellaClassi.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int colonnaSelezionata = tabellaClassi.getSelectedRow();
                    StampaStudentiClasse ssc = new StampaStudentiClasse(classe[tabellaClassi.getSelectedRow()], cl);
                    cl.setVisible(false);
                    ssc.setVisible(true);
                }
            }
        });
        for (int i = 0; i < classe.length; i++) {
            model.setRowCount(model.getRowCount() + 1);
            model.setValueAt(classe[i].getNome(), model.getRowCount() - 1, 0);
            model.setValueAt(classe[i].getStudenti().size(), model.getRowCount() - 1, 1);
        }
    }
    
    public void aggiorna() {
        int k = model.getRowCount();
        for (int i = 0; i < k; i++) {
            System.out.println("model.getRowCount(): " + model.getRowCount());
            model.removeRow(0);
        }

        for (int j = 0; j < classe.length; j++) {
            model.setRowCount(model.getRowCount() + 1);
            model.setValueAt(classe[j].getNome(), model.getRowCount() - 1, 0);
            model.setValueAt(classe[j].getStudenti().size(), model.getRowCount() - 1, 1);
        }
    }
    
    public void setClassi (Classe classi []) {
        this.classe = classi;
    }
    
    public Classe[] getClassi () {
        return classe;
    }
    
    public String[] getNomeClassi () {
        String Nomi[] = new String [classe.length];
        for (int i = 0; i < classe.length; i ++) {
            Nomi[i] = classe[i].getNome();
        }
        return Nomi;
    }

}
