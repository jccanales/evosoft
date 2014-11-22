
package pe.edu.upc.evosoftweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import pe.edu.upc.evosoftweb.util.UtilWeb;
import pe.edu.upc.evosoftcore.entity.Chofer;
import pe.edu.upc.evosoftcore.entity.Licencia;
import pe.edu.upc.evosoftcore.entity.Vehiculo;
/**
 *
 * @author Richard
 */

@ManagedBean
@SessionScoped
public class ChoferController {

    private Chofer choferGuardar = new Chofer();
    private Chofer choferSeleccionado = new Chofer();
    private String iniciarMntChofer;
    private String iniciarRegChofer;
    private String iniciarActChofer;
    private String filtro = "";
    private int idVehiculoSeleccionada;
    private List<SelectItem> listaVehiculos = new ArrayList<SelectItem>();
    private List<Chofer> listaChoferes = new ArrayList<Chofer>();
    //private final ChoferBusiness choferBusiness = new ChoferBusiness();
    //private final VehiculoBusiness vehiculoBusiness = new VehiculoBusiness();
    private final static String MENSAJE_INSERTAR = "Se inserto correctamente el Chofer";
    private final static String MENSAJE_ACTUALIZAR = "Se actualizo correctamente el Chofer";
    private final static String MENSAJE_ELIMINAR = "Se elimino correctamente el Chofer";
    private final static String MENSAJE_NOSELECCIONADO = "No ha seleccionado un Chofer";
    private final static String MENSAJE_ERROR = "Ocurrio un error: ";

    public void insertar(){
        try {
            
             
        } catch (Exception e) {
        }
    }
    
}
