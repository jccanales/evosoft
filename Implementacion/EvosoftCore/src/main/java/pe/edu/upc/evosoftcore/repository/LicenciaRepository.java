/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.upc.evosoftcore.domain.Licencia;
import pe.edu.upc.evosoftcore.repository.custom.LicenciaRepositoryCustom;

/**
 *
 * @author Jean Carlo
 */
public interface LicenciaRepository extends CrudRepository<Licencia, Integer>, LicenciaRepositoryCustom {

}
