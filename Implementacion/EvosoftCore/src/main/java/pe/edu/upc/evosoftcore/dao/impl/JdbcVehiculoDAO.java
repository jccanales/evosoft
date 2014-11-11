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
    /*
     @Override
    public void insert(Vehiculo vehiculo) {
        String sql = "INSERT INTO vehiculo "
                + "(idvehiculo, idlicencia, nombre, apellido, telefono) VALUES (?,?,?,?,?)";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, vehiculo.getCantidadEjes());
            ps.setInt(2, vehiculo.getIdVehiculo());
            ps.setString(3, vehiculo.getNombre());
            ps.setString(4, vehiculo.getApellido());
            ps.setInt(5, vehiculo.getTelefono());
            ps.executeUpdate();
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
    public Chofer findByChoferId(int vehiculoId) {
        String sql = "SELECT * FROM vehiculo WHERE idvehiculo = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, vehiculoId);
            Chofer vehiculo = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vehiculo = new Chofer();
                vehiculo.setIdChofer(rs.getInt("idvehiculo"));
                vehiculo.setNombre(rs.getString("nombre"));
                vehiculo.setApellido(rs.getString("apellido"));
                vehiculo.setTelefono(rs.getInt("telefono"));
                Licencia licencia = new Licencia();
                licencia.setIdLicencia(rs.getInt("idlicencia"));
                vehiculo.setLicencia(licencia);
            }
            rs.close();
            ps.close();
            return vehiculo;
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
    public List<Chofer> listChofer() {
        String sql = "SELECT * FROM vehiculo";
        List<Chofer> vehiculoes = null;

        Connection conn = null;
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            Chofer vehiculo = null;
            ResultSet rs = ps.executeQuery();
            vehiculoes = new ArrayList<Chofer>();
            while (rs.next()) {
                vehiculo = new Chofer();
                vehiculo.setIdChofer(rs.getInt("idvehiculo"));
                vehiculo.setNombre(rs.getString("nombre"));
                vehiculo.setApellido(rs.getString("apellido"));
                vehiculo.setTelefono(rs.getInt("telefono"));
                Licencia licencia = new Licencia();
                licencia.setIdLicencia(rs.getInt("idlicencia"));
                vehiculo.setLicencia(licencia);
                vehiculoes.add(vehiculo);
            }
            rs.close();
            ps.close();
            return vehiculoes;
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
*/
    @Override
    public void insert(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vehiculo findByVehiculoId(int vehiculoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehiculo> listVehiclo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Vehiculo VehiculoUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
