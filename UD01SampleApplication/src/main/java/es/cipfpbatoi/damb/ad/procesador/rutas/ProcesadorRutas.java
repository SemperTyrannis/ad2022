package es.cipfpbatoi.damb.ad.procesador.rutas;

import es.cipfpbatoi.damb.ad.procesador.rutas.utilidades.BusquedaFiltroArchivos;
import es.cipfpbatoi.damb.ad.procesador.rutas.utilidades.BusquedaPorDirectorios;
import es.cipfpbatoi.damb.ad.procesador.rutas.utilidades.DeterMinarBusqueda;

import java.io.File;

public class ProcesadorRutas {
	
	public static StringBuilder procesarRuta(ConfiguracionBusqueda configuracionBusqueda) {
		
		StringBuilder resultadoProceso = new StringBuilder();
		resultadoProceso.append("Vamos a buscar en la ruta: " + configuracionBusqueda.getRutaInicial() + "\n");
		resultadoProceso.append("Procesando directorio...\n");
		DeterMinarBusqueda deterMinarBusqueda = new DeterMinarBusqueda(configuracionBusqueda);
		resultadoProceso.append(deterMinarBusqueda.tipoBusqueda());
		return resultadoProceso;
	}

}
