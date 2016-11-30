package orderclass;

import java.util.ArrayList;

public class CreaClasse {

    public String Sezione[] = new String[]{
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "Z"
    };

    /*
        Ordinamento in ordine cresciente degli studenti
    */

    public ArrayList OrdinaStudenti(ArrayList<Studente> studenti) {
        ArrayList<Studente> studentiOrdinati = new ArrayList<>();
        System.out.println("Ordina studenti");
        System.out.println("studenti.size(): " + studenti.size());
        // Comportamento1
        for(int i = 10; i >= 6; i --){
            // Voto
            for(int j = 10; j >= 6; j --){
            /*
                Confronta i dati dello studente con due variabili.
                Gli studenti vengono messi in ordine crescente in base ai valori dati dal comportamento e dal voto.
            */
                for(int x = 0; x < studenti.size(); x ++){
                    int c = studenti.get(x).getComportamento();
                    int v = studenti.get(x).getVoto();
                    if(c == i && v == j){
                        studentiOrdinati.add(studenti.get(x));
                    }
                }
            }
        }
        // AreaProgetto.StampaStudenti(studentiOrdinati);
        System.out.println("studentiOrdinati.size(): " + studentiOrdinati.size());
        return studentiOrdinati;
    }


    /*
        Suddivisione degli studenti nelle classi
    */

    public ArrayList DivisioneStudentiMF(ArrayList<Studente> studenti) {
        ArrayList<Studente> stu = new ArrayList<>();
        // Divisione maschi femmine
        System.out.println("Dimensione array studenti: " + studenti.size());
        for(int i = 0; i < studenti.size(); i++) {
            if(studenti.get(i).getSesso().equals("maschio")){
                stu.add(studenti.get(i));
            }
        }
        for(int i = 0; i < studenti.size(); i++) {
            if(studenti.get(i).getSesso().equals("femmina")){
                stu.add(studenti.get(i));
            }
        }
        return stu;
    }

    public Classe[] Classi(ArrayList<Studente> stu, int nClassi) {

        Classe[] classi = new Classe[nClassi];
        for (int i = 0; i < nClassi; i ++) {
            classi[i] = new Classe();
            classi[i].setNome(Sezione[i]);
        }

        int c = 0;
        //ArrayList<Classe> classe = new ArrayList<>();
        System.out.println("stu.size: " + stu.size());
        for(int i = 0; i < stu.size();  i++){
            try {
                classi[c].addStudente(stu.get(i));
            } catch (Exception e) {
                System.out.println("Errore: " + e);
            }
            c++;
            if(c >= nClassi){
                c = 0;
            }
        }
        return classi;
    }
}
