package es.cipfpbatoi.damb.ad.procesador.rutas.Outdated;

import es.cipfpbatoi.damb.ad.procesador.rutas.utilidades.ConstruirInfoFichero;
import es.cipfpbatoi.damb.ad.procesador.rutas.utilidades.EsDirectorio;

import java.io.File;

public class ConstruirListado {
    public static String listaRecursiva(String ruta){
        StringBuilder st = new StringBuilder();
        String completar = "";
        File file = new File(ruta);
        String[] files = file.list();
        for (String file2:files) {
            String rutaComp = ruta + "\\"+file2;
            if (EsDirectorio.comprobar(rutaComp)){
                completar = listaRecursiva(rutaComp);
                st.append("----->"+"\n");
                st.append("Ruta: " + rutaComp + ": "+"\n"+completar+"\n");
                st.append("<-----"+"\n");
            }else{
                st.append("<---------->"+"\n");
                st.append("Nombre Archivo: "+file2+"\n");
                st.append("--Info Archivo--"+"\n");
                st.append(ConstruirInfoFichero.info(rutaComp));
                st.append("<---------->"+"\n");
            }
        }
        String resultado = st.toString();
        return resultado;
    }

    public static String lista(String ruta){
        StringBuilder st = new StringBuilder();
        String completar = "";
        File file = new File(ruta);
        String[] files = file.list();
        for (String file2:files) {
            String rutaComp = ruta + "\\"+file2;
            if (EsDirectorio.comprobar(rutaComp)){
                st.append("----->"+"\n");
                st.append(file2);
                st.append(" Es un directorio"+"\n");
                st.append("<-----"+"\n");
            }else{
                st.append("<---------->"+"\n");
                st.append("Nombre Archivo: "+file2+"\n");
                st.append("--Info Archivo--"+"\n");
                st.append(ConstruirInfoFichero.info(rutaComp));
                st.append("<---------->"+"\n");
            }
        }
        String resultado = st.toString();
        return resultado;
    }
}
