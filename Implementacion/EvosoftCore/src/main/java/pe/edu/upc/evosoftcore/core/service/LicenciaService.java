/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.core.service;

import pe.edu.upc.evosoftcore.repository.LicenciaRepository;
import pe.edu.upc.evosoftcore.core.service.base.BaseService;

/**
 *
 * @author Jean Carlo
 */
public interface LicenciaService extends BaseService<LicenciaRepository> {

    void delete(Integer id);

}
