package corralon.vistas.recibirPedido;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

class pedidoTableModel extends AbstractTableModel{

    
    private List<pedidoProveedorConNombre> datos=new ArrayList();

    
    pedidoTableModel(List<pedidoProveedorConNombre> pedido){
        datos=pedido;
    }
    @Override
    public int getRowCount() {
        return datos.size();
    }

     public String getColumnName(int i){
        switch(i){
            case 0:return "codigo de producto";
            case 1:return "nombre";
            case 2:return "cantidad solicitada";
            case 3:return "precio";
            case 4:return "SubTotal";
            default:return "[no]"; 
        }
    }     
    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        pedidoProveedorConNombre consulta=datos.get(rowIndex);
        switch(columnIndex){
            case 0:return consulta.getCodigoMaterial();
            case 1:return consulta.getNombre();
            case 2:return consulta.getCantidadSolicitada();
            case 3:return consulta.getPrecioActual();
            case 4:return consulta.getSubtotalPedidoProveedor();
            
            default: return "";
        }
    }
    
}
