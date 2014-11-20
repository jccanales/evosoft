/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.core.service;

import pe.edu.upc.evosoftcore.core.service.base.BaseService;
import pe.edu.upc.evosoftcore.repository.VehiculoRepository;

/**
 *
 * @author Jean Carlo
 */
public interface VehiculoService extends BaseService<VehiculoRepository> {

    void delete(Integer id);

}
