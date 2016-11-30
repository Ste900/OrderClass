package orderclass;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

class StampaStudente extends JFrame implements Runnable {

    // Variables declaration - do not modify
    private JScrollPane jScrollPane2;
    private JTable tabStampaStudenti;
    private JButton tornaMenu;
    private OrderClass orderClass;
    // End of variables declaration

    public StampaStudente(OrderClass orderClass) {
        super("Elenco");
        this.orderClass = orderClass;
        initComponents();
        setResizable(false);
        centra();
        run();
    }


    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabStampaStudenti = new javax.swing.JTable();
        tornaMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imageLogo/Immagine24.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabStampaStudenti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cognome", "Sesso", "Voto", "Comportamento", "Codice fiscale", "Insegnante sostegno", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        tabStampaStudenti.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabStampaStudenti);

        tornaMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageLogo/back.png"))); // NOI18N
        tornaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tornaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tornaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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
            java.util.logging.Logger.getLogger(StampaStudente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StampaStudente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StampaStudente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StampaStudente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StampaStudente().setVisible(true);
            }
        });
    }
*/

    public void centra(){
        Dimension dim=getToolkit().getScreenSize();
        setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2);
    }


    public void run() {
        DefaultTableModel model = (DefaultTableModel)tabStampaStudenti.getModel();
        tabStampaStudenti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabStampaStudenti.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
               try{
                    ArrayList <Studente> stu = orderClass.getStudenti();
                    Studente s1 = stu.get(tabStampaStudenti.getSelectedRow());
                    Object[] options = {"OK"};
                    JOptionPane.showOptionDialog(null ,
                       "Nome: " + s1.getNome() + "\n"
                        + "Cognome: " + s1.getCognome() + "\n" +
                        "Nota: " + s1.getNota() + "\n",
                        "Note",
                       JOptionPane.PLAIN_MESSAGE,
                       JOptionPane.INFORMATION_MESSAGE,
                       null,
                       options,
                       options[0]);
               }catch(NullPointerException ne){    }
            }
        }
        });
        for (int i = 0; i < orderClass.getStudenti().size(); i++) {
            Studente s = orderClass.getStudenti().get(i);
            model.setRowCount(model.getRowCount() + 1);
            model.setValueAt(s.getNome(), model.getRowCount() - 1, 0);
            model.setValueAt(s.getCognome(), model.getRowCount() - 1, 1);
            model.setValueAt(s.getSesso(), model.getRowCount() - 1, 2);
            model.setValueAt(s.getVoto(), model.getRowCount() - 1, 3);
            model.setValueAt(s.getComportamento(), model.getRowCount() - 1, 4);
            model.setValueAt(s.getCodiceFiscale(), model.getRowCount() - 1, 5);
            if (s.getSostegno()) {
                model.setValueAt(true, model.getRowCount() - 1, 6);
            } else {
                model.setValueAt(false, model.getRowCount() - 1, 6);
            }
            if (s.getNota().equals("")) {
                model.setValueAt(false, model.getRowCount() - 1, 7);
            } else {
                model.setValueAt(true, model.getRowCount() - 1, 7);
            }
        }
    }

}
