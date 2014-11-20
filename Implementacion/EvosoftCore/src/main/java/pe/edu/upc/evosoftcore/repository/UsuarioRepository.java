/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.evosoftcore.repository;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import pe.edu.upc.evosoftcore.domain.Usuario;
import pe.edu.upc.evosoftcore.repository.custom.UsuarioRepositoryCustom;

/**
 *
 * @author Jean Carlo
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>, UsuarioRepositoryCustom{
    
}
