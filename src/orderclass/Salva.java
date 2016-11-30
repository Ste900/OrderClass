package orderclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Salva {

    public Salva(ArrayList<Studente> studenti) {
        JFrame parentFrame = new JFrame();
        
        File fileToSave = null;
 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salva con nome");

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
        }
        try {
            FileOutputStream fos = new FileOutputStream(fileToSave.getAbsolutePath());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
/*
            System.out.println("asdfglkjòjfgds");
            for(int i = 0; i < studenti.size(); i ++) {
                oos.writeObject(studenti.get(i).getNome());
                oos.writeObject(studenti.get(i).getCognome());
                oos.writeObject(studenti.get(i).getComportamento());
                oos.writeObject(studenti.get(i).getVoto());
                oos.writeObject(studenti.get(i).getCodiceFiscale());
                oos.writeObject(studenti.get(i).getSesso());
                oos.writeObject(studenti.get(i).getNota());
                oos.writeObject(studenti.get(i).getSostegno());
            }
*/
            oos.writeObject(studenti);
            oos.close();
            fos.close();
            
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Salva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(Salva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Salva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
