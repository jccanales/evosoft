/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.evosoftcore.repository.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import pe.edu.upc.evosoftcore.repository.custom.VehiculoRepositoryCustom;

/**
 *
 * @author Jean Carlo
 */
public class VehiculoRepositoryImpl implements VehiculoRepositoryCustom {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
    public int metodoPersonalizado() {
        return jdbcTemplate.queryForInt("SELECT COUNT(1) from Vehiculo");
    }

}
