package pe.edu.upc.evosoftcore.dao.impl;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Licencia findByVehiculoId(int licenciaID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Licencia> listLicencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Licencia LicenciaUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
