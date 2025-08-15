package net.weg.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionUser {

    Scanner input;

    public ExceptionUser(){
        input = new Scanner(System.in);
    }

    public int hasInt() {
        boolean entradaValida = false;

        int inputUser = 0;

        do{

            String scannerVerify = input.nextLine();

            try {
                inputUser = Integer.parseInt(scannerVerify);

                entradaValida = true;

            } catch (NumberFormatException e) {
                System.out.println("Digite um número sem vírgula.");
            }

        } while(entradaValida == false);


        return inputUser;
    }


    public double hasDouble(){
        boolean entradaValida = false;

        double inputUser = 0;

        do {

            String scannerVerify = input.nextLine();

            try{
                inputUser = Double.parseDouble(scannerVerify);
                entradaValida = true;
            }
            catch (NumberFormatException e){
                System.out.println("Digite um número com vírgula.");
            }

        } while(entradaValida == false);


        return inputUser;
    }
}
