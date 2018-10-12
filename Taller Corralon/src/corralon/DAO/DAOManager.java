
package corralon.DAO;

public interface DAOManager {
    clienteDAO getclienteDao();
    materialDAO getmaterialDao();
    proveedorDAO getproveedorDao();
    catalogoDAO getcatalogoDao();
    productoCatalogoDAO getproductocatalogoDao();
    pedidoClienteDAO getpedidoClienteDao();
    facturaDAO getfacturaDao();
    pedidoMaterialDAO getpedidoMaterialDao();
    pedidoProveedorDAO getpedidoProveedorDao();
    detallePedidoProveedorDAO getdetallePedidoProveedor();
    empleadoDAO getempleadoDao();
    remitoDAO getremitoDao();
}
