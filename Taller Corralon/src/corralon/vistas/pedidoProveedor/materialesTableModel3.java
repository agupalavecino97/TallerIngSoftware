
package corralon.vistas.pedidoProveedor;

import corralon.DAO.catalogoDAO;
import corralon.DAO.materialDAO;
import corralon.DAO.productoCatalogoDAO;
import corralon.modelos.catalogo;
import corralon.modelos.stock;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class materialesTableModel3 {
    
    private materialDAO material;
    private catalogoDAO catalogo;
    private List<catalogo> listacat=new ArrayList();
    
    public materialesTableModel3(materialDAO material){
        this.material=material;
    }
        
    public void updateModel(){
        listacat =catalogo.obtenerTodos();
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
        return listacat.size();
    }

    public int getColumnCount() {    
        return 3;
        }
    
       public Object getValueAt(int rowIndex, int columnIndex) {
        catalogo consulta=listacat.get(rowIndex);
        switch(columnIndex){
            case 0:return consulta.getCodProductoCatalogo();
//            case 1:return consulta.getCuitProveedor();
//            case 2:return consulta.getPrecioUnitario();
            //case 4: return consulta.getCodProv();
            default: return "";
        }
    }
    
    
}
