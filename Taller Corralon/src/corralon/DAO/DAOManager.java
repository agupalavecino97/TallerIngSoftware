
package corralon.DAO;

public interface DAOManager {
    clienteDAO getclienteDao();
    materialDAO getmaterialDao();
    proveedorDAO getproveedorDao();
    catalogoDAO getcatalogoDao();
    
    
    
    
    
    
    pedidoClienteDAO getpedidoClienteDao();
    facturaDAO getfacturaDao();
    pedidoMaterialDAO getpedidoMaterialDao();
}
