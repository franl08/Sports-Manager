package Model;

import java.io.*;

public class RWfiles {
    public void saveObject(String objectPath) throws IOException{
        FileOutputStream fos = new FileOutputStream(objectPath);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public Model readObject (String filename) throws IOException, ClassNotFoundException{
        ObjectInputStream file = new ObjectInputStream((new FileInputStream(filename)));
        Model t = (Model) file.readObject();
        file.close();
        return t;
    }
}
