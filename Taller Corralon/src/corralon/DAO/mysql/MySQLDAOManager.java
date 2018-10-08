package corralon.DAO.mysql;

import corralon.DAO.DAOManager;
import corralon.DAO.catalogoDAO;
import corralon.DAO.clienteDAO;
import corralon.DAO.materialDAO;
import corralon.DAO.productoCatalogoDAO;
import corralon.DAO.proveedorDAO;
import corralon.modelos.catalogo;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class MySQLDAOManager implements DAOManager{
    
    private clienteDAO clientes=null;

    private materialDAO materiales=null;

    private proveedorDAO proveedor=null;
    
    private catalogoDAO catalogo = null;
    
    private productoCatalogoDAO productoCatalogo = null;
    
    private final Connection con;
    
    public MySQLDAOManager(String host, String database, String user, String password) throws SQLException {
        con=DriverManager.getConnection("jdbc:mysql://" + host + "/" + database,user,password);
     }
     
    
    @Override
    public clienteDAO getclienteDao() {
            if(clientes==null){
                clientes=new MySQLClienteDAO(con); 
            }
            return clientes;
    }
    
    @Override
    public proveedorDAO getproveedorDao(){
            if(proveedor==null){
                proveedor = new MySQLProveedorDAO(con);
            }
            return proveedor;
    }
    
    //lo mismo hay que hacer para todas las clases

    
   
//    public static void main(String[] args) throws SQLException{
//        MySQLDAOManager man=new MySQLDAOManager("localhost","taller","root","root");
//        //cliente a=new cliente(45,"pepo","dirpepo", 456,true);
//        //man.getclienteDao().insertar(a);
//        List<cliente> clientes=man.getclienteDao().obtenerTodos();
//        System.out.println("Clientes"+clientes);
//    }

    @Override
    public materialDAO getmaterialDao() {
        if(materiales==null){
                        materiales=new MySQLMaterialDAO(con); 
                    }
                    return materiales;
    }

    @Override
    public catalogoDAO getcatalogoDao() {
        if(catalogo==null){
                        catalogo=new MySQLCatalogoDAO(con); 
                    }
                    return catalogo;
    }

    @Override
    public productoCatalogoDAO getproductocatalogoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
    
    
}
 