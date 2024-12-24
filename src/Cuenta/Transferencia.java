package Cuenta;

import Extracto.Extracto;

/**
 * La clase Transferencia representa una transferencia de fondos entre dos
 * cuentas bancarias. Contiene información sobre las cuentas de origen y
 * destino, los bancos de origen y destino, y el monto transferido. Esta clase
 * se utiliza para registrar transferencias en la base de datos.
 *
 * @author bancocontinental05
 */
public class Transferencia implements Extracto {

    private String cuentaOrigen;
    private String cuentaDestino;
    private String bancoOrigen;
    private String bancoDestino;
    private double monto;

    /**
     * Constructor de la clase Transferencia.
     *
     * @param origen La cuenta de origen de la transferencia.
     * @param destino La cuenta de destino de la transferencia.
     * @param monto El monto transferido.
     * @param bDest El banco de destino de la transferencia.
     * @param bOrigin El banco de origen de la transferencia.
     * 
     * @author David Gomez
     */
    public Transferencia(Cuenta origen, Cuenta destino, double monto, String bDest, String bOrigin) {
        cuentaOrigen = origen.getNroCuenta();
        cuentaDestino = destino.getNroCuenta();
        bancoDestino = bDest;
        bancoOrigen = bOrigin;
        this.monto = monto;
    }

    /**
     * Obtiene la cuenta de origen de la transferencia.
     *
     * @return La cuenta de origen de la transferencia.
     * 
     * @author David Gomez
     */
    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    /**
     * Obtiene la cuenta de destino de la transferencia.
     *
     * @return La cuenta de destino de la transferencia.
     * 
     * 
     * @author David Gomez
     */
    public String getCuentaDestino() {
        return cuentaDestino;
    }

    /**
     * Obtiene el banco de origen de la transferencia.
     *
     * @return El banco de origen de la transferencia.
     * 
     * @author David Gomez
     */
    public String getBancoOrigen() {
        return bancoOrigen;
    }

    /**
     * Obtiene el banco de destino de la transferencia.
     *
     * @return El banco de destino de la transferencia.
     * 
     * @author David Gomez
     */
    public String getBancoDestino() {
        return bancoDestino;
    }

    /**
     * Obtiene el monto transferido en la transferencia.
     *
     * @return El monto transferido.
     * 
     * @author David Gomez
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Genera una representación en formato JSON de los atributos de la clase.
     *
     * @return Una cadena que representa los atributos en formato JSON.
     * 
     * 
     * @author David Gomez
     */
    public String toJsonString() {
        // Construye manualmente la representación JSON
        String jsonString = "{"
                + "\"cuentaOrigen\":\"" + cuentaOrigen + "\","
                + "\"cuentaDestino\":\"" + cuentaDestino + "\","
                + "\"bancoOrigen\":\"" + bancoOrigen + "\","
                + "\"bancoDestino\":\"" + bancoDestino + "\","
                + "\"monto\":" + monto
                + "}";

        return jsonString;
    }

    /**
     * Imprime la representación en formato JSON de los atributos en la consola.
     * 
     * @author David Gomez
     */
    @Override
    public void imprimir() {
        System.out.println(toJsonString());
    }

}
