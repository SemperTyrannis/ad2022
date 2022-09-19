package es.cipfpbatoi.damb.ad.procesador.rutas.utilidades;

import es.cipfpbatoi.damb.ad.procesador.rutas.ConfiguracionBusqueda;

import java.io.File;
import java.io.FileFilter;

public class BusquedaPorDirectorios {
    private ConfiguracionBusqueda configuracionBusqueda;

    private StringBuilder st = new StringBuilder();

    public BusquedaPorDirectorios(ConfiguracionBusqueda configuracionBusqueda) {
        this.configuracionBusqueda = configuracionBusqueda;
    }

    private FileFilter fileFilter = new FileFilter() {
        @Override
        public boolean accept(File pathname) {

            Boolean test = pathname.isHidden();

            if (pathname.isDirectory()){
                if (test) {
                    if (test.equals(configuracionBusqueda.isMostrarArchivosOcultos())) {
                        if (!configuracionBusqueda.getFiltroNombre().isEmpty() || configuracionBusqueda.getFiltroNombre() != "") {
                            if (contienePalabra(pathname)) {
                                st.append("Ruta:" + pathname.getPath() + "\n");
                                st.append("----->"+"\n");
                                DirectorioToString(pathname);
                            }
                        }else{
                            st.append(pathname.getPath() + "\n");
                            st.append("----->"+"\n");
                            DirectorioToString(pathname);
                        }
                    }
                    return false;
                }

                if (!configuracionBusqueda.getFiltroNombre().isEmpty() || configuracionBusqueda.getFiltroNombre() != ""){
                    if (contienePalabra(pathname)){
                        st.append(pathname.getPath() + "\n");
                        st.append("----->"+"\n");
                        DirectorioToString(pathname);
                    }
                }

                st.append(pathname.getPath() + "\n");
                st.append("----->"+"\n");
                DirectorioToString(pathname);
            }

            if (pathname.isHidden() && !pathname.isDirectory()){
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

            if (!configuracionBusqueda.getFiltroNombre().isEmpty() && !pathname.isDirectory()|| configuracionBusqueda.getFiltroNombre() != "" && !pathname.isDirectory()){
                return contienePalabra(pathname);
            }

            if (!pathname.isDirectory()){
                return true;
            }
            return false;
        }
    };

    public String DirectorioToString(File fichero){
        File [] files = fichero.listFiles(fileFilter);
        for (File file:files) {
            st.append("Archivo: " + file.getName() + "\n" + "Ruta: " + file.getPath() + "\n");

        }
        st.append("<-----"+"\n");
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
