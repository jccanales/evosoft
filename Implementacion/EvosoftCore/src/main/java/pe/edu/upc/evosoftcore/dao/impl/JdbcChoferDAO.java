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
import pe.edu.upc.evosoftcore.dao.ChoferDAO;
import pe.edu.upc.evosoftcore.entity.Chofer;
import pe.edu.upc.evosoftcore.entity.Licencia;

/**
 *
 * @author Jean Carlo
 */

public class JdbcChoferDAO implements ChoferDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Chofer chofer) {
        String sql = "INSERT INTO chofer "
                + "(idchofer, idlicencia, nombre, apellido, telefono) VALUES (?,?,?,?,?)";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, chofer.getIdChofer());
            ps.setInt(2, chofer.getLicencia().getIdLicencia());
            ps.setString(3, chofer.getNombre());
            ps.setString(4, chofer.getApellido());
            ps.setInt(5, chofer.getTelefono());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                chofer.setIdChofer(rs.getInt(1));
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
    public Chofer findByChoferId(int choferId) {
        String sql = "SELECT * FROM chofer WHERE idchofer = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, choferId);
            Chofer chofer = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                chofer = new Chofer();
                chofer.setIdChofer(rs.getInt("idchofer"));
                chofer.setNombre(rs.getString("nombre"));
                chofer.setApellido(rs.getString("apellido"));
                chofer.setTelefono(rs.getInt("telefono"));
                Licencia licencia = new Licencia();
                licencia.setIdLicencia(rs.getInt("idlicencia"));
                chofer.setLicencia(licencia);
            }
            rs.close();
            ps.close();
            return chofer;
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
        String sql = "SELECT * FROM chofer";
        List<Chofer> choferes = null;

        Connection conn = null;
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            Chofer chofer = null;
            ResultSet rs = ps.executeQuery();
            choferes = new ArrayList<Chofer>();
            while (rs.next()) {
                chofer = new Chofer();
                chofer.setIdChofer(rs.getInt("idchofer"));
                chofer.setNombre(rs.getString("nombre"));
                chofer.setApellido(rs.getString("apellido"));
                chofer.setTelefono(rs.getInt("telefono"));
                Licencia licencia = new Licencia();
                licencia.setIdLicencia(rs.getInt("idlicencia"));
                chofer.setLicencia(licencia);
                choferes.add(chofer);
            }
            rs.close();
            ps.close();
            return choferes;
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
    public void update(Chofer chofer) {
         String sql = "UPDATE chofer SET idlicencia=?, nombre=?, apellido=?, telefono=? "
                 + "WHERE idchofer=?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, chofer.getLicencia().getIdLicencia());
            ps.setString(2, chofer.getNombre());
            ps.setString(3, chofer.getApellido());
            ps.setInt(4, chofer.getTelefono());
            ps.setInt(5, chofer.getIdChofer());
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
    public void delete(Chofer chofer) {
        String sql = "DELETE FROM chofer WHERE idchofer = ?";
         Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, chofer.getIdChofer());
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
}
