/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderclass;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author brivio.stefano
 */
public class SalvaExcel {

    public SalvaExcel(Classe[] classi) {
        JFrame parentFrame = new JFrame();
        
        File fileToSave = null;
 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salva con nome");

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
        }

        String fileName = fileToSave.getAbsolutePath() + ".xls";
        WritableWorkbook writableWorkbook = null;
        try {
             writableWorkbook = Workbook.createWorkbook(new File(fileName));
             
             
        } catch (IOException ex) {
            Logger.getLogger(SalvaExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        WritableSheet writableSheet = writableWorkbook.createSheet("Sheet1", 0);

        int riga = 0;
        Label l1 = new Label(0, riga, "Nome");
        Label l2 = new Label(1, riga, "Cognome");
        Label l3 = new Label(2, riga, "Sesso");
        Label l4 = new Label(3, riga, "Voto");
        Label l5 = new Label(4, riga, "Comportamento");
        riga ++;
        try {
            writableSheet.addCell(l1);
            writableSheet.addCell(l2);
            writableSheet.addCell(l3);
            writableSheet.addCell(l4);
            writableSheet.addCell(l5);
        } catch (WriteException ex) {
            Logger.getLogger(SalvaExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i < classi.length; i ++) {
            Label label = new Label(0, riga, "Classe " + classi[i].getNome());
            try {
                writableSheet.addCell(label);
            } catch (WriteException ex) {
                Logger.getLogger(SalvaExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
            riga ++;
            for(int j = 0; j < classi[i].getStudenti().size(); j ++) {
                Studente s = (Studente)classi[i].getStudenti().get(j);
                Label label1 = new Label(0, riga, s.getNome());
                Label label2 = new Label(1, riga, s.getCognome());
                Label label3 = new Label(2, riga, s.getSesso());
                Label label4 = new Label(3, riga, s.getVoto() + "");
                Label label5 = new Label(4, riga, s.getComportamento() + "");
                riga ++;
                try {
                    writableSheet.addCell(label1);
                    writableSheet.addCell(label2);
                    writableSheet.addCell(label3);
                    writableSheet.addCell(label4);
                    writableSheet.addCell(label5);
                } catch (WriteException ex) {
                    Logger.getLogger(SalvaExcel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        
            /*
            Sheet sheet = workbook.createSheet();
            Row row = sheet.createRow((short)2);
            row.createCell(0).setCellValue(1.1);
            row.createCell(1).setCellValue(new Date());
            row.createCell(2).setCellValue(Calendar.getInstance());
            row.createCell(3).setCellValue("a string");
            row.createCell(4).setCellValue(true);
            row.createCell(5).setCellType(HSSFCell.CELL_TYPE_ERROR);
            row.createCell(6).setCellValue(new Date());
            // Scriviamo il file
            FileOutputStream fileOut = new FileOutputStream("read-test.xls");
            wb.write(fileOut);
            fileOut.close();
            */
        

        try {
            writableWorkbook.write();
        } catch (IOException ex) {
            Logger.getLogger(SalvaExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writableWorkbook.close();
        } catch (IOException ex) {
            Logger.getLogger(SalvaExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(SalvaExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
