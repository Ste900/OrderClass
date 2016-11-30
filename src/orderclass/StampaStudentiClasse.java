package orderclass;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

class StampaStudentiClasse extends JFrame {

    // Variables declaration - do not modify
    private JDialog jDialog1;
    private JScrollPane jScrollPane1;
    private JTable tabElenco;
    private Classe classe;
    private CreaClassi creaClassi;
    private JButton tornaMenu;
    // End of variables declaration

    public StampaStudentiClasse(Classe classe, CreaClassi creaClassi) {
        super("Sezione " + classe.getNome());
        this.classe = classe;
        this.creaClassi = creaClassi;
        initComponents();
        setResizable(false);
        centra();
        run();
    }

    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabElenco = new javax.swing.JTable();
        tornaMenu = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imageLogo/Immagine24.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabElenco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cognome", "Voto", "Comportamento", "Cod. Fisc.", "Necessità di assistenza", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }


        });
        tabElenco.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabElenco);

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tornaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tornaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
    public void setDefaultCloseOperation(int operation){    }

    private void tornaMenuActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.setVisible(false);
        creaClassi.aggiorna();
        creaClassi.setVisible(true);
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
            java.util.logging.Logger.getLogger(StampaStudentiClasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StampaStudentiClasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StampaStudentiClasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StampaStudentiClasse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StampaStudentiClasse().setVisible(true);
            }
        });
    }
*/
    public void centra(){
        Dimension dim=getToolkit().getScreenSize();
        setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2);
    }


    DefaultTableModel model;
    public void run() {
        model = (DefaultTableModel)tabElenco.getModel();
        tabElenco.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabElenco.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                try{
                    ArrayList <Studente> stu = classe.getStudenti();
                    Studente s1 = stu.get(tabElenco.getSelectedRow());
                    /*
                    String s = (String)JOptionPane.showInputDialog(
                        null,
                        "Nome: " + s1.getNome() + "\n"
                        + "Cognome: " + s1.getCognome() + "\n" +
                        "Nota: " + s1.getNota() + "\n"+
                        "Inserisci classe :\n",
                        "Sposta studente",
                        JOptionPane.PLAIN_MESSAGE
                    );
                    */
                    String choices [] = creaClassi.getNomeClassi();
                    String s = (String) JOptionPane.showInputDialog(
                        null,
                        "Nome: " + s1.getNome() + "\n"
                        + "Cognome: " + s1.getCognome() + "\n" +
                        "Nota: " + s1.getNota() + "\n"+
                        "Vuoi spostare lo studente?\nInserisci classe :\n",
                        "Informazioni studente",
                        JOptionPane.QUESTION_MESSAGE, null,
                        choices, // Array of choices
                        choices[0]);
                    if(s.isEmpty()){
                            /*
                            JOptionPane.showMessageDialog(
                            null,
                            "Errore. Devi inserire una classe.",
                            "Riprova",
                            JOptionPane.ERROR_MESSAGE);
                            */
                    } else {
                        if(s.equalsIgnoreCase(classe.getNome())) {
                            JOptionPane.showMessageDialog(
                                null,
                                "Non puoi spostarlo nella stessa classe",
                                "Errore",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (classe.getStudenti().size() > 1) {
                                Classe[] cl = creaClassi.getClassi();
                                for (int i = 0; i < creaClassi.getClassi().length; i ++) {
                                    if (s.equals(cl[i].getNome())) {
                                        cl[i].addStudente(s1);
                                        for (int j = 0; j < creaClassi.getClassi().length; j ++) {
                                            if (cl[j].getNome().equals(classe.getNome())) {
                                                cl[j].removeStudente(tabElenco.getSelectedRow());
                                                System.out.println("classe.getNome(): " + classe.getNome());
                                            }
                                            System.out.println("classe.getNome(): " + classe.getNome());
                                            System.out.println("cl[i].getNome(): " + cl[j].getNome() + "\n\ti: " + i);
                                        }
                                    }
                                }
                                creaClassi.setClassi(cl);
                                model.removeRow(tabElenco.getSelectedRow());
                            } else {
                                /*
                                JOptionPane.showMessageDialog(
                                null,
                                "La classe verrà eliminata",
                                "Ok",
                                JOptionPane.ERROR_MESSAGE);
                                */
                                /*





                                */
                            }
                        }
                    }
                } catch(NullPointerException ne){    }
            }
        }
        });
        for (int i = 0; i < classe.getStudenti().size(); i++) {
            model.setRowCount(model.getRowCount() + 1);
            ArrayList <Studente> s = classe.getStudenti();
            Studente s1 = s.get(i);
            model.setValueAt(s1.getNome(), model.getRowCount() - 1, 0);
            model.setValueAt(s1.getCognome(), model.getRowCount() - 1, 1);
            model.setValueAt(s1.getVoto(), model.getRowCount() - 1, 2);
            model.setValueAt(s1.getComportamento(), model.getRowCount() - 1, 3);
            model.setValueAt(s1.getCodiceFiscale(), model.getRowCount() - 1, 4);
            if (s1.getSostegno()) {
                model.setValueAt(true, model.getRowCount() - 1, 5);
            } else {
                model.setValueAt(false, model.getRowCount() - 1, 5);
            }
            if (s1.getNota().equals("")) {
                model.setValueAt(false, model.getRowCount() - 1, 6);
            } else {
                model.setValueAt(true, model.getRowCount() - 1, 6);
            }

        }
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

}
