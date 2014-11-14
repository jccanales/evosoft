/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.dao;

import java.util.List;
import pe.edu.upc.evosoftcore.entity.Licencia;

/**
 *
 * @author Diego
 */

public interface LicenciaDAO {

    public void insert(Licencia licencia);
    public Licencia findById(int id);
    public List<Licencia> listar();
    public void update(Licencia licencia);
    public void delete(Licencia licencia);
    
}
