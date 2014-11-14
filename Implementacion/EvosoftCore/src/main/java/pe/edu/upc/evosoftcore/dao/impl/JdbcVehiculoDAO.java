/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.evosoftcore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import pe.edu.upc.evosoftcore.dao.VehiculoDAO;
import pe.edu.upc.evosoftcore.entity.Chofer;
import pe.edu.upc.evosoftcore.entity.Licencia;
import pe.edu.upc.evosoftcore.entity.Vehiculo;

/**
 *
 * @author Diego
 */

public class JdbcVehiculoDAO implements VehiculoDAO {
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    @Override
    public void insert(Vehiculo vehiculo) {
       String sql = "INSERT INTO vehiculo "
                + "(idvehiculo, placa, modelo,anio, cantidadEjes, estado) VALUES (?,?,?,?,?,?)";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, vehiculo.getIdVehiculo());
            ps.setString(2, vehiculo.getPlaca());
            ps.setString(3, vehiculo.getModelo());
            ps.setInt(4, vehiculo.getCantidadEjes());
            ps.setString(3, vehiculo.getEstado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                vehiculo.setIdVehiculo(rs.getInt(1));
            }
            
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        
    }

    @Override
    public Vehiculo findByVehiculoId(int vehiculoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void update(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehiculo> listVehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
