/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.evosoftcore.core.service.VehiculoService;
import pe.edu.upc.evosoftcore.repository.VehiculoRepository;

/**
 *
 * @author Jean Carlo
 */
@Component("vehiculoService")
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Transactional
    public void delete(Integer id) {
        this.vehiculoRepository.delete(id);
    }

    @Override
    public VehiculoRepository getRepository() {
        return vehiculoRepository;
    }

}
