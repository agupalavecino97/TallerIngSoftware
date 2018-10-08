
package corralon.vistas.ventaConPresupuesto;

import corralon.vistas.ventaSinPresupuesto.*;
import corralon.DAO.materialDAO;
import corralon.modelos.pedidoCliente;
import corralon.modelos.pedidoMaterial;
import corralon.modelos.stock;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

class materialesTalbeModel3 extends AbstractTableModel{

    private List<pedidoMaterialConNombre> pedido;
    //private List<stock> datos=new ArrayList();
    
    public materialesTalbeModel3(List<pedidoMaterialConNombre> pedido){
        this.pedido=pedido;
    }
        
    public void updateModel(){
        
    }
    

    public String getColumnName(int i){
        switch(i){
            case 0:return "codigo";
            case 1:return "nombre";
            case 2:return "cantidad";
            case 3:return "subTotal";
            default:return "[no]"; 
        }
    }
       
    @Override
    public int getRowCount() {
        return pedido.size();
    }

    @Override
    public int getColumnCount() {    
        return 4;
        }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       pedidoMaterialConNombre consulta=pedido.get(rowIndex);
        switch(columnIndex){
            case 0:return consulta.getCodMaterial();
            case 1:return consulta.getNombre();
            case 2:return consulta.getCantidadMaterial();
            case 3:return consulta.getSubTotalMat();
            default: return "";
        }
    }
    
    
}
