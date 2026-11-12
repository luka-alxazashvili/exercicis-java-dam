/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prac_arrays;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author lukaa
 */
public class EJ_3_PokeDex {

    static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc;
        String[] poke = new String[100];
        do {
            opc = menu();
            switch (opc) {

                case 1:
                    FillPokedexAuto(poke);
                    break;
                case 2:
                    AddPokemon(poke);
                    break;
                case 3:
                    AddPokemonAtPosition(poke);
                    break;
                case 4:
                    DeletePokemon(poke);
                    break;
                case 5:
                    DeletePokemonAtPosition(poke);
                    break;
                case 6:
                    FindPokemon(poke);
                    break;
                case 7:
                    ShowAllPokemon(poke);
                    break;
                case 8:
                    GetPokemonAtPosition(poke);
                    break;
                case 9:
                    CountPokemon(poke);
                    break;
                case 10:
                    HackPokedex(poke);
                    break;
                case 11:
                    ErasePokedexInfo(poke);
                    break;

            }

        } while (opc != 12);

    }

    public static int menu() {
        int opc;
        do {
            System.out.println("\n>>POKEDEX<<");
            System.out.println("1) FILL POKEDEX AUTO");
            System.out.println("2) ADD POKEMON");
            System.out.println("3) ADD POKEMON AT POSITION");
            System.out.println("4) DELETE POKEMON");
            System.out.println("5) DELETE POKEMON AT POSITION");
            System.out.println("6) FIND POKEMON");
            System.out.println("7) SHOW ALL POKEMON");
            System.out.println("8) GET POKEMON AT POSITION");
            System.out.println("9) COUNT POKEMON");
            System.out.println("10) HACK POKEDEX");
            System.out.println("11) ERASE POKEDEX INFO");
            System.out.println("12) EXIT");
            System.out.println("OPCION:");
            opc = scanner.nextInt();
        } while (opc < 1 || opc > 12);
        return opc;

    }

    public static int Primeralibre(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1;

    }

    public static boolean Posicionvalida(int numero) {

        if (numero >= 0 && numero <= 99) {
            return true;
        }
        return false;
    }

    public static int Buscar(String[] array, String name) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equalsIgnoreCase(name)) {
                return i;
            }

        }
        return -1;

    }

    ///////////////////////////////////////////////
    //////////////////////////////////////////////
    /////////////////////////////////////////////

    public static void FillPokedexAuto(String[] array) {
        String[] pokeini = {"Pikachu", "Charmander", "Bulbasaur", "Squirtle", "Dragonite"};
        int cont = 0;
        for (int i = 0; i < pokeini.length; i++) {
            if (Buscar(array, pokeini[i]) == -1) {
                int pos = Primeralibre(array);
                if (pos != -1) {
                    array[pos] = pokeini[i];
                    cont = cont + 1;
                }

            }

        }
        System.out.println("AGREGADO " + cont + " DE 5");

    }

    public static void AddPokemon(String[] array) {
        System.out.println("ESCRIBE NOMBRE DE POKEMON: ");
        String nombre = scanner.next();
        if (Buscar(array, nombre) != -1) {
            System.out.println("ESTE POKEMON YA EXISTE");
        } else {

            int pos = Primeralibre(array);
            if (pos != -1) {
                array[pos] = nombre;
                System.out.println("AGREGADO " + nombre + " EN LA POS " + pos);
            } else {
                System.out.println("POKEDEX ESTA LLENA");
            }
        }
    }

    public static void AddPokemonAtPosition(String[] array) {
        System.out.println("ESCRIBE NOMBRE DEL POKEMON: ");
        String nombre = scanner.next();
        System.out.println("ESCRIBE POSICION DEL POKEMON: ");
        int posi = scanner.nextInt();
        if (!Posicionvalida(posi)) {
            System.out.println("POSICION INVALIDA");
        } else if (array[posi] != null) {
            System.out.println("POSICION OCUPADA");
        } else if (Buscar(array, nombre) != -1) {
            System.out.println("POKEMON YA EXISTE");
        } else {
            array[posi] = nombre;
            System.out.println(nombre + " AGREGADO EN LA POSICION " + posi);
        }
    }

    public static void DeletePokemon(String[] array) {
        System.out.println("ESCRIBE NOMBRE DE POKEMON PARA BORRAR:");
        String nombre = scanner.next();
        int pos = Buscar(array, nombre);
        if (pos == -1) {
            System.out.println("ESTE POKEMON NO EXISTE");
        } else {
            array[pos] = null;
            System.out.println("POKEMON BORRADO CON EXITO");
        }
    }

    public static void DeletePokemonAtPosition(String[] array) {
        System.out.println("ESCRIBE POSICION DE POKEMON A BORRAR: ");
        int posi = scanner.nextInt();
        if (!Posicionvalida(posi)) {
            System.out.println("POSICION INVALIDA");
        } else if (array[posi] == null) {
            System.out.println("NO HAY POKEMON EN ESA POSICION");
        } else {
            System.out.println("BORRADO " + array[posi] + " CON EXITO");
            array[posi] = null;
        }
    }

    public static void FindPokemon(String[] array) {
        System.out.println("ESCRIBE EL NOMBRE DEL POKEMON");
        String nombre = scanner.next();
        int pos = Buscar(array, nombre);
        if (pos == -1) {
            System.out.println("POKEMON NO ENCONTRADO");
        } else {
            System.out.println(nombre + " ESTA EN LA POSICION " + pos);
        }
    }

    public static void ShowAllPokemon(String[] array) {
        int cont = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println("- " + array[i]);
                cont = cont + 1;
            }
        }
        if (cont == 0) {
            System.out.println("POKEDEX ESTA VACIA");
        }
    }

    public static void GetPokemonAtPosition(String[] array) {
        System.out.println("DIME LA POSICION");
        int posi = scanner.nextInt();
        if (!Posicionvalida(posi)) {
            System.out.println("POSICION INVALIDA");
        } else if (array[posi] == null) {
            System.out.println("NO HAY POKEMON EN ESA POSICION");
        } else {
            System.out.println("EL POKEMON DE LA POSICION " + posi + " ES " + array[posi]);
        }
    }

    public static void CountPokemon(String[] array) {
        int cont = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                cont = cont + 1;
            }
        }
        System.out.println("HAY EN TOTAL " + cont + " POKEMONS");

    }

    public static void HackPokedex(String[] array) {
        String name = "Ditto";
        Arrays.fill(array,name);
        System.out.println("HACKED :)");
    }

    public static void ErasePokedexInfo(String[] array) {
        String name = ("Ditto");
        Arrays.fill(array,name);
        System.out.println("EXITO, POKEDEX ESTA VACIA");
    }

}
