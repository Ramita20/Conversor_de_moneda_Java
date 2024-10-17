package com.challengealura.modelos;

import com.challengealura.conexiones.ConexionApi;

import java.io.IOException;
import java.util.Scanner;

public class ConversorDeMoneda {
    Scanner teclado;
    ConexionApi conexion;
    int opcion;
    double monto;
    String menu;
    String[] codigoMonedas;

    public ConversorDeMoneda() {
        this.teclado = new Scanner(System.in);
        this.conexion = new ConexionApi();
        this.menu = """
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                
                """;
    }

    public void ejecutar() throws IOException, InterruptedException {
        System.out.println("************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Móneda :]");
        do {
            System.out.println(menu);
            System.out.println("Seleccione una opción:");
            opcion = teclado.nextInt();
            if (opcion == 7) {
                break;
            }
            System.out.println("\nIngrese el monto a convertir (Decimales con punto):");
            monto = teclado.nextDouble();
            this.determinarCodigoMonedas();
            this.conexion.doGet(this.codigoMonedas[0]);

            System.out.println("************************************************\n");
        } while (true);
        System.out.println("¡¡¡Muchas gracias por usar!!!");
    }

    private void determinarCodigoMonedas(){
        switch (this.opcion) {
            case 1:{
                this.codigoMonedas = new String[] {"USD", "ARS"};
                break;
            }
            case 2:{
                this.codigoMonedas = new String[] {"ARS", "USD"};
                break;
            }
            case 3:{
                this.codigoMonedas = new String[] {"USD", "BRL"};
                break;
            }
            case 4:{
                this.codigoMonedas = new String[] {"BRL", "USD"};
                break;
            }
            case 5:{
                this.codigoMonedas = new String[] {"USD", "COP"};
                break;
            }
            case 6:{
                this.codigoMonedas = new String[] {"COP", "USD"};
                break;
            }
        }
    }
}
