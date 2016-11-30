package orderclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;



public class Apri {
    
    
    public ArrayList<Studente> LeggiFile() {
        JFrame parentFrame = new JFrame();

        File fileToOpen = null;

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Apri file");

        int userSelection = fileChooser.showOpenDialog(parentFrame);

        fileToOpen = fileChooser.getSelectedFile();
        System.out.println("Open as file: " + fileToOpen.getAbsolutePath());

/*
    ArrayList<Studente> LeggiFile(ArrayList<Studente> studentiVecchio) {
        ArrayList<Studente> studenti = studentiVecchio;
        try {
            FileInputStream fis = new FileInputStream("Salvataggio");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Studente> arrayList = (ArrayList<Studente>) ois.readObject();
            ois.close();
            fis.close();
            for(int i = 0; i < arrayList.size(); i ++) {
                studenti.add(arrayList.get(i));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Apri.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
                Logger.getLogger(Apri.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Apri.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Apri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studenti;
    }
*/
    
    
        ArrayList<Studente> studenti = new ArrayList();
        try {
            FileInputStream fis = new FileInputStream(fileToOpen.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Studente> arrayList = (ArrayList<Studente>) ois.readObject();
            ois.close();
            fis.close();
            for(int i = 0; i < arrayList.size(); i ++) {
                studenti.add(arrayList.get(i));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Apri.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Apri.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Apri.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Apri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studenti;
    }

}
