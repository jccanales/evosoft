package pe.edu.upc.evosoftcore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import pe.edu.upc.evosoftcore.dao.LicenciaDAO;
import pe.edu.upc.evosoftcore.entity.Licencia;

/**
 *
 * @author Diego
 */

public class JdbcLicenciaDAO implements LicenciaDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Licencia licencia) {
        String sql = "INSERT INTO licencia "
                + "(idlicencia, numero, categoria, fechaVencimiento) VALUES (?,?,?,?)";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, licencia.getIdLicencia());
            ps.setDate(2, licencia.getFechaVencimiento());
            ps.setString(3, licencia.getCategoria());
            ps.setInt(4, licencia.getNumero());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                licencia.setIdLicencia(rs.getInt(1));
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
    public Licencia findByVehiculoId(int licenciaID) {
        String sql = "SELECT * FROM licencia WHERE idLicencia = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, licenciaID);
            Licencia licencia = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                licencia = new Licencia();
                licencia.setIdLicencia(rs.getInt("idLicencia"));
                licencia.setCategoria(rs.getString("categoria"));
                licencia.setFechaVencimiento(rs.getDate("fechaVencimiento"));
                licencia.setNumero(rs.getInt("numero"));
            }
            rs.close();
            ps.close();
            return licencia;
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
    public List<Licencia> listLicencia() {
        String sql = "SELECT * FROM licencia";
        List<Licencia> licencias = null;

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            Licencia licencia = null;
            ResultSet rs = ps.executeQuery();
            licencias = new ArrayList<Licencia>();
            while (rs.next()) {
                licencia = new Licencia();
                licencia.setIdLicencia(rs.getInt("idLicencia"));
                licencia.setCategoria(rs.getString("categoria"));
                licencia.setFechaVencimiento(rs.getDate("fechaVencimiento"));
                licencia.setNumero(rs.getInt("numero"));

                licencias.add(licencia);
            }
            rs.close();
            ps.close();

            return licencias;

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
    public void update(Licencia LicenciaUpdate) {
        String sql = "UPDATE licencia numero=?, categoria=?, fechaVencimiento=? "
                + "WHERE idlicencia=?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, LicenciaUpdate.getNumero());
            ps.setString(2, LicenciaUpdate.getCategoria());
            ps.setDate(3, LicenciaUpdate.getFechaVencimiento());
            ps.setInt(4, LicenciaUpdate.getIdLicencia());
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
    public void delete(Licencia licencia) {
        String sql = "DELETE FROM licencia WHERE idlicencia = ?";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, licencia.getIdLicencia());
            
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
