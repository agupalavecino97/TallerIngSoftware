
package corralon.vistas.pedidoProveedor;

import corralon.DAO.catalogoDAO;
import corralon.modelos.catalogo;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

 class materialesTableModel3 extends AbstractTableModel{
    
    private catalogoDAO catalogo;
    private List<catalogo> datos=new ArrayList();
    private Long cuit = null;
    
    public materialesTableModel3(List datos){
        this.datos=datos;
    }
        
     public void updateModel(){
        datos=catalogo.obtenerTodos();
    }

    @Override
    public String getColumnName(int i){
        switch(i){
            case 0:return "codigo";
            case 1:return "cuit";
            case 2:return "precio";
            default:return "[no]"; 
        }
    }
       
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {    
        return 3;
        }
    
    @Override
       public Object getValueAt(int rowIndex, int columnIndex) {
        catalogo consulta=datos.get(rowIndex);
        switch(columnIndex){
            case 0:return consulta.getCodProductoCatalogo();
            case 1: return consulta.getCuitProveedor();
            case 2: return consulta.getPrecioUnitario();
//            case 2:return consulta.getPrecioUnitario();
//                DateFormat df = DateFormat.getDateInstance();
//                return df.format(consulta.getFechaVigencia());
            default: return "";
        }
    }
    
    
}
