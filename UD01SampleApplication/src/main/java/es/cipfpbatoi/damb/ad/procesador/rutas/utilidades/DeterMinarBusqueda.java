package es.cipfpbatoi.damb.ad.procesador.rutas.utilidades;

import es.cipfpbatoi.damb.ad.procesador.rutas.ConfiguracionBusqueda;

import java.io.File;

public class DeterMinarBusqueda {

    private ConfiguracionBusqueda configuracionBusqueda;
    private BusquedaPorDirectorios busquedaPorDirectorios;
    private BusquedaFiltroArchivos busquedaFiltroArchivos;

    public DeterMinarBusqueda(ConfiguracionBusqueda configuracionBusqueda) {
        this.configuracionBusqueda = configuracionBusqueda;
        this.busquedaPorDirectorios = new BusquedaPorDirectorios(configuracionBusqueda);
        this.busquedaFiltroArchivos = new BusquedaFiltroArchivos(configuracionBusqueda);
    }

    public String tipoBusqueda() {
        File file = new File(configuracionBusqueda.getRutaInicial());
        if (configuracionBusqueda.isBuscarRecursivamente()){
            return busquedaPorDirectorios.DirectorioToString(file);
        }else{
            return busquedaFiltroArchivos.ArchivoToString();
        }
    }
}
