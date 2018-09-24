
package corralon.vistas.materiales;

import corralon.DAO.materialDAO;
import corralon.modelos.stock;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class MaterialesTableModel extends AbstractTableModel{

    private materialDAO material;
    private List<stock> datos=new ArrayList();
    
    public MaterialesTableModel(materialDAO material){
        this.material=material;
    }
        
    public void updateModel(){
        datos=material.obtenerTodos();
    }

    public String getColumnName(int i){
        switch(i){
            case 0:return "codigoMaterial";
            case 1:return "nombre";
            case 2:return "precio";
            case 3:return "descripcion";
            case 4:return "cantidadExistente";
            case 5:return "stockMinimo";
            case 6:return "stockMaximo";
            default:return "[no]"; 
        }
    }
       
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {    
        return 7;
        }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        stock consulta=datos.get(rowIndex);
        switch(columnIndex){
            case 0:return consulta.getCodMaterial();
            case 1:return consulta.getNombreMaterial();
            case 2:return consulta.getPrecio();
            case 3:return consulta.getDescripcionMaterial();
            case 4:return consulta.getCantidadExistente();
            case 5:return consulta.getStockMinimo();
            case 6:return consulta.getStockMinimo();
            default: return "";
        }
    }
    
    
}
