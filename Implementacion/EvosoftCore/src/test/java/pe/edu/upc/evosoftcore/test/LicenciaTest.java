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
import pe.edu.upc.evosoftcore.core.service.LicenciaService;
import pe.edu.upc.evosoftcore.domain.Licencia;

/**
 *
 * @author Diego
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/java//pe/edu/upc/evosoftcore/configuration/SpringContext.xml"})

public class LicenciaTest {

    @Autowired
    private LicenciaService licenciaService;

    @Test
    public void Insertar() {
        try {
            Licencia l = licenciaService.getRepository().findOne(2);
            l.setCategoria("IIA");
            l.setFechaVencimiento(null);
            l.setNumero(12);
            
            licenciaService.getRepository().save(l);
            System.out.println("Cantidad de licencias" + licenciaService.getRepository().metodoPersonalizado());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
