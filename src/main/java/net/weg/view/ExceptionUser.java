package net.weg.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionUser {

    Scanner input;

    public ExceptionUser(){
        input = new Scanner(System.in);
    }

    public int hasInt() {
        String scannerVerify = input.nextLine();
        boolean entradaValida = false;

        int inputUser = 0;

        try {
            inputUser = Integer.parseInt(scannerVerify);

            entradaValida = true;

        } catch (NumberFormatException e) {
            System.out.println("Digite um número sem vírgula.");
        }

        return inputUser;
    }


    public double hasDouble(){
        String scannerVerify = input.nextLine();

        boolean entradaValida = false;

        double inputUser = 0;

        try{
            inputUser = Double.parseDouble(scannerVerify);
            input.nextLine();
        }
        catch (InputMismatchException e){
            System.out.println("Digite um número com vírgula.");
        }

        return inputUser;
    }
}
