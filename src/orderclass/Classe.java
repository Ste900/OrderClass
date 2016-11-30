package orderclass;

import java.util.ArrayList;

public class Classe {
    private String nome_classe;
    private ArrayList<Studente> studenti = new ArrayList<Studente>();

    /*
        Set propietà
    */
    public void setNome(String nc){
        this.nome_classe=nc;
    }

    public void addStudente(Studente s){
        studenti.add(s);
    }
    
    public void removeStudente(int position){
        studenti.remove(position);
    }

    /*
        Get propietà
    */
    public String getNome(){
        return nome_classe;
    }

    public ArrayList getStudenti(){
        return studenti;
    }
}
