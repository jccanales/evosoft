/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.upc.evosoftcore.domain.Chofer;
import pe.edu.upc.evosoftcore.repository.custom.ChoferRepositoryCustom;

/**
 *
 * @author Jean Carlo
 */
public interface ChoferRepository extends CrudRepository<Chofer, Integer>, ChoferRepositoryCustom {
}
