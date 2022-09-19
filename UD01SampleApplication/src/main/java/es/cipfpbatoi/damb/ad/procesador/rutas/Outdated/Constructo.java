package es.cipfpbatoi.damb.ad.procesador.rutas.Outdated;

public class Constructo {
    public static String filesRecursivo(String valorem){
        String resultado = ConstruirListado.listaRecursiva(valorem);
        return resultado;
    }
    public static String filesNoRecursivo(String valorem){
        String resultado = ConstruirListado.lista(valorem);
        return resultado;
    }
}
