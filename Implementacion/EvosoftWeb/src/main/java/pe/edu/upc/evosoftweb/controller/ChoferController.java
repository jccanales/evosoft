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
    
    public String irActualizar(){
        String rpta="";
        if(this.choferSeleccionado != null && this.choferSeleccionado.getIdChofer() > 0){
            this.listaChoferes.clear();
            this.filtro = "";
            this.choferGuardar = new Chofer ();
            this.choferGuardar.setIdChofer(this.choferSeleccionado.getIdChofer());
            this.choferGuardar.setNombre(this.choferSeleccionado.getNombre());
            this.choferGuardar.setApellido(this.choferSeleccionado.getApellido());
            this.choferGuardar.setTelefono(this.choferSeleccionado.getTelefono());
            this.choferGuardar.setIdLicencia(this.choferSeleccionado.getIdLicencia());
            rpta = "actualizarChofer";
        }else{
            UtilWeb.mensajeAdvertencia(MENSAJE_NOSELECCIONADO, MENSAJE_NOSELECCIONADO);
        }
        return rpta;
    }

    public Chofer getChoferGuardar() {
        return choferGuardar;
    }

    public void setChoferGuardar(Chofer choferGuardar) {
        this.choferGuardar = choferGuardar;
    }

    public Chofer getChoferSeleccionado() {
        return choferSeleccionado;
    }

    public void setChoferSeleccionado(Chofer choferSeleccionado) {
        this.choferSeleccionado = choferSeleccionado;
    }

    public String getIniciarMntChofer() {
        this.limpiarMntChofer();
        return iniciarMntChofer;
    }

    public void setIniciarMntChofer(String iniciarMntChofer) {
        this.iniciarMntChofer = iniciarMntChofer;
    }

    public String getIniciarRegChofer() {
        this.limpiarRegChofer();
        return iniciarRegChofer;
    }

    public void setIniciarRegChofer(String iniciarRegChofer) {
        this.iniciarRegChofer = iniciarRegChofer;
    }

    public String getIniciarActChofer() {
        this.limpiarActChofer();
        return iniciarActChofer;
    }

    public void setIniciarActChofer(String iniciarActChofer) {
        this.iniciarActChofer = iniciarActChofer;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public int getIdLicenciaSeleccionada() {
        return idLicenciaSeleccionada;
    }

    public void setIdLicenciaSeleccionada(int idLicenciaSeleccionada) {
        this.idLicenciaSeleccionada = idLicenciaSeleccionada;
    }

    public List<SelectItem> getListaLicencias() {
        return listaLicencias;
    }

    public void setListaLicencias(List<SelectItem> listaLicencias) {
        this.listaLicencias = listaLicencias;
    }

    public List<Chofer> getListaChoferes() {
        return listaChoferes;
    }

    public void setListaChoferes(List<Chofer> listaChoferes) {
        this.listaChoferes = listaChoferes;
    }
    
}
