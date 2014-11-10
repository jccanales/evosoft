/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.test;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.edu.upc.evosoftcore.dao.ChoferDAO;
import pe.edu.upc.evosoftcore.entity.Chofer;
import pe.edu.upc.evosoftcore.entity.Licencia;

/**
 *
 * @author Jean Carlo
 */
public class ChoferJUnitTest {

    public ChoferJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void InsertarTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        ChoferDAO choferDAO = (ChoferDAO) context.getBean("ChoferDAO");

        Chofer chofer = new Chofer();
        chofer.setNombre("Marco");
        chofer.setApellido("Polo");
        chofer.setTelefono(1234567);
        Licencia licencia = new Licencia();
        licencia.setIdLicencia(1);
        chofer.setLicencia(licencia);

        choferDAO.insert(chofer);

        List<Chofer> choferes = choferDAO.listChofer();
        for (Chofer c : choferes) {
            System.out.println(c.toString());
        }

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
