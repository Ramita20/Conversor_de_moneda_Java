package com.challengealura.modelos;

import com.challengealura.conexiones.ConexionApi;

import java.io.IOException;
import java.util.Scanner;

public class ConversorDeMoneda {
    Scanner teclado;
    ConexionApi conexion;
    int opcion;
    int opcionSalida;
    double monto;
    String menu;
    String[] codigoMonedas;
    Moneda moneda;

    public ConversorDeMoneda() {
        this.teclado = new Scanner(System.in);
        this.conexion = new ConexionApi();
        this.opcionSalida = 6;
        this.menu = """
                
                1) Dólar
                2) Peso argentino
                3) Real brasileño
                4) Peso colombiano
                5) Ingresar codigo de moneda
                6) Salir
                
                Seleccione una opción:
                """;
    }

    public void ejecutar() throws IOException, InterruptedException {
        System.out.println("************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Móneda :]");
        do {
            this.generarMenu();
            if(this.opcion >= this.opcionSalida){
                break;
            }
            System.out.println("\nIngrese el monto a convertir (Decimales con punto):");
            monto = teclado.nextDouble();
            if(this.moneda == null || !this.moneda.getCodigoMoneda().equals(this.codigoMonedas[0])){
                this.moneda = this.conexion.doGet(this.codigoMonedas[0]);
            }
            this.moneda.setMontoInicial(monto);

            //CONTINUAR DESDE ACÁ.
            //COMENZAR A REALIZAR LA CONVERSIÓN DE UNA MONEDA A LA OTRA.

            System.out.println("************************************************\n");
        } while (true);
        System.out.println("¡¡¡Muchas gracias por usar!!!");
    }

    private void generarMenu(){
        System.out.println("¿Desde que moneda desea convertir?");
        System.out.println(menu);
        this.opcion = teclado.nextInt();
        if(this.opcion >= this.opcionSalida){
            return;
        }
        String codigoMonedaOrigen = this.determinarCodigoMoneda();
        System.out.println("¿Convertir a que moneda?");
        System.out.println(menu);
        this.opcion = teclado.nextInt();
        if(this.opcion >= this.opcionSalida){
            return;
        }
        String codigoMonedaDestino = this.determinarCodigoMoneda();
        this.codigoMonedas = new String[] {codigoMonedaOrigen, codigoMonedaDestino};
    }

    private String determinarCodigoMoneda(){
        switch (this.opcion) {
            case 1:{
                return "USD";
            }
            case 2:{
                return "ARS";
            }
            case 3:{
                return "BRL";
            }
            case 4:{
                return "COP";
            }
            default:{
                System.out.println("Ingrese el código de moneda que desee:");
                return this.teclado.nextLine();
            }
        }

    }
}
