package com.bazarek.bazarek.cezar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CesarCodsApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        try {
            do {
                System.out.println("------------------- CESAR  CODE ------------------------");
                System.out.println("1 - Decode");
                System.out.println("2 - Encode");
                System.out.println("3 - EXIT");
                option = sc.nextInt();
                sc.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("Podaj tekst: ");
                        String output = sc.nextLine();
                        String outputEncode = CesarCode.encode(output);
                        System.out.println(outputEncode);
                        break;
                    case 2:
                        System.out.println("Podaj tekst: ");
                        String decode = sc.nextLine();
                        String outputDecodes = CesarCode.decode(decode);
                        System.out.println(outputDecodes);
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Błedne dane. Podaj opcje 1  2 lub 0");
                }
            } while (option != 0);
        }catch (InputMismatchException e){
            System.err.println("Oj!!! Wprowadź poprawne dane (1   2 lub  3)");
        }
    }
}
