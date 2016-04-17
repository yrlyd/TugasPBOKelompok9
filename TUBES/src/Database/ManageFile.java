/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author FebbyFebriansyah
 */
public class ManageFile {
    
    public void saveObject(Object o, String namaFile) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(namaFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(o);
        oos.flush();
        oos.close();
    }
    public Object getObject(String namaFile) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(namaFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return ois.readObject();
    }
}
