/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.evosoftcore.dao;

import java.util.List;
import pe.edu.upc.evosoftcore.entity.Chofer;

/**
 *
 * @author Jean Carlo
 */
public interface ChoferDAO {
    
    public void insert(Chofer chofer);
    public Chofer findByChoferId(int choferId);
    public List<Chofer> listChofer();
    public void update(Chofer choferUpdate);
    
}
