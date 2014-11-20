/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.evosoftcore.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.evosoftcore.core.service.UsuarioService;
import pe.edu.upc.evosoftcore.repository.UsuarioRepository;

/**
 *
 * @author Jean Carlo
 */
@Component("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Transactional
    public void delete(Integer id) {
        this.usuarioRepository.delete(id);
    }

    @Override
    public UsuarioRepository getRepository() {
        return usuarioRepository;
    }
    
}
