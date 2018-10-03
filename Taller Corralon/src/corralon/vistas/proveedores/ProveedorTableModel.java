
package corralon.vistas.proveedores;

import corralon.DAO.proveedorDAO;
import corralon.modelos.proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ProveedorTableModel extends AbstractTableModel {
    private proveedorDAO proveedor;
    
    private List<proveedor> datos = new ArrayList<>();
    
    public void updateModel(){ 
        datos = proveedor.obtenerTodos();
    }
    
    public ProveedorTableModel(proveedorDAO proveedor){
    this.proveedor = proveedor;
}

    @Override
    public String getColumnName(int i) {
            switch(i){
            case 0:return "cuitCliente";
            case 1:return "razonSocial";
            case 2:return "Direccion";
            case 3:return "Telefono";
            case 4:return "Estado";
            default:return "[no]";
        }  
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        proveedor consulta = datos.get(rowIndex);
        switch (columnIndex){
           case 0: return consulta.getCuitProveedor();
           case 1: return consulta.getNombreProveedor();
           case 2: return consulta.getDireccionProveedor();
           case 3: return consulta.getTelefonoProveedor();
           case 4: return consulta.isEstadoProveedor();
           default: return "";
        }
    }
    

    
}
