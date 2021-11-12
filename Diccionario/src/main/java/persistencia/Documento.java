package persistencia;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Documento {

    private File archivo = new File("diccionario.txt");

    private BufferedReader br = null;
    private FileReader fr = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;

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

        String[] text = {};
        Map<String, String> dic = new HashMap<>();

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String cont;

            while ((cont = br.readLine()) != null) {
                text = cont.split(",");
                dic.put(text[0], text[1]);
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


        return dic;
    }

    public void guardar(Map dic) {

        Set line = dic.keySet();


        try {
            fw = new FileWriter(archivo);
            bw = new BufferedWriter(fw);
            dic.forEach((k, v) -> {
                String auxString = k + "," + v + "\n";
                try {
                    bw.write(auxString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

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
    }
}
