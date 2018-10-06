
package corralon.vistas.pedidoProveedor;

import corralon.DAO.materialDAO;
import corralon.modelos.stock;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class materialesTableModel3 {
    
    private materialDAO material;
    private List<stock> datos=new ArrayList();
    
    public materialesTableModel3(materialDAO material){
        this.material=material;
    }
        
    public void updateModel(){
        datos=material.obtenerTodos();
    }

    public String getColumnName(int i){
        switch(i){
            case 0:return "codigo";
            case 1:return "nombre";
            case 2:return "precio";
            case 3:return "cantidadExistente";
            case 4:return "cantidadSolicitada";
            case 5: return "codProveedor";
            default:return "[no]"; 
        }
    }
       
    public int getRowCount() {
        return datos.size();
    }

    public int getColumnCount() {    
        return 5;
        }
    
       public Object getValueAt(int rowIndex, int columnIndex) {
        stock consulta=datos.get(rowIndex);
        switch(columnIndex){
            case 0:return consulta.getCodMaterial();
            case 1:return consulta.getNombreMaterial();
            case 2:return consulta.getPrecio();
            case 3:return consulta.getCantidadExistente();
            //case 4: return consulta.getCodProv();
            default: return "";
        }
    }
    
    
}
