package diccionario;

import persistencia.Documento;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Diccionario {

    Logger logger = Logger.getLogger("MyLogger");
    private Map<String, String> dic;

    public Diccionario() {
      Documento documento = new Documento();
      this.dic = documento.leer();
    }

    public void agregar(String key, String val){
        this.dic.put(key, val);

    }

    public Map<String, String> getDic() {
        return dic;
    }

    public String buscar(String key){
        return this.dic.getOrDefault(key, "No se encontro");
    }

    public void guardarCambios(Map dic){
        Documento documento = new Documento();
        documento.guardar(dic);
    }
}
