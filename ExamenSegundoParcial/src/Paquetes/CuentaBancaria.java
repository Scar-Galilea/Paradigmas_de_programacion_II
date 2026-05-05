
package Paquetes;

public class CuentaBancaria implements Imprimible{
    // Atributos
    private int numeroCuenta;
    private double saldo;
    
    // Construtores
    public CuentaBancaria(){
        this.numeroCuenta = 0;
        this.saldo = 0.0;
    }
    public CuentaBancaria(int numeroCuenta, double saldo){
        this.numeroCuenta   = numeroCuenta;
        this.saldo = saldo;
    }
    
    // Metodos Get y Set
    public int getNumeroCuenta(){
        return numeroCuenta;
    }
    public void setNumeroCuenta(int numeroCuenta){
        this.numeroCuenta = numeroCuenta;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    // Metodos  
    // Metodo para depositar
    public void depositar(double saldoDepositado){
        setSaldo(getSaldo() + saldoDepositado); 
        System.out.println("Ha depositado correctamente");
    }
    
    // Metodo para retirar
    public void retirar(double saldoRetirar) throws FondoInsuficienteException, RetiroAnticipadoException{
        ValidarFondo(getSaldo(),saldoRetirar);
        setSaldo(getSaldo() - saldoRetirar);
        System.out.println("Ha retirado correctamente");
    }
    
    // Metodo de exception
    public static void ValidarFondo(double saldo, double saldoRetirar) throws FondoInsuficienteException{
        if (saldoRetirar > saldo){
            throw new FondoInsuficienteException("Fondos insuficientes");
        }
    }
    
    // Implementacion de la interfaz
    @Override
    public void imprimir(){
        System.out.println("********    Datos de la cuenta bancaria  *********");
        System.out.println("Numero de cuenta: " + getNumeroCuenta());
        System.out.println("Saldo: " + getSaldo());
    }           
}