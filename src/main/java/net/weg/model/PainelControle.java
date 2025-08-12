package net.weg.model;

public class PainelControle extends Equipamento{

    private String tensao;

    public PainelControle(String codigo, String nome, int quantidade, double preco, String tensao){
        super(codigo, nome, quantidade, preco);
        this.tensao = tensao;
    }

    public void setTensao(String tensao) {
        this.tensao = tensao;
    }

    public String getTensao() {
        return tensao;
    }

    @Override
    public String toString(){
        return
                "==============================================================\n" +
                "                     Catálogo de equipamentos                 \n" +
                "==============================================================\n" +
                "Código: " + codigo + "\n" +
                "Nome: " + nome + "\n" +
                "Quantidade: " + quantidade + "\n" +
                "Preço: " + preco + "\n" +
                "Tensão: " + tensao + "\n";
    }

}
