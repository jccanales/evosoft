/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.evosoftcore.repository.LicenciaRepository;
import pe.edu.upc.evosoftcore.core.service.LicenciaService;

/**
 *
 * @author Jean Carlo
 */
@Component("licenciaService")
public class LicenciaServiceImpl implements LicenciaService {

    @Autowired
    private LicenciaRepository licenciaRepository;

    @Transactional
    public void delete(Integer id) {
        this.licenciaRepository.delete(id);
    }

    @Override
    public LicenciaRepository getRepository() {
        return licenciaRepository;
    }

}