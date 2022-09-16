package es.cipfpbatoi.damb.ad.procesador.rutas.utilidades;

import java.io.File;

public class ConstruirListado {
    public static String lista(String ruta){
        StringBuilder st = new StringBuilder();
        String completar = "";
        File file = new File(ruta);
        String[] files = file.list();
        for (String file2:files) {
            String rutaComp = ruta + "\\"+file2;
            if (EsDirectorio.comprobar(rutaComp)){
                completar = lista(rutaComp);
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
}
