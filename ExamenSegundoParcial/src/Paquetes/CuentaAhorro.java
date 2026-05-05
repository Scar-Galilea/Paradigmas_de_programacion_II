package Paquetes;

public class CuentaAhorro extends CuentaBancaria{
    // Atributos
    private String nombreAhorro;
    private String periodo;
    private boolean estadoPeriodo;

    // Construtores
    public CuentaAhorro(){
        this.nombreAhorro = "";
        this.periodo = "";
        this.estadoPeriodo = false;
    }
    public CuentaAhorro(String nombreAhorro, String periodo, boolean estadoPeriodo, int numeroCuenta, double saldo){
        super(numeroCuenta,saldo);
        this.nombreAhorro = nombreAhorro;
        this.periodo = periodo;
        this.estadoPeriodo = estadoPeriodo;
    }

    // Metodos Get y Set
    public String getNombreAhorro(){
        return nombreAhorro;
    }
    public void setNombreAhorro(String nombreAhorro){
        this.nombreAhorro = nombreAhorro;
    }
    public String getPeriodo(){
        return periodo;
    }
    public void setPeriodo(String periodo){
        this.periodo = periodo;
    }
    public boolean getEstadoPeriodo(){
        return estadoPeriodo;
    }
    public void setEstadoPeriodo(boolean estadoPeriodo){
        this.estadoPeriodo = estadoPeriodo;
    }

    // Metodos

    // Metodo para retirar
     @Override
    public void retirar(double saldoRetirar) throws FondoInsuficienteException ,RetiroAnticipadoException{
        ValidarFondo(getSaldo(),saldoRetirar);
        validarRetiro(getEstadoPeriodo());
        setSaldo(getSaldo() - saldoRetirar);
        System.out.println("Ha retirado correctamente");
    }
    
    // Metodo para imprimir
    @Override
    public void imprimir(){
        System.out.println("********    Datos de la cuenta de ahorro   *********");
        System.out.println("Nombre del ahorro: " + getNombreAhorro());
        System.out.println("Periodo: " + getPeriodo());
        System.out.println("Estado del periodo: " + getEstadoPeriodo());
        System.out.println("Numero de cuenta: " + getNumeroCuenta());
        System.out.println("Saldo: " + getSaldo() + "\n");
    }
    
    
    
    // Metodos exception
    // Varlidar el retiro
    public static void validarRetiro(boolean estadoPeriodo) throws RetiroAnticipadoException{
        if(! estadoPeriodo){
            throw new RetiroAnticipadoException("Retiro ancicipado");
        }
    }

    
}
