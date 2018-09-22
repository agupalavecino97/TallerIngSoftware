
package corralon.vistas;

import corralon.DAO.clienteDAO;
import corralon.modelos.cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Clientestablemodel extends AbstractTableModel{

   private  clienteDAO clientes;
    private List<cliente> datos=new ArrayList<>();
    
    public Clientestablemodel(clienteDAO clientes){
        this.clientes=clientes;
    }
   
    
    public void updateModel(){
            datos=clientes.obtenerTodos();
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0:return "cuitCliente";
            case 1:return "razonSocial";
            case 2:return "Direccion";
            case 3:return "Telefono";
            case 4:return "Estado";
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
    public Object getValueAt(int rowIndex, int columIndex) {
       cliente consulta=datos.get(rowIndex);
       switch (columIndex){
           case 0: return consulta.getCuitCliente();
           case 1: return consulta.getRazonSocial();
           case 2: return consulta.getDireccionCliente();
           case 3: return consulta.getTelefonoCliente();
           case 4: return consulta.isEstadoClie();
           default: return "";
       }     
    }     
    
}
