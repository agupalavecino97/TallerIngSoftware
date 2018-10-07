
package corralon.DAO;

public interface DAOManager {
    clienteDAO getclienteDao();
    materialDAO getmaterialDao();
    proveedorDAO getproveedorDao();

    public materialDAO getcatalogoDao();

}
