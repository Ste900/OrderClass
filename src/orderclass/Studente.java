package orderclass;

import java.io.Serializable;

class Studente implements Serializable {
    private String nome;
    private String cognome;
    private String sesso;
    private int comportamento;
    private int voto;
    private boolean sostegno;
    private String nota;
    private String codiceFiscale;


    /*
        Set proprietà
    */

    public void setNome(String a){
       nome = a;
    }

    public void setCognome(String a){
       cognome = a;
    }

    public void setSesso(String a){
        sesso = a;
    }

    public void setComportamento(int a){
       comportamento = a;
    }

    public void setVoto(int a){
       voto = a;
    }

    public void setSostegno(boolean a){
       sostegno = a;
    }

    public void setNota(String a){
       nota = a;
    }

    public void setCodiceFiscale(String a){
       codiceFiscale = a;
    }

    /*
        Get proprietà
    */

    public String getNome(){
       return nome;
    }

    public String getCognome(){
       return cognome;
    }

    public String getSesso(){
       return sesso;
    }

    public int getComportamento(){
       return comportamento;
    }

    public int getVoto(){
       return voto;
    }

    public boolean getSostegno(){
       return sostegno;
    }

    public String getNota(){
       return nota;
    }

    public String getCodiceFiscale(){
       return codiceFiscale;
    }
}
