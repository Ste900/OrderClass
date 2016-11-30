package orderclass;

import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

class NuovoStudente extends javax.swing.JFrame {

    // Variables declaration - do not modify
    private JButton Cancella;
    private JLabel CodiceFiscale;
    private JLabel Cognome;
    private JLabel Comportamento;
    private JButton Inserisci;
    private JLabel Nome;
    private JLabel Nota;
    private JLabel Sesso;
    private JLabel Voto;
    private JRadioButton btFemmina;
    private JCheckBox btInsegnanteSostegno;
    private JRadioButton btMaschio;
    private ButtonGroup buttonGroup;
    //private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JComboBox comboComportamento;
    private JComboBox comboVoto;
    private JDialog jDialog1;
    private JScrollPane jScrollPane1;
    private JButton tornaMenu;
    private JTextArea txtAreaNota;
    private JTextField txtCodiceFiscale;
    private JTextField txtCognome;
    private JTextField txtNome;
    private String sesso = "";
    OrderClass orderClass;
    // End of variables declaration

    /*
        Constructor
    */
    public NuovoStudente(OrderClass orderClass) {
        super("Nuovo studente");
        this.orderClass = orderClass;
        initComponents();
        setResizable(false);
        centra();
        buttonGroup = new ButtonGroup();
        buttonGroup.add(btFemmina);
        buttonGroup.add(btMaschio);
        //buttonGroup1.add(btInsegnanteSostegno);
    }


    private void initComponents() {

        buttonGroup = new ButtonGroup();
        //buttonGroup1 = new ButtonGroup();
        buttonGroup2 = new ButtonGroup();
        jDialog1 = new JDialog();
        Nome = new JLabel();
        Cognome = new JLabel();
        Comportamento = new JLabel();
        Voto = new JLabel();
        Sesso = new JLabel();
        btMaschio = new JRadioButton();
        btFemmina = new JRadioButton();
        Inserisci = new JButton();
        Cancella = new JButton();
        txtNome = new JTextField();
        txtCognome = new JTextField();
        btInsegnanteSostegno = new JCheckBox();
        CodiceFiscale = new JLabel();
        txtCodiceFiscale = new JTextField();
        comboVoto = new JComboBox();
        Nota = new JLabel();
        jScrollPane1 = new JScrollPane();
        txtAreaNota = new JTextArea();
        tornaMenu = new JButton();
        comboComportamento = new JComboBox();

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

        Nome.setText("Nome");

        Cognome.setText("Cognome");

        Comportamento.setText("Comportamento");

        Voto.setText("Voto");

        Sesso.setText("Sesso");

        btMaschio.setText("Maschio");
        btMaschio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMaschioActionPerformed(evt);
            }
        });

        btFemmina.setText("Femmina");
        btFemmina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFemminaActionPerformed(evt);
            }
        });

        Inserisci.setText("Inserisci");
        Inserisci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InserisciActionPerformed(evt);
            }
        });

        Cancella.setText("Cancella");
        Cancella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancellaActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtCognome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCognomeActionPerformed(evt);
            }
        });

        btInsegnanteSostegno.setText("Necessità di insegnante di sostegno");
        btInsegnanteSostegno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsegnanteSostegnoActionPerformed(evt);
            }
        });

        CodiceFiscale.setText("Codice fiscale");

        txtCodiceFiscale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodiceFiscaleActionPerformed(evt);
            }
        });

        comboVoto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6", "7", "8", "9", "10" }));
        comboVoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVotoActionPerformed(evt);
            }
        });

        Nota.setText("Nota");

        txtAreaNota.setColumns(20);
        txtAreaNota.setRows(5);
        jScrollPane1.setViewportView(txtAreaNota);

        tornaMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageLogo/back.png"))); // NOI18N
        tornaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornaMenuActionPerformed(evt);
            }
        });

        comboComportamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6", "7", "8", "9", "10" }));
        comboComportamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboComportamentoActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Inserisci, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(Cancella, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Sesso)
                                .addGap(18, 18, 18)
                                .addComponent(btMaschio)
                                .addGap(35, 35, 35)
                                .addComponent(btFemmina))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(Cognome, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCognome, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Comportamento)
                                        .addComponent(Voto))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboVoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboComportamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CodiceFiscale)
                                .addGap(79, 79, 79)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodiceFiscale, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nota)
                            .addComponent(btInsegnanteSostegno)
                            .addComponent(tornaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tornaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cognome)
                    .addComponent(txtCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Comportamento)
                    .addComponent(comboComportamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Voto)
                    .addComponent(comboVoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodiceFiscale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodiceFiscale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nota)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sesso)
                    .addComponent(btMaschio)
                    .addComponent(btFemmina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btInsegnanteSostegno)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Inserisci, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancella, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void btMaschioActionPerformed(java.awt.event.ActionEvent evt) {
        sesso = "maschio";
    }

    private void btFemminaActionPerformed(java.awt.event.ActionEvent evt) {
        sesso = "femmina";
    }

    private void CancellaActionPerformed(java.awt.event.ActionEvent evt) {
        txtNome.setText("");
        txtCognome.setText("");
        txtCodiceFiscale.setText("");
        txtAreaNota.setText("");
        buttonGroup.setSelected(new DefaultButtonModel (), true);
        btInsegnanteSostegno.setSelected(false);
        //buttonGroup1.setSelected(new DefaultButtonModel (), true);
        comboVoto.setSelectedIndex(0);
        comboComportamento.setSelectedIndex(0);
    }

    private void txtCognomeActionPerformed(java.awt.event.ActionEvent evt) {    }

    private void btInsegnanteSostegnoActionPerformed(java.awt.event.ActionEvent evt) {    }


    private void txtCodiceFiscaleActionPerformed(java.awt.event.ActionEvent evt) {    }

    private void comboVotoActionPerformed(java.awt.event.ActionEvent evt) {    }

    private void tornaMenuActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        orderClass.setVisible(true);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this,
            "Vuoi chiudere il programma?", "Chiusura",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            System.exit(0);
        }else{
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    private void comboComportamentoActionPerformed(java.awt.event.ActionEvent evt) {    }

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

    private void InserisciActionPerformed(java.awt.event.ActionEvent evt) {
        if(Controllo()) {
            Studente studente = new Studente();
            studente.setNome(txtNome.getText());
            studente.setCognome(txtCognome.getText());
            studente.setSesso(sesso);
            studente.setComportamento(Integer.parseInt(comboComportamento.getSelectedItem().toString()));
            studente.setVoto(Integer.parseInt(comboVoto.getSelectedItem().toString()));
            studente.setSostegno(btInsegnanteSostegno.isSelected());
            studente.setNota(txtAreaNota.getText());
            studente.setCodiceFiscale(txtCodiceFiscale.getText());
            System.out.println(
                "Studente\n"
                + "\t" + "nome: " + studente.getNome() + "\n"
                + "\t" + "cognome: " + studente.getCognome() + "\n"
                + "\t" + "sesso: " + studente.getSesso() + "\n"
                + "\t" + "comportamento: " + studente.getComportamento() + "\n"
                + "\t" + "voto: " + studente.getVoto() + "\n"
                + "\t" + "insegnante di sostegno: " + studente.getSostegno() + "\n"
                + "\t" + "nota: " + studente.getNota() + "\n"
                + "\t" + "codice fiscale: " + studente.getCodiceFiscale() + "\n"
            );

            orderClass.AddStudente(studente);
            txtNome.setText("");
            txtCognome.setText("");
            txtCodiceFiscale.setText("");
            txtAreaNota.setText("");
            buttonGroup.setSelected(new DefaultButtonModel (), true);
            btInsegnanteSostegno.setSelected(false);
            //buttonGroup1.setSelected(new DefaultButtonModel (), true);
            comboVoto.setSelectedIndex(0);
            comboComportamento.setSelectedIndex(0);

            Object[] options = {"OK"};
            int n = JOptionPane.showOptionDialog(this,
                       "Studente inserito.","Conferma",
                       JOptionPane.PLAIN_MESSAGE,
                       JOptionPane.INFORMATION_MESSAGE,
                       null,
                       options,
                       options[0]);

            //this.setVisible(false);
            //finestra.setVisible(true);
        } else {
            Object[] options = {"OK"};
            JOptionPane.showOptionDialog(this,
                       "Controlla i dati inseriti, potrebbe esserci qualche campo incompleto.","Errore",
                       JOptionPane.PLAIN_MESSAGE,
                       JOptionPane.INFORMATION_MESSAGE,
                       null,
                       options,
                       options[0]);
            System.out.println("Controlla i dati inseriti, potrebbe esserci qualche campo incompleto");
        }
    }

    /*
        Controllo sui dati dello studente
    */
    private boolean Controllo() {
        boolean continua = true;
        if (txtNome.getText().equals("")) {
            System.out.println("nome non inserito");
            continua = false;
        }

        if (txtCognome.getText().equals("")) {
            System.out.println("cognome non inserito");
            continua = false;
        }

        if (sesso.equals("")) {
            System.out.println("sesso non inserito");
            continua = false;
        }

        if (txtCodiceFiscale.getText().equals("")) {
            System.out.println("codice fiscale non inserito");
            continua = false;
        }

        return continua;
    }

}
