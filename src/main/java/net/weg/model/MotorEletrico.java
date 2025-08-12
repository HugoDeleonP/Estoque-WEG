package net.weg.model;

public class MotorEletrico extends Equipamento{

    private double potencia;

    public MotorEletrico(String codigo, String nome, int quantidade, double preco, double potencia){
        super(codigo, nome, quantidade, preco);
        this.potencia = potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getPotencia() {
        return potencia;
    }

    @Override
    public String toString() {
        return
                "==============================================================\n" +
                "                     Catálogo de equipamentos                 \n" +
                "==============================================================\n" +
                "Código: " + codigo + "\n" +
                "Nome: " + nome + "\n" +
                "Quantidade: " + quantidade + "\n" +
                "Preço: " + preco + "\n" +
                "Potência: " + potencia + "\n";

    }
}
