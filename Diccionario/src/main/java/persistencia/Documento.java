package persistencia;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Clase usada para crear el documento si no existe, leerlo o escribir en el.
 * En este caso se usa un archivo de tipo "txt"
 */
public class Documento {

    //Si quieren usar una ruta completa puede ser asi en windows
    //private File archivo = new File("D:\\Codigo\\Intellij\\Diccionario\\diccionario.txt");

    private File archivo = new File("diccionario.txt");

    private BufferedReader br = null;
    private FileReader fr = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;

    /**
     * Constructor, al usarlo verifica la existencia del documento, sino lo crea
     */
    public Documento() {
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo para leer el documento y retornar un objeto de tipo map
     * @return Map
     */
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


    /**
     * Este metodo recibe un Map y lo guarda en lineas de "key,value" en el documento,
     * cada linea es una pareja de clave valor
     * @param dic
     */
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
