package persistencia;

import java.io.*;

public class Documento {

    private File archivo = new File("D:\\Codigo\\Intellij\\Diccionario\\diccionario.txt");

    public Documento() {
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String leer() {
        FileReader fr = null;
        BufferedReader br = null;
        String text = "";
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String cont;

            while ((cont = br.readLine()) != null) {
                text += cont;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }


        return text;
    }

    public boolean guardar() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo);
            bw = new BufferedWriter(fw);
            bw.write("escribiendo algo");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }


        }


        return false;
    }


}
