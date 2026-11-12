/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prac_arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author lukaa
 */
public class EJ_2_reloj {

    static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] reloj = new int[4];
        int opc;

        IniciarReloj(reloj);

        do {
            MostrarReloj(reloj);
            opc = menu();
            switch (opc) {
                case 1:
                    AdelantarHora(reloj);
                    break;
                case 2:
                    RetrasarHora(reloj);
                    break;
                case 3:
                    AdelantarMinuto(reloj);
                    break;
                case 4:
                    RetrasarMinuto(reloj);
                    break;
            }

        } while (opc != 0);

    }

    public static int menu() {

        int opc;
        do {
            System.out.println("\nMENU reloj");
            System.out.println("1.adelantar hora");
            System.out.println("2.retrasar hora");
            System.out.println("3.adelantar minuto");
            System.out.println("4.retrasar minuto");
            System.out.println("0.salir");
            System.out.println("opcion:");
            opc = scanner.nextInt();
        } while (opc < 0 || opc > 4);
        return opc;
    }

    public static void MostrarReloj(int[] reloj) {
        System.out.println("" + reloj[0] + reloj[1] + ":" + reloj[2] + reloj[3]);
    }

    public static void IniciarReloj(int[] array) {
        Arrays.fill(array, 0);
    }

    public static int ObtenerHora(int[] array) {
        int hora = (array[0] * 10) + array[1];
        return hora;
    }

    public static int ObtenerMinutos(int[] array) {
        int minutos = (array[2] * 10) + array[3];
        return minutos;
    }

    public static void GuardarHora(int[] array, int hora) {
        array[0] = hora / 10;
        array[1] = hora % 10;
    }

    public static void GuardarMinutos(int[] array, int minutos) {
        array[2] = minutos / 10;
        array[3] = minutos % 10;
    }

    public static void AdelantarHora(int[] array) {
        int hora = ObtenerHora(array);
        hora = hora + 1;
        if (hora == 24) {
            hora = 0;
        }
        GuardarHora(array, hora);

    }

    public static void RetrasarHora(int[] array) {
        int hora = ObtenerHora(array);
        hora = hora - 1;
        if (hora < 0) {
            hora = 23;
        }
        GuardarHora(array, hora);

    }

    public static void AdelantarMinuto(int[] array) {
        int minutos= ObtenerMinutos(array);
        minutos = minutos + 1;
        if (minutos == 60){
            AdelantarHora(array);
            minutos = 0;
        }
        GuardarMinutos(array, minutos);

    }

    public static void RetrasarMinuto(int[] array) {
        int minutos = ObtenerMinutos(array);
        minutos = minutos - 1;
        if (minutos <0){
            RetrasarHora(array);
            minutos = 59;
        }
        GuardarMinutos(array,minutos);
    }

}
