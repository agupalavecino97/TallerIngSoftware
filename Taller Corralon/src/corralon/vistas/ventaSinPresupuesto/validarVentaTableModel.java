
package corralon.vistas.ventaSinPresupuesto;

import corralon.DAO.materialDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class validarVentaTableModel extends AbstractTableModel{
   
    private List<pedidoConCantidad> datos=new ArrayList();
    
     public validarVentaTableModel(List datos){
        this.datos=datos;
    }
     
    public String getColumnName(int i){
        switch(i){
            case 0:return "codigo";
            case 1:return "nombre";
            case 2:return "cantidad solicitada";
            case 3:return "precio";
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
        pedidoConCantidad consulta=datos.get(rowIndex);
        switch(columnIndex){
            case 0:return consulta.getCodMaterial();
            case 1:return consulta.getNombreMaterial();
            case 2:return consulta.getCantidad();
            case 3:return consulta.getPrecio();
            default: return "";
        }
    }
    
    
    
    
}
