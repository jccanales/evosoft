/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.upc.evosoftcore.domain.Vehiculo;
import pe.edu.upc.evosoftcore.repository.custom.VehiculoRepositoryCustom;

/**
 *
 * @author Jean Carlo
 */
public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer>, VehiculoRepositoryCustom {

}
