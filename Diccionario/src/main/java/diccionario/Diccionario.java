package diccionario;

import java.util.HashMap;
import java.util.Map;

public class Diccionario {

    static private Map<String, String> dic;

    public Diccionario() {
        this.dic = new HashMap<>();
        this.dic.put("hello", "hola");
        this.dic.put("hell", "ola");
        this.dic.put("helo", "hoa");
        this.dic.put("ana", "ene");
        this.dic.put("trece", "doce");
    }

    public void crear(){

        for(String nn: this.dic.keySet()){
            System.out.println(nn);
        }
        for(String nn: this.dic.values()){
            System.out.println(nn);
        }

        //System.out.println(dic.keySet());
    }

}
