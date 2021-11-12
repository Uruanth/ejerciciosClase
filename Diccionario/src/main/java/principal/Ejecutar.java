package principal;

import persistencia.Documento;

public class Ejecutar {

    public static void main(String[] args) {

        Documento dc = new Documento();
        try {
            System.out.println(dc.leer());
            //dc.guardar();
        }catch (Exception e){
            e.printStackTrace();

        }



    }

}
