package veiculos;

import java.util.Locale; // Para usar Locale.US

public class Caminhao extends Automotor {
    private int quantidadeEixos;
    private double pesoBruto;

    public Caminhao(String modelo, int anoFabricacao, String montadora, String cor, double kilometragem,
                    int quantidadeEixos, double pesoBruto) {
        super(modelo, anoFabricacao, montadora, cor, kilometragem);
        if (quantidadeEixos <= 0) {
            throw new IllegalArgumentException("A quantidade de eixos deve ser positiva.");
        }
        if (pesoBruto <= 0) {
            throw new IllegalArgumentException("O peso bruto deve ser positivo.");
        }
        this.quantidadeEixos = quantidadeEixos;
        this.pesoBruto = pesoBruto;
    }

    public int getQuantidadeEixos() {
        return quantidadeEixos;
    }

    public void setQuantidadeEixos(int quantidadeEixos) {
        if (quantidadeEixos <= 0) {
            throw new IllegalArgumentException("A quantidade de eixos deve ser positiva.");
        }
        this.quantidadeEixos = quantidadeEixos;
    }

    public double getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(double pesoBruto) {
        if (pesoBruto <= 0) {
            throw new IllegalArgumentException("O peso bruto deve ser positivo.");
        }
        this.pesoBruto = pesoBruto;
    }

    @Override
    public String gerarInsert() {
        return String.format(Locale.US,
            "INSERT INTO caminhao (modelo, ano_fabricacao, montadora, cor, kilometragem, " +
            "quantidade_eixos, peso_bruto) VALUES ('%s', %d, '%s', '%s', %.2f, %d, %.2f);",
            escapeString(getModelo()), 
            getAnoFabricacao(), 
            escapeString(getMontadora()), 
            escapeString(getCor()), 
            getKilometragem(),
            quantidadeEixos, 
            pesoBruto
        );
    }

    // Método auxiliar para escapar strings e evitar problemas com aspas simples
    private String escapeString(String input) {
        if (input == null) return "";
        return input.replace("'", "''");
    }
}
