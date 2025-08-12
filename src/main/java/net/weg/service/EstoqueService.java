package net.weg.service;

import net.weg.model.Equipamento;
import net.weg.model.MotorEletrico;
import net.weg.model.PainelControle;
import net.weg.view.InterfaceUsuario;

import java.util.ArrayList;

public class EstoqueService {

    public ArrayList<Equipamento> equipamentos;

    public InterfaceUsuario uiView;

    public EstoqueService(){
        equipamentos = new ArrayList<Equipamento>();
        uiView = new InterfaceUsuario();
    }

    /*

    Cadastrar equipamentos
    Listar todos os equipamentos
    Listar equipamentos filtrando por tipo (MotorEletrico ou PainelControle)
    Pesquisar equipamento pelo código
    Remover equipamento pelo código
    Movimentar o estoque (adicionar ou retirar quantidade)

     */

    public void pageManager(int keyPage){

        switch (keyPage){

            case 1 ->{
                Equipamento equipamento = formerEquipamento();
                int keyType = uiView.switchType();
                Equipamento objectChoose = typeEquipamento(keyType, equipamento);

                equipamentos.add(objectChoose);
            }

            case 2 ->{
                for(Equipamento unitEquipamento: equipamentos){
                    System.out.println(unitEquipamento);
                }
            }

            case 3 ->{
                int keyType = uiView.switchType();

                switch (keyType){

                    case 1 ->{
                        for(Equipamento unitEquipamento: equipamentos){
                            if(unitEquipamento instanceof MotorEletrico){
                                System.out.println(unitEquipamento);
                            }

                        }
                    }

                    case 2 ->{
                        for (Equipamento unitEquipamento: equipamentos){
                            if (unitEquipamento instanceof PainelControle){
                                System.out.println(unitEquipamento);
                            }
                        }
                    }

                    default -> uiView.defaultSwitch();
                }

            }

            case 4 ->{
                boolean encontrado = false;

                String codigo = uiView.readCodigo();
                for (Equipamento unitEquipamento: equipamentos){
                    if (unitEquipamento.getCodigo().equals(codigo)){
                        uiView.encontrado();
                        System.out.println(unitEquipamento);
                        encontrado = true;
                    }

                }

                if(!encontrado){
                    uiView.naoEncontrado();
                }
            }

            case 5 ->{

                boolean encontrado = false;

                String codigo = uiView.readCodigo();
                for (Equipamento unitEquipamento: equipamentos){
                    if (unitEquipamento.getCodigo().equals(codigo)){
                        equipamentos.remove(unitEquipamento);
                        encontrado = true;
                    }

                }

                if(!encontrado){
                    uiView.naoEncontrado();
                }

            }


            case 6 ->{
                int keyOperation = uiView.switchOperationEstoque();
                operationManager(keyOperation);

            }

            default -> uiView.defaultSwitch();

        }

    }

    private Equipamento formerEquipamento(){
        String codigo = uiView.readCodigo();
        String nome = uiView.readNome();
        int quantidade = uiView.readQuantidade();
        double preco = uiView.readPreco();

        return new Equipamento(codigo, nome, quantidade, preco);
    }

    private Equipamento typeEquipamento(int keyType, Equipamento equipamento){

        switch (keyType){

            //motorEletrico

            case 1 ->{
                return formerMotor(equipamento);
            }

            //PainelControle

            case 2 ->{
                return formerPainel(equipamento);
            }

            default -> {
                uiView.defaultSwitch();
                return null;
            }
        }

    }

    private MotorEletrico formerMotor(Equipamento equipamento){

        String codigo = equipamento.getCodigo();
        String nome = equipamento.getNome();
        int quantidade = equipamento.getQuantidade();
        double preco = equipamento.getPreco();

        double potencia = uiView.readPotencia();

        return new MotorEletrico(codigo, nome, quantidade, preco, potencia);
    }

    private PainelControle formerPainel(Equipamento equipamento){

        String codigo = equipamento.getCodigo();
        String nome = equipamento.getNome();
        int quantidade = equipamento.getQuantidade();
        double preco = equipamento.getPreco();

        String tensao = uiView.readTensao();

        return new PainelControle(codigo, nome, quantidade, preco, tensao);
    }

    private void operationManager(int keyOperation){

        switch (keyOperation){

            case 1 ->{
                // o sistema solicita o código do equipamento e a quantidade a movimentar
                String codigo = uiView.readCodigo();
                int unidadesAdicao = uiView.readAdicao();

                boolean encontrado = false;

                for (Equipamento unitEquipamento: equipamentos){
                    if (unitEquipamento.getCodigo().equals(codigo)){

                        int quantidadeModificada = unitEquipamento.getQuantidade() + unidadesAdicao;

                        unitEquipamento.setQuantidade(quantidadeModificada);

                        encontrado = true;
                    }

                }

                if(!encontrado){
                    uiView.naoEncontrado();
                }


            }

            case 2 ->{
                String codigo = uiView.readCodigo();
                int unidadesSubtracao = uiView.readSubtracao();

                boolean encontrado = false;

                for (Equipamento unitEquipamento: equipamentos){
                    if (unitEquipamento.getCodigo().equals(codigo)){

                        int quantidadeModificada = unitEquipamento.getQuantidade() - unidadesSubtracao;

                        if(quantidadeModificada >= 0){
                            unitEquipamento.setQuantidade(quantidadeModificada);
                        }

                        else {
                            uiView.quantidadeAbaixo();
                        }

                        encontrado = true;

                    }

                }

                if(!encontrado){
                    uiView.naoEncontrado();
                }
            }

            default -> uiView.defaultSwitch();
        }
    }

}
