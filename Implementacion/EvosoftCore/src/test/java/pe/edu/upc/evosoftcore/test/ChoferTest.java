/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.test;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pe.edu.upc.evosoftcore.dao.ChoferDAO;
import pe.edu.upc.evosoftcore.entity.Chofer;
import pe.edu.upc.evosoftcore.entity.Licencia;

/**
 *
 * @author Jean Carlo
 */
public class ChoferTest {

    private Chofer chofer;
    private Licencia licencia;
    private ApplicationContext context;
    private ChoferDAO choferDAO;

    public ChoferTest() {

        context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        choferDAO = (ChoferDAO) context.getBean("ChoferDAO");

        chofer = new Chofer();
        chofer.setNombre("Marco");
        chofer.setApellido("Polo");
        chofer.setTelefono(1234567);

        licencia = new Licencia();
        licencia.setIdLicencia(1);
        chofer.setLicencia(licencia);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test(priority = 1)
    public void InsertarTest() {
        System.out.println("======INSERTARTEST======");
        choferDAO.insert(chofer);
        System.out.println("Inserte: " + chofer.toString());
        ListarChofer();

    }

    @Test(priority = 2)
    public void UpdateTest() {
        System.out.println("======UPDATETEST======");
        chofer.setNombre("marco update");
        chofer.setApellido("apapapapaptest");
        chofer.setTelefono(9874563);
        choferDAO.update(chofer);
        ListarChofer();
    }
    
    @Test(priority = 3)
    public void DeleteTest(){
        System.out.println("======DELETETEST======");
        choferDAO.delete(chofer);
        ListarChofer();
    }

    public void ListarChofer() {
        List<Chofer> choferes = choferDAO.listar();
        for (Chofer c : choferes) {
            System.out.println(c.toString());
        }
    }
}
