package es.cipfpbatoi.damb.ad.procesador.rutas;

import es.cipfpbatoi.damb.ad.procesador.rutas.utilidades.ConstruirListado;
import es.cipfpbatoi.damb.ad.procesador.rutas.utilidades.EsDirectorio;

import java.io.File;

public class Constructo {
    public static String files(String valorem){
        String resultado = ConstruirListado.lista(valorem);
        return resultado;
    }
}
