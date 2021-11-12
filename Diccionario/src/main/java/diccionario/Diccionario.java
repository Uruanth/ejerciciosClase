package diccionario;

import persistencia.Documento;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase para manipular el objeto de map que se crea al leer el archivo txt
 */
public class Diccionario {

    Logger logger = Logger.getLogger("MyLogger");
    private Map<String, String> dic;

    /**
     * Constructor para inicializar el atributo map con los datos del archivo
     */
    public Diccionario() throws IOException {
      Documento documento = new Documento();
      this.dic = documento.leer();
    }

    /**
     * Metodo para agregar entradas al objeto map
     * Aun no guarda en el archivo
     * @param key
     * @param val
     */
    public void agregar(String key, String val){
        this.dic.put(key, val);

    }

    /**
     * Obtener todo el objeto diccionario
     * @return Map
     */
    public Map<String, String> getDic() {
        return dic;
    }

    /**
     * Busca una llave especifica en el objeto, sino la encuentra devuelve un valor por default
     * @param key<String>
     * @return String
     */
    public String buscar(String key){
        return this.dic.getOrDefault(key, "No se encontro");
    }

    /**
     * Guarda todos los cambios en el objeto Map en el archivo
     * @param dic<Map>
     */
    public void guardarCambios(Map dic) throws IOException {
        Documento documento = new Documento();
        documento.guardar(dic);
    }
}
