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
public class EJ_1_pila {

    static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int array[] = new int[10];
        Arrays.fill(array, -1);
        int opc;
        do {
            opc = menu();
            switch (opc) {
                case 1:
                    apilar(array);

                    break;

                case 2:
                    desapilar(array);

                    break;
                case 3:
                    mostrarPrimero(array);

                    break;
                case 4:
                    mostrarUltimo(array);

                    break;
            }
        } while (opc != 0);

    }

    public static int menu() {
        int opc;
        do {
            System.out.println("\nMENU PILA");
            System.out.println("1.apilar");
            System.out.println("2.desapilar");
            System.out.println("3.mostrar primero");
            System.out.println("4.mostar ultimo");
            System.out.println("0.salir");
            System.out.println("opcion:");
            opc = scanner.nextInt();
        } while (opc < 0 || opc > 4);
        return opc;
    }

    public static int cima(int[] array) {
        int pos = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != -1) {
                pos = i;
            }
        }
        return pos;
    }
 

    public static void apilar(int[] array) {
        int pos = cima(array) + 1;   // siguiente hueco libre
        if (pos == array.length) {
            System.out.println("pila llena");
        } else {
            int num;
            do {
                System.out.print("introduce un numero natural: ");
                num = scanner.nextInt();
                if (num < 0) {
                    System.out.println("Ha de ser un numero natural (>= 0).");
                }
            } while (num < 0);
            array[pos] = num;
        }
    }
 
    public static void desapilar(int[] array) {
        int pos = cima(array);
        if (pos == -1) {
            System.out.println("pila vacia");
        } else {
            System.out.println("desapilado " + array[pos]);
            array[pos] = -1;
        }
    }
 
    public static void mostrarPrimero(int[] array) {
        int pos = cima(array);
        if (pos == -1) {
            System.out.println("pila vacia");
        } else {
            System.out.println("primero a salir: " + array[pos]);
        }
    }
 

    public static void mostrarUltimo(int[] array) {
        if (array[0] == -1) {
            System.out.println("Pila vacia");
        } else {
            System.out.println("ultimo a salir: " + array[0]);
        }
    }
}