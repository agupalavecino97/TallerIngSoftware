
package corralon.vistas.ventaSinPresupuesto;

import corralon.DAO.materialDAO;
import corralon.modelos.stock;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


class materialesTalbeModel2 extends AbstractTableModel{

    private materialDAO material;
    private List<stock> datos=new ArrayList();
    
    public materialesTalbeModel2(materialDAO material){
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
        stock consulta=datos.get(rowIndex);
        switch(columnIndex){
            case 0:return consulta.getCodMaterial();
            case 1:return consulta.getNombreMaterial();
            case 2:return consulta.getPrecio();
            case 3:return consulta.getCantidadExistente();
            default: return "";
        }
    }
    
    
}
