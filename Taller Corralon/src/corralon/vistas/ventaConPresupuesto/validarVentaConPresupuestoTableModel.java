
package corralon.vistas.ventaConPresupuesto;

import corralon.vistas.ventaSinPresupuesto.*;
import corralon.DAO.materialDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class validarVentaConPresupuestoTableModel extends AbstractTableModel{
   
    private List<pedidoMaterialConNombre> datos=new ArrayList();
    
     public validarVentaConPresupuestoTableModel(List<pedidoMaterialConNombre> datos){
        this.datos=datos;
    }
     
    public String getColumnName(int i){
        switch(i){
            case 0:return "codigo";
            case 1:return "nombre";
            case 2:return "cantidad solicitada";
            case 3:return "precio";
            case 4:return "SubTotal";
            default:return "[no]"; 
        }
    }     
    @Override
    public int getRowCount() {       
         return datos.size();
    }

    @Override
    public int getColumnCount() {
            return 5;
          }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        pedidoMaterialConNombre consulta=datos.get(rowIndex);
        switch(columnIndex){
            case 0:return consulta.getCodMaterial();
            case 1:return consulta.getNombre();
            case 2:return consulta.getCantidadMaterial();
            case 3:return consulta.getPrecio();
            case 4:return consulta.getSubTotalMat();
            
            default: return "";
        }
    }
    
    
    
    
}
