package TarjetaDeCredito;

import BaseDeDatos.BaseDeDatos;
import Cuenta.Cuenta;
import Extracto.Extracto;
import Usuario.Usuario;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * La clase TarjetaDeCredito representa una tarjeta de crédito con información
 * como el número de tarjeta, el tipo de tarjeta, el PIN, la afinidad, la fecha
 * de vencimiento, la deuda total, la deuda al cierre, la línea de crédito y la
 * fecha de cierre.
 *
 * @author David Gomez
 */
public class TarjetaDeCredito {

    private String ciUser;
    private String nroTarjeta;
    private String tipoTarjeta;
    private String pinTarjeta;
    private String afinidad;
    private Date vencimiento;
    private Double deudaTotal;
    private Double deudaAlcierre;
    private Double lineaCredito;
    private Date fechaCierre;
    public BaseDeDatos miBase;

    /**
     * Constructor para la creación de una nueva tarjeta de crédito.
     *
     * @param ciUser El número de cédula del usuario asociado a la tarjeta.
     * @param tipo El tipo de tarjeta de crédito.
     * @param pinT El PIN de la tarjeta.
     * @param afinidad La afinidad de la tarjeta.
     * @param lineaC La línea de crédito asignada a la tarjeta.
     * @param base La base de datos en la que se almacenará la tarjeta.
     * @throws Exception Si hay un error durante la creación de la tarjeta.
     *
     * @author David Gomez
     */
    public TarjetaDeCredito(String ciUser, String tipo, String pinT, String afinidad, Double lineaC, BaseDeDatos base) throws Exception {
        this.ciUser = ciUser;
        this.miBase = base;
        // Genera un número de tarjeta único
        Integer numero = base.getTarjetas().size() + 1;
        this.nroTarjeta = String.format("%016d", numero);

        this.tipoTarjeta = tipo;
        this.pinTarjeta = pinT;
        this.afinidad = afinidad;
        this.lineaCredito = lineaC;
        this.deudaTotal = new Double(0);
        this.deudaAlcierre = new Double(0);

        // Fecha de vencimiento: 1 de enero de 2024
        Calendar calendarVencimiento = new GregorianCalendar();
        calendarVencimiento.set(2024, Calendar.JANUARY, 1);
        this.vencimiento = calendarVencimiento.getTime();

        

        // Fecha de cierre: primero del mes siguiente al actual
        Calendar calendarCierre = new GregorianCalendar();
        calendarCierre.setTime(new Date(0));
        calendarCierre.add(Calendar.MONTH, 1);
        calendarCierre.set(Calendar.DAY_OF_MONTH, 1);
        this.fechaCierre = (Date) calendarCierre.getTime();

        // Agrega la tarjeta a la base de datos
        base.addTarjeta(this);
    }

    // Métodos getter para acceder a la información de la tarjeta
    /**
     * Obtiene la afinidad de la tarjeta.
     *
     * @return La afinidad de la tarjeta.
     *
     * @author David Gomez
     */
    public String getAfinidad() {
        return afinidad;
    }

    /**
     * Obtiene la deuda al cierre de la tarjeta.
     *
     * @return La deuda al cierre de la tarjeta.
     *
     * @author David Gomez
     */
    public Double getDeudaAlcierre() {
        return deudaAlcierre;
    }

    /**
     * Obtiene la deuda total de la tarjeta.
     *
     * @return La deuda total de la tarjeta.
     *
     * @author David Gomez
     */
    public Double getDeudaTotal() {
        return deudaTotal;
    }
    
    
    public String getCiUser(){
        return ciUser;
    }

    /**
     * Obtiene la fecha de cierre de la tarjeta.
     *
     * @return La fecha de cierre de la tarjeta.
     *
     * @author David Gomez
     */
    public Date getFechaCierre() {
        return fechaCierre;
    }

    /**
     * Obtiene la línea de crédito de la tarjeta.
     *
     * @return La línea de crédito de la tarjeta.
     *
     * @author David Gomez
     */
    public Double getLineaCredito() {
        return lineaCredito;
    }

    /**
     * Obtiene el número de la tarjeta.
     *
     * @return El número de la tarjeta.
     *
     * @author David Gomez
     */
    public String getNroTarjeta() {
        return nroTarjeta;
    }

    /**
     * Obtiene el PIN de la tarjeta.
     *
     * @return El PIN de la tarjeta.
     *
     * @author David Gomez
     */
    public String getPinTarjeta() {
        return pinTarjeta;
    }

    /**
     * Obtiene el tipo de la tarjeta.
     *
     * @return El tipo de la tarjeta.
     *
     * @author David Gomez
     */
    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    /**
     * Obtiene la fecha de vencimiento de la tarjeta.
     *
     * @return La fecha de vencimiento de la tarjeta.
     *
     * @author David Gomez
     */
    public Date getVencimiento() {
        return vencimiento;
    }

    /**
     * Este método guarda la tarjeta actual en la base de datos proporcionada.
     *
     * @author David Gomez
     *
     */
    public void guardarEnbase() {
        try {
            // Llama al método addTarjeta de la base de datos para agregar la tarjeta actual.
            miBase.addTarjeta(this);
        } catch (Exception e) {
            // En caso de que ocurra una excepción, imprime el mensaje de la excepción en la consola.
            System.out.println(e.getMessage());
        }
    }

    /**
     * Realiza un pago de deuda utilizando una cuenta de origen y un monto
     * especificados.
     *
     * @param cuentaOrigen La cuenta desde la cual se realizará el pago.
     * @param monto El monto a pagar.
     * @throws Exception Si la cuenta de origen no tiene saldo suficiente para
     * cubrir el monto del pago.
     *
     * @author David Gomez
     */
    public void pagarDeuda(Cuenta cuentaOrigen, double monto) throws Exception {
        if (cuentaOrigen.getSaldo() >= monto) {
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
            this.deudaTotal -= monto;
            this.deudaAlcierre -= monto;

            // Crea un objeto PagoTarjeta y lo agrega a la base de datos
            PagoTarjeta miPago = new PagoTarjeta(cuentaOrigen.getNroCuenta(), this.nroTarjeta, monto);
            this.miBase.addPagoTarjeta(miPago);
        } else {
            throw new Exception("No posees saldo suficiente para pagar este monto");
        }
    }

    /**
     * Realiza un pago utilizando la tarjeta de crédito con un monto y concepto
     * especificados.
     *
     * @param monto El monto del pago.
     * @param Concepto El concepto asociado al pago.
     * @throws Exception Si la suma de la deuda total y el monto supera la línea
     * de crédito de la tarjeta.
     *
     * @author David Gomez
     */
    public void pagar(double monto, String Concepto) throws Exception {
        if (deudaTotal + monto <= lineaCredito) {
            deudaTotal += monto;
            deudaAlcierre += monto;

            // Crea un objeto TransaccionTarjeta y lo agrega a la base de datos
            TransaccionTarjeta transac = new TransaccionTarjeta(this.nroTarjeta, monto, Concepto);
            miBase.AddTranaccionTarjeta(transac);
        } else {
            throw new Exception("Tarjeta Sobregirada");
        }
    }

    /**
     * Convierte los atributos de la tarjeta de crédito a una cadena JSON.
     *
     * @return Una cadena JSON que representa la tarjeta de crédito.
     *
     * @author David Gomez
     */
    public String toJsonString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return "{"
                + "\"ciUser\":\"" + ciUser + "\","
                + "\"nroTarjeta\":\"" + nroTarjeta + "\","
                + "\"tipoTarjeta\":\"" + tipoTarjeta + "\","
                + "\"pinTarjeta\":\"" + pinTarjeta + "\","
                + "\"afinidad\":\"" + afinidad + "\","
                + "\"vencimiento\":\"" + dateFormat.format(vencimiento) + "\","
                + "\"deudaTotal\":" + deudaTotal + ","
                + "\"deudaAlcierre\":" + deudaAlcierre + ","
                + "\"lineaCredito\":" + lineaCredito + ","
                + "\"fechaCierre\":\"" + dateFormat.format(fechaCierre) + "\""
                + "}";
    }
    
    
    public ArrayList<Extracto> getExtracto(){
        return this.miBase.getExtractoTC(this.nroTarjeta);
    }
    
    public Usuario getTitular(){
        return miBase.getUserByCI(ciUser);
    }

}
