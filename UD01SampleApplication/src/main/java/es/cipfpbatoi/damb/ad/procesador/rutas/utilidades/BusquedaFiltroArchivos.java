package es.cipfpbatoi.damb.ad.procesador.rutas.utilidades;

import es.cipfpbatoi.damb.ad.procesador.rutas.ConfiguracionBusqueda;

import java.io.File;
import java.io.FileFilter;

public class BusquedaFiltroArchivos {
    private ConfiguracionBusqueda configuracionBusqueda;
    private StringBuilder st = new StringBuilder();

    public BusquedaFiltroArchivos(ConfiguracionBusqueda configuracionBusqueda) {
        this.configuracionBusqueda = configuracionBusqueda;
    }

    private FileFilter fileFilter = new FileFilter() {
        @Override
        public boolean accept(File pathname) {

            Boolean test = pathname.isHidden();

            if (pathname.isDirectory()){
                return false;
            }

            if (pathname.isHidden()){
                if (test.equals(configuracionBusqueda.isMostrarArchivosOcultos())){
                    if (!configuracionBusqueda.getFiltroNombre().isEmpty() || configuracionBusqueda.getFiltroNombre() != ""){
                        return contienePalabra(pathname);
                    }else{
                        return true;
                    }
                }else{
                    return false;
                }
            }

            if (!configuracionBusqueda.getFiltroNombre().isEmpty() || configuracionBusqueda.getFiltroNombre() != ""){
                return contienePalabra(pathname);
            }

            return true;
        }
    };

    public File[] files(){
        File fichero = new File(configuracionBusqueda.getRutaInicial());
        File [] files = fichero.listFiles(fileFilter);
        return files;
    }

    public String ArchivoToString(){
        File [] files = files();
        for (File file:files) {
            st.append(file.getName() + "\n");
        }
        return st.toString();
    }

    private Boolean contienePalabra(File file){
        if (file.getName().contains(configuracionBusqueda.getFiltroNombre())){
            return true;
        }else {
            return false;
        }
    }
}
