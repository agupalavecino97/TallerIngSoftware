
package corralon.vistas.pedidoProveedor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class confirmarPedidoTableModel extends AbstractTableModel{
    
    
        private List<elementosDePedido> datos=new ArrayList();
    
     public confirmarPedidoTableModel(List datos){
        this.datos=datos;
    }

          
        @Override
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
       public Object getValueAt(int rowIndex, int columnIndex) {
        elementosDePedido consulta=datos.get(rowIndex);
        switch(columnIndex){
            case 0:return consulta.getCodProducto();
            case 1:return consulta.getNombrePr();
            case 2:return consulta.getPrecio();
            case 3:return consulta.getCantidad();
            default: return "";
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

  
}
