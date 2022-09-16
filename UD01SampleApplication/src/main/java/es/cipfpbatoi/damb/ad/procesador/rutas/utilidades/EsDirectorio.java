package es.cipfpbatoi.damb.ad.procesador.rutas.utilidades;

import java.io.File;

public class EsDirectorio {
    public static Boolean comprobar(String ruta){
        File file = new File(ruta);
        return file.isDirectory();
    }
}
