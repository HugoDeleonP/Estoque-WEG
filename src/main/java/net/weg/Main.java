package net.weg;

import net.weg.service.EstoqueService;
import net.weg.view.InterfaceUsuario;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        EstoqueService manager = new EstoqueService();
        InterfaceUsuario uiView = new InterfaceUsuario();

        int keyPage = -1;

        do{
            keyPage = uiView.switchPage();
            manager.pageManager(keyPage);
        } while(keyPage != 0);

    }

}