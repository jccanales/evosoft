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
import pe.edu.upc.evosoftcore.core.service.ChoferService;
import pe.edu.upc.evosoftcore.core.service.VehiculoService;
import pe.edu.upc.evosoftcore.domain.Chofer;
import pe.edu.upc.evosoftcore.domain.Vehiculo;

/**
 *
 * @author Jean Carlo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/java//pe/edu/upc/evosoftcore/configuration/SpringContext.xml"})

public class VehiculoTest {

    @Autowired
    private VehiculoService vehiculoService;
    @Autowired
    private ChoferService choferService;

    @Test
    public void Insertar() {
        try {
            Chofer c = choferService.getRepository().findOne(3);
            Vehiculo v = new Vehiculo();
            v.setAnio("2015");
            v.setCantidadEjes(5);
            v.setEstado("Spring");
            v.setModelo("MBW");
            v.setPlaca("ABC123");
            v.setChofer(c);
            vehiculoService.getRepository().save(v);
            System.out.println("Cantidad de vehiculos: " + vehiculoService.getRepository().metodoPersonalizado());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
