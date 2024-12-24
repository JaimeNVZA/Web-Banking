package TarjetaDeCredito;

import java.text.SimpleDateFormat;
import java.util.Date;

import Extracto.Extracto;

/**
 * La clase PagoTarjeta representa el pago de la tarjeta. Contiene información
 * sobre la cuenta de origen, el número de tarjeta, el monto y la fecha de
 * creación.
 *
 * @author David Gomez
 */
public class PagoTarjeta implements Extracto {

    private String CuentaOrigen;
    private String nroTarjeta;
    private double monto;
    private Date createdAt;

    /**
     * Constructor de la clase PagoTarjeta.
     *
     * @param cuenta La cuenta de origen del pago de tarjeta.
     * @param numeroTarjeta El número de la tarjeta utilizada en el pago.
     * @param monto El monto del pago de tarjeta.
     *
     * @author David Gomez
     */
    public PagoTarjeta(String cuenta, String numeroTarjeta, double monto) {
        this.CuentaOrigen = cuenta;
        this.nroTarjeta = numeroTarjeta;
        this.monto = monto;
        this.createdAt = new Date();
    }

    /**
     * Obtiene la cuenta de origen del pago de tarjeta.
     *
     * @return La cuenta de origen del pago de tarjeta.
     *
     * @author David Gomez
     */
    public String getCuentaOrigen() {
        return CuentaOrigen;
    }

    /**
     * Obtiene el número de tarjeta utilizado en el pago.
     *
     * @return El número de tarjeta utilizado en el pago.
     *
     * @author David Gomez
     */
    public String getNroTarjeta() {
        return nroTarjeta;
    }

    /**
     * Obtiene el monto del pago de tarjeta.
     *
     * @return El monto del pago de tarjeta.
     *
     * @author David Gomez
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Obtiene la fecha de creación del pago de tarjeta.
     *
     * @return La fecha de creación del pago de tarjeta.
     *
     * @author David Gomez
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Genera una representación en formato JSON de los atributos de la clase.
     *
     * @return Una cadena que representa los atributos en formato JSON.
     *
     * @author David Gomez
     */
    public String toJsonString() {
        // Formatea la fecha como "yyyy-MM-dd HH:mm:ss" (puedes ajustar el formato según
        // tus preferencias)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = dateFormat.format(createdAt);

        // Construye manualmente la representación JSON
        String jsonString = "{"
                + "\"CuentaOrigen\":\"" + CuentaOrigen + "\","
                + "\"nroTarjeta\":\"" + nroTarjeta + "\","
                + "\"monto\":" + monto + ","
                + "\"createdAt\":\"" + fechaFormateada + "\""
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
