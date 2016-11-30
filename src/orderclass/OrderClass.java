package orderclass;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class OrderClass extends javax.swing.JFrame {

    // Variables declaration
        private JButton CreaClassi;
        private JButton EliminaStudente;
        private JButton NuovoStudente;
        private JButton StampaStudente;
        private JLabel Titolo;
        private JMenu jMenu1;
        private JMenuBar jMenuBar1;
        private JMenu jMenu2;
        private ArrayList<Studente> studenti = new ArrayList<Studente>();   // Lista studenti
        // private Classe[] classe = null;   // Lista classi
        // private boolean fine = true;
        // private CreaClasse cc = new CreaClasse();
        // private GestioneStudente gestioneStudente = new GestioneStudente();

    // End of variables declaration
    


    /*
        Constructor
    */
    public OrderClass() {
        super("Menu");
        initComponents();
        setResizable(false);
        centra();
    }

    private void initComponents() {

        Titolo = new javax.swing.JLabel();
        NuovoStudente = new javax.swing.JButton();
        StampaStudente = new javax.swing.JButton();
        EliminaStudente = new javax.swing.JButton();
        CreaClassi = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imageLogo/Immagine24.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Titolo.setFont(new java.awt.Font("Tahoma", 0, 48));
        Titolo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageLogo/Logo.png")));

        NuovoStudente.setText("Nuovo studente");
        NuovoStudente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuovoStudenteActionPerformed(evt);
            }
        });

        StampaStudente.setText("Visualizza studenti");
        StampaStudente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StampaStudenteActionPerformed(evt);
            }
        });

        EliminaStudente.setText("Elimina studente");
        EliminaStudente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminaStudenteActionPerformed(evt);
            }
        });

        CreaClassi.setText("Crea classi");
        CreaClassi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreaClassiActionPerformed(evt);
            }
        });

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageLogo/save.PNG"))); // NOI18N
        jMenu1.setText("Salva");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageLogo/Apri.png"))); // NOI18N
        jMenu2.setText("Apri");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(EliminaStudente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CreaClassi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NuovoStudente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(StampaStudente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(Titolo)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titolo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NuovoStudente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StampaStudente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreaClassi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminaStudente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }

    private void NuovoStudenteActionPerformed(java.awt.event.ActionEvent evt) {
        NuovoStudente ns = new NuovoStudente(this);
        this.setVisible(false);
        ns.setVisible(true);
    }

    private void StampaStudenteActionPerformed(java.awt.event.ActionEvent evt) {
        StampaStudente ss = new StampaStudente(this);
        this.setVisible(false);
        ss.setVisible(true);
    }

    private void EliminaStudenteActionPerformed(java.awt.event.ActionEvent evt) {
        EliminaStudente es = new EliminaStudente(this);
        this.setVisible(false);
        es.setVisible(true);
    }
    
    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {                                    
        System.out.println("jMenu1MouseClicked");
        Salva salva = new Salva(studenti);
/*
            Object[] options = {"OK"};
            JOptionPane.showOptionDialog(null ,
            "Salvataggio effettuato",
            "Conferma",
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]);
             */
    }
    
    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {

        System.out.println("jMenu1MouseClicked");
        Apri apri = new Apri();
        // studenti = apri.LeggiFile(studenti);
        studenti = apri.LeggiFile();
        
/*    
        Object[] options = {"OK"};
        JOptionPane.showOptionDialog(null ,
           "Apertura file effettuata",
            "Conferma",
           JOptionPane.PLAIN_MESSAGE,
           JOptionPane.INFORMATION_MESSAGE,
           null,
           options,
           options[0]);
*/
    }

    private void CreaClassiActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            String s = (String)JOptionPane.showInputDialog(
                      null,
                      "Inserisci numero: ",
                      "Crea classi",
                      JOptionPane.PLAIN_MESSAGE
            );
            if(s.isEmpty()){
                JOptionPane.showMessageDialog(
                this,
                "Errore. Devi inserire un numero.",
                "Riprova",
                JOptionPane.ERROR_MESSAGE);
            }else{
                if(!studenti.isEmpty()){
                    if(studenti.size() >= Integer.parseInt(s)){
                        if(Integer.parseInt(s) > 0){
                            System.out.println("Numero classi" + s);
                            CreaClasse cc = new CreaClasse();
                            System.out.println("cc.Sezione.length: " + cc.Sezione.length);
                            if(Integer.parseInt(s) <= (cc.Sezione.length)){
                                ArrayList<Studente> s1 = new ArrayList<>();
                                s1 = cc.OrdinaStudenti(studenti);
                                System.out.println("s1.size dopo OrdinaStudenti: " + s1.size());
                                s1 = cc.DivisioneStudentiMF(s1);
                                System.out.println("s1.size dopo DivisioneStudentiMF: " + s1.size());
                                int nClassi = Integer.parseInt(s);
                                Classe[] classe = cc.Classi(s1, nClassi);

                                // Calcola media
                                int media = studenti.size() / nClassi;



                                Object[] message = {"Numero medio di studenti per classe: " + media + "\nVa bene?"};
                                Object[] options = { "Continua", "Annulla" };
                                int n = JOptionPane.showOptionDialog(this,
                                        message, "Media",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                        options, options[1]);
                                if (n == JOptionPane.OK_OPTION){
                                    CreaClassi creaClassi = new CreaClassi(this, classe);
                                    this.setVisible(false);
                                    creaClassi.setVisible(true);
                                }
                            } else {
                                System.out.println("Il limite massimo di classi è " + cc.Sezione.length);
                            JOptionPane.showMessageDialog(
                                this,
                                "Il limite massimo di classi è " + cc.Sezione.length,
                                "Errore",
                                JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            System.out.println("Il numero degli studenti non può essere negativo o nullo");
                            JOptionPane.showMessageDialog(
                                this,
                                "Il numero degli studenti non può essere negativo o nullo",
                                "Errore",
                                JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        System.out.println("Il numero degli studenti è minore del numero delle classi");
                        JOptionPane.showMessageDialog(
                            this,
                            "Il numero degli studenti è minore del numero delle classi",
                            "Errore",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    // Caso in cui la lista è vuota
                    System.out.println("Non sono presenti studenti");
                    JOptionPane.showMessageDialog(
                        this,
                        "Non sono presenti studenti",
                        "Errore",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }catch(NullPointerException ne){}
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
        Main method
    */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderClass().setVisible(true);
            }
        });

    }

    /*
        Place the windows at center of the screen
    */
    public void centra(){
        Dimension dim=getToolkit().getScreenSize();
        setLocation(dim.width/2 - this.getWidth()/2, dim.height/2 - this.getHeight()/2);
    }

    /*
        Add Studente to ArrayList 'studenti'
    */
    public void AddStudente(Studente s) {
        studenti.add(s);
        System.out.println(
            s + "\n"
            + "\t" + "nome: " + s.getNome() + "\n"
            + "\t" + "cognome: " + s.getCognome() + "\n"
            + "\t" + "sesso: " + s.getSesso() + "\n"
            + "\t" + "comportamento: " + s.getComportamento() + "\n"
            + "\t" + "voto: " + s.getVoto() + "\n"
            + "\t" + "insegnante di sostegno: " + s.getSostegno() + "\n"
            + "\t" + "nota: " + s.getNota() + "\n"
            + "\t" + "codice fiscale: " + s.getCodiceFiscale() + "\n"
        );
    }
    /*
        Getter - return the ArrayList 'studenti'
    */

    public ArrayList<Studente> getStudenti () {
        return studenti;
    }
/*
    public void setStudenti (ArrayList<Studente> s) {
        this.studenti = s;
    }
*/

    public void removeStudenti (int n) {
        this.studenti.remove(n);
    }


}