package pe.edu.upc.evosoftweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import pe.edu.upc.evosoftcore.core.service.ChoferService;
import pe.edu.upc.evosoftcore.core.service.LicenciaService;

import pe.edu.upc.evosoftweb.util.UtilWeb;
import pe.edu.upc.evosoftcore.domain.Chofer;
import pe.edu.upc.evosoftcore.domain.Licencia;

/**
 *
 * @author Richard
 */
@ManagedBean
@SessionScoped
@ContextConfiguration(locations = {"file:src/main/java//pe/edu/upc/evosoftcore/configuration/SpringContext.xml"})
public class ChoferController {

    private Chofer choferGuardar = new Chofer();
    private Chofer choferSeleccionado = new Chofer();
    private String iniciarMntChofer;
    private String iniciarRegChofer;
    private String iniciarActChofer;
    private String filtro = "";
    private int idLicenciaSeleccionada;
    private List<SelectItem> listaLicencias = new ArrayList<SelectItem>();
    private List<Chofer> listaChoferes = new ArrayList<Chofer>();

    @Autowired
    private ChoferService choferService;
    @Autowired
    private LicenciaService licenciaService;

    private final static String MENSAJE_INSERTAR = "Se inserto correctamente el Chofer";
    private final static String MENSAJE_ACTUALIZAR = "Se actualizo correctamente el Chofer";
    private final static String MENSAJE_ELIMINAR = "Se elimino correctamente el Chofer";
    private final static String MENSAJE_NOSELECCIONADO = "No ha seleccionado un Chofer";
    private final static String MENSAJE_ERROR = "Ocurrio un error: ";

    public void insertar() {
        try {
            Licencia l = licenciaService.getRepository().findOne(idLicenciaSeleccionada);
            this.choferGuardar.setIdLicencia(l);
            choferService.getRepository().save(choferGuardar);
            UtilWeb.mensajeInformacion(MENSAJE_INSERTAR, MENSAJE_INSERTAR);
        } catch (Exception e) {
            e.printStackTrace();
            UtilWeb.mensajeError(MENSAJE_ERROR + e.getMessage(), MENSAJE_ERROR + e.getMessage());
        }
    }

    public void actualizar() {
        try {
            Licencia l = licenciaService.getRepository().findOne(idLicenciaSeleccionada);
            this.choferGuardar.setIdLicencia(l);
            choferService.getRepository().save(choferGuardar);
            UtilWeb.mensajeInformacion(MENSAJE_ACTUALIZAR, MENSAJE_ACTUALIZAR);
        } catch (Exception e) {
            e.printStackTrace();
            UtilWeb.mensajeError(MENSAJE_ERROR + e.getMessage(), MENSAJE_ERROR + e.getMessage());
        }
    }

    public void eliminar() {
        try {
            if (this.choferSeleccionado != null) {
                this.choferService.getRepository().delete(this.choferSeleccionado);
                this.limpiarMntChofer();
                this.buscar();
                UtilWeb.mensajeInformacion(MENSAJE_ELIMINAR, MENSAJE_ELIMINAR);
            } else {
                UtilWeb.mensajeAdvertencia(MENSAJE_NOSELECCIONADO, MENSAJE_NOSELECCIONADO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            UtilWeb.mensajeError(MENSAJE_ERROR + e.getMessage(), MENSAJE_ERROR + e.getMessage());
        }
    }

    public void buscar() {
        try {
            this.listaChoferes.clear();
            //this.listaChoferes = this.choferService.getRepository().findAll();
            //Como ultimo caso usar el for
            for (int i = 0; i < this.choferService.getRepository().count(); i++) {
                this.listaChoferes.add(this.choferService.getRepository().findOne(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            UtilWeb.mensajeError(MENSAJE_ERROR + e.getMessage(), MENSAJE_ERROR + e.getMessage());
        }
    }

    private void listarLicencias() {
        try {
            List<Licencia> licencias = new ArrayList<Licencia>();
            licencias.clear();
            //licencias= this.licenciaService.getRepository().findAll();
            for (int i = 0; i < this.licenciaService.getRepository().count(); i++) {
                licencias.add(this.licenciaService.getRepository().findOne(i));
            }
            this.listaLicencias.clear();

            for (Licencia l : licencias) {
                this.listaLicencias.add(new SelectItem(l.getIdLicencia(), l.getNumero().toString()));
            }
            if (licencias != null && licencias.size() > 0) {
                this.idLicenciaSeleccionada = licencias.get(0).getIdLicencia();
            }
        } catch (Exception e) {
            e.printStackTrace();
            UtilWeb.mensajeError(MENSAJE_ERROR + e.getMessage(), MENSAJE_ERROR + e.getMessage());
        }
    }

    private void limpiarMntChofer() {
        try {
             this.choferGuardar = new Chofer();
             this.choferSeleccionado = new Chofer();
        } catch (Exception e) {
            e.printStackTrace();
            UtilWeb.mensajeError(MENSAJE_ERROR + e.getMessage(), MENSAJE_ERROR + e.getMessage());
        }
    }
    
    private void limpiarRegChofer() {
        try {
            this.choferGuardar = new Chofer();
            this.choferSeleccionado = new Chofer();
            this.listarLicencias();
        } catch (Exception e) {
            e.printStackTrace();
            UtilWeb.mensajeError(MENSAJE_ERROR + e.getMessage(), MENSAJE_ERROR + e.getMessage());
        }   
    }
    
    private void limpiarActChofer(){
        try {
            this.choferSeleccionado = new Chofer();
            this.listarLicencias();
            this.idLicenciaSeleccionada = this.choferGuardar.getIdLicencia().getIdLicencia();
        } catch (Exception e) {
            e.printStackTrace();
            UtilWeb.mensajeError(MENSAJE_ERROR + e.getMessage(), MENSAJE_ERROR + e.getMessage());
        }
    }
    
    public String irMantenimiento(){
        this.listaChoferes.clear();
        this.filtro = "";
        return "mntChofer";
    }
    
    public String irNuevo(){
        this.listaChoferes.clear();
        this.filtro = "";
        return "registrarChofer";
    }
}
