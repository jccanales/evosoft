/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.dao;

import java.util.List;
import pe.edu.upc.evosoftcore.entity.Vehiculo;

/**
 *
 * @author Diego
 */
public interface VehiculoDAO {

    public void insert(Vehiculo vehiculo);
    public Vehiculo findById(int id);
    public List<Vehiculo> listar();
    public void update(Vehiculo vehiculo);
    public void delete(Vehiculo vehiculo);
    
}
