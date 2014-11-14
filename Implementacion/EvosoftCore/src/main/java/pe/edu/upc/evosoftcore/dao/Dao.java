/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.dao;

import java.util.List;

/**
 *
 * @author Jean Carlo
 * @param <E> Entidad
 */
public interface Dao<E> {

    public void insert(E e);

    public E findById(int id);

    public List<E> listar();

    public void update(E e);

    public void delete(E e);

}
