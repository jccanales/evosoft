package pe.edu.upc.evosoftcore.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.evosoftcore.repository.ChoferRepository;
import pe.edu.upc.evosoftcore.core.service.ChoferService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jean Carlo
 */
@Component("choferService")
public class ChoferServiceImpl implements ChoferService {

    @Autowired
    private ChoferRepository choferRepository;

    @Transactional
    public void delete(Integer id) {
        this.choferRepository.delete(id);
    }

    @Override
    public ChoferRepository getRepository() {
        return choferRepository;
    }

}