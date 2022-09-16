package es.cipfpbatoi.damb.ad.procesador.rutas.utilidades;

import java.io.File;

public class ConstruirInfoFichero {
    public static String info (String ruta){
        File file = new File(ruta);
        if (file.isDirectory()){
            return "No se puede aportar información de un directorio";
        }else {
            StringBuilder st = new StringBuilder();
            boolean ejecutar = file.canExecute();
            st.append("Ejecución:" + ejecutar + "\n");
            boolean lectura = file.canRead();
            st.append("Lectura:" + lectura+ "\n");
            boolean escritura = file.canWrite();
            st.append("Escritura: " + escritura + "\n");
            return st.toString();
        }
    }
}
