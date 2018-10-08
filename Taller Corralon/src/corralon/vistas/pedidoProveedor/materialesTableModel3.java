
package corralon.vistas.pedidoProveedor;

import corralon.DAO.catalogoDAO;
import corralon.modelos.catalogo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class materialesTableModel3 {
    
    private catalogoDAO catalogo;
    private List<catalogo> datos=new ArrayList();
    
    public materialesTableModel3(catalogoDAO catalogo){
        this.catalogo=catalogo;
    }
        
    public void updateModel(){
        Long a = Long.valueOf("1");
        datos =(List<catalogo>) catalogo.obtenerTodos();
    }

    public String getColumnName(int i){
        switch(i){
            case 0:return "codigo";
            case 1:return "nombre";
            case 2:return "precio";
            default:return "[no]"; 
        }
    }
       
    public int getRowCount() {
        return datos.size();
    }

    public int getColumnCount() {    
        return 3;
        }
    
       public Object getValueAt(int rowIndex, int columnIndex) {
        catalogo consulta=datos.get(rowIndex);
        switch(columnIndex){
            case 0:return consulta.getCodProductoCatalogo();
            case 1: return consulta.getCodProductoCatalogo();
            case 2: return consulta.getPrecioUnitario();
//            case 2:return consulta.getPrecioUnitario();
            //case 4: return consulta.getCodProv();
            default: return "";
        }
    }
    
    
}
