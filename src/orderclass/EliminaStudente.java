package orderclass;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

class EliminaStudente extends JFrame {

    // Variables declaration - do not modify
    private OrderClass orderClass;
    private JButton Elimina;
    private JFrame jFrame1;
    private JScrollPane jScrollPane1;
    private JTable tabellaElimina;
    private JButton tornaMenu;
    private JButton AnnullaE;
    private JLabel Cognome;
    private JLabel ComportamentoE;
    private JButton InserisciE;
    private JLabel Nome;
    private JLabel Sesso;
    private JLabel Voto;
    private JRadioButton btFemmina;
    private JRadioButton btMaschio;
    private JTextField txtCognome;
    private JTextField txtComportamentoE;
    private JTextField txtNome;
    private JTextField txtVoto;
    DefaultTableModel model;
    // End of variables declaration

    public EliminaStudente(OrderClass orderClass) {
        super("Elimina studente");
        this.orderClass = orderClass;
        initComponents();
        setResizable(false);
        centra();
        run();

    }

    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        Elimina = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaElimina = new javax.swing.JTable();
        tornaMenu = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imageLogo/Immagine24.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Elimina.setText("Elimina");
        Elimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminaActionPerformed(evt);
            }
        });

        tabellaElimina.setModel(new javax.swing.table.DefaultTableModel(
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
        tabellaElimina.getTableHeader().setReorderingAllowed(false);

        jScrollPane1.setViewportView(tabellaElimina);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Elimina, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(tornaMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tornaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Elimina, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }

    private void EliminaActionPerformed(java.awt.event.ActionEvent evt) {
        
        Object[] options = { "Ok", "Annulla" };
        int colonnaSelezionata = tabellaElimina.getSelectedRow();
        if (JOptionPane.showOptionDialog(null, "Clicca ok per eliminare " + orderClass.getStudenti().get(colonnaSelezionata).getNome() + " " + orderClass.getStudenti().get(colonnaSelezionata).getCognome()+  ".", "Attenzione",
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
            null, options, options[0]) == JOptionPane.YES_OPTION){
                
                System.out.println(colonnaSelezionata);
                //System.out.println(orderClass);
                // Controllo che sia selezionata una riga
                if (colonnaSelezionata != -1) {
                    orderClass.removeStudenti(colonnaSelezionata);
                    model.removeRow(colonnaSelezionata);
                }
        }
        
        
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
            java.util.logging.Logger.getLogger(NuovoStudente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuovoStudente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuovoStudente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuovoStudente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuovoStudente().setVisible(true);
            }
        });
    }
*/

    public void centra(){
        Dimension dim=getToolkit().getScreenSize();
        setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2);
    }

    public void run() {
        model = (DefaultTableModel)tabellaElimina.getModel();
        tabellaElimina.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabellaElimina.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
               try{
                    ArrayList <Studente> stu = orderClass.getStudenti();
                    Studente s1 = stu.get(tabellaElimina.getSelectedRow());
                    Object[] options = {"OK"};
                    JOptionPane.showOptionDialog(null ,
                       "Nome: " + s1.getNome() + "\n"
                        + "Cognome: " + s1.getCognome() + "\n" +
                        "Nota: " + s1.getNota() + "\n",
                        "Conferma",
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
            model.setValueAt(s.getSostegno(), model.getRowCount() - 1, 6);
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
