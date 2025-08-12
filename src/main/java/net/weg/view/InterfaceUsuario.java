package net.weg.view;

import java.util.Scanner;

public class InterfaceUsuario {

    Scanner input;
    ExceptionUser exceptionUser;

    public InterfaceUsuario(){
        input = new Scanner(System.in);
        exceptionUser = new ExceptionUser();
    }

    public String readCodigo(){
        System.out.println("Digite o código do equipamento: ");

        return input.nextLine();
    }

    public String readNome(){
        System.out.println("Digite o nome do equipamento: ");

        return input.nextLine();
    }

    public int readQuantidade(){
        System.out.println("Digite a quantidade de equipamentos: ");
        int quantidade = exceptionUser.hasInt();
        input.nextLine();

        return quantidade;
    }

    public double readPreco(){
        System.out.println("Digite o preço do equipamento: ");
        double preco = input.nextDouble();
        input.nextLine();

        return preco;
    }

    public double readPotencia(){
        System.out.println("Digite a potência do motor elétrico: ");
        double potencia = input.nextDouble();
        input.nextLine();

        return potencia;
    }

    public String readTensao(){
        System.out.println("Digite a tensão do painel de controle: ");

        return input.nextLine();
    }

    public int switchPage(){

        System.out.println("==============================================================");
        System.out.println("                     Sistema de Controle WEG                  ");
        System.out.println("==============================================================\n");
        System.out.println(" 1 - Cadastrar Equipamento                                    ");
        System.out.println(" 2 - Listar todos os equipamentos                             ");
        System.out.println(" 3 - Listar equipamentos por tipo                             ");
        System.out.println(" 4 - Pesquisar equipamentos por código                        ");
        System.out.println(" 5 - Remover equipamentos por código                          ");
        System.out.println(" 6 - Movimentar estoque                                       ");



        int keyType = exceptionUser.hasInt();

        return keyType;
    }

    public int switchType(){

        System.out.println("==============================================================");
        System.out.println("                     Sistema de Controle WEG                  ");
        System.out.println("==============================================================\n");
        System.out.println(" 1 - Motor elétrico            ");
        System.out.println(" 2 - Painel de controle        ");

        int keyType = exceptionUser.hasInt();
        input.nextLine();

        return keyType;
    }

    public void encontrado(){
        System.out.println("Equipamento encontrado!");
    }

    public void naoEncontrado(){
        System.out.println("Equipamento não encontrado!");
        System.out.println("Procure por outro que exista.");
    }

    public int switchOperationEstoque(){
        System.out.println("==============================================================");
        System.out.println("                     Sistema de Controle WEG                  ");
        System.out.println("==============================================================\n");
        System.out.println(" 1 - Adicionar unidades                                       ");
        System.out.println(" 2 - Retirar unidades                                         ");

        int keyOperation = exceptionUser.hasInt();
        input.nextLine();

        return keyOperation;
    }

    public int readAdicao(){
        System.out.println("Digite a quantidade de equipamentos que deseja adicionar: ");
        int quantidade = exceptionUser.hasInt();
        input.nextLine();

        return quantidade;
    }

    public int readSubtracao(){
        System.out.println("Digite a quantidade de equipamentos que deseja retirar: ");
        int quantidade = exceptionUser.hasInt();
        input.nextLine();

        return quantidade;
    }

    public void quantidadeAbaixo(){
        System.out.println("Quantidade resultante abaixo de zero.");
        System.out.println("Retire a quantidade que resulte acima de zero!");
    }

    public void defaultSwitch(){
        System.out.println("Código inválido.");
        System.out.println("Por favor, digite um número correspondente com a legenda.");
    }
}
