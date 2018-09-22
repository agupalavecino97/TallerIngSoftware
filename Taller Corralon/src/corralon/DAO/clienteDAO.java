package corralon.DAO;
import corralon.modelos.cliente;

//En nuestro caso no iria en lugar de un long un int? en el video muestra que utiliza long para la PK, pero nosotros usamos un int
//No puedo cambiar de tipo por que me tira error en el metodo obtener cuadno queiro usarlo en listaCliente
public interface clienteDAO extends DAO<cliente, Long>{
     
}
