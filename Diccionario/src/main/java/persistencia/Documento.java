package persistencia;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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

    public Map leer() {
        FileReader fr = null;
        BufferedReader br = null;
        String[] text={};
        Map<String, String> dic = new HashMap<>();

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String cont;

            while ((cont = br.readLine()) != null) {
                text = cont.split(",");
                System.out.println("text = " + text[0] + " "+text[1]);
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

        System.out.println("dic = " + dic.values());

        return dic;
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
