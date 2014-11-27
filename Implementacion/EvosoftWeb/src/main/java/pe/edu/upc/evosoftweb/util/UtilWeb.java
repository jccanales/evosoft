
package pe.edu.upc.evosoftweb.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Richard
 */
public final class UtilWeb {
    
    private UtilWeb(){
        
    }
    
    public static void mensajeError(String codigo, String mensaje){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, codigo, mensaje));
    }

    public static void mensajeInformacion(String codigo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, codigo, mensaje));
    }
    
    public static void mensajeAdvertencia(String codigo, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, codigo, mensaje));
    }
}
