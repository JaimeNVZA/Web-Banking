package webbankingg13;

import BaseDeDatos.BaseDeDatos;
import BaseDeDatos.Seeders;
import Interfaz.InterfazLogin1;
import Servicio.Servicio;

/**
 *
 * @author bancocontinental05
 */
public class WebBankingG13 {

    public static void main(String[] args) {
        BaseDeDatos mainDB = new BaseDeDatos(); // crea una base de datos
        Seeders.seed(mainDB); // carga los valore iniciales en la base de datos
        InterfazLogin1 l1 = new InterfazLogin1(mainDB);
        l1.setVisible(true);
    }
}
