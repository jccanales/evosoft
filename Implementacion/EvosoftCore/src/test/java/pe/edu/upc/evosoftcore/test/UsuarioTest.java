/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.evosoftcore.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.edu.upc.evosoftcore.core.service.UsuarioService;
import pe.edu.upc.evosoftcore.domain.Usuario;

/**
 *
 * @author Jean Carlo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/java//pe/edu/upc/evosoftcore/configuration/SpringContext.xml"})
public class UsuarioTest {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Test
    public void Insertar(){
        try{
            Usuario u = new Usuario();
            u.setNombreUsuario("usuarioSpring");
            u.setClave("framework");
            usuarioService.getRepository().save(u);
            System.out.println("Cantidad de usuarios: " + usuarioService.getRepository().metodoPersonalizado());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
