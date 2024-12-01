package veiculos;

import java.util.Locale;


public class Automovel extends Automotor {
    private int quantidadePassageiros;
    private String tipoFreio;
    private boolean airbag;

    public Automovel(String modelo, int anoFabricacao, String montadora, String cor, double kilometragem,
                     int quantidadePassageiros, String tipoFreio, boolean airbag) {
        super(modelo, anoFabricacao, montadora, cor, kilometragem);
        if (quantidadePassageiros <= 0) {
            throw new IllegalArgumentException("A quantidade de passageiros deve ser positiva.");
        }
        this.quantidadePassageiros = quantidadePassageiros;
        this.tipoFreio = tipoFreio;
        this.airbag = airbag;
    }

    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    public void setQuantidadePassageiros(int quantidadePassageiros) {
        if (quantidadePassageiros <= 0) {
            throw new IllegalArgumentException("A quantidade de passageiros deve ser positiva.");
        }
        this.quantidadePassageiros = quantidadePassageiros;
    }

    public String getTipoFreio() {
        return tipoFreio;
    }

    public void setTipoFreio(String tipoFreio) {
        this.tipoFreio = tipoFreio;
    }

    public boolean isAirbag() {
        return airbag;
    }

    public void setAirbag(boolean airbag) {
        this.airbag = airbag;
    }

    @Override
    public String gerarInsert() {
        return String.format(Locale.US, 
            "INSERT INTO automovel (modelo, ano_fabricacao, montadora, cor, kilometragem, quantidade_passageiros, tipo_freio, airbag) " +
            "VALUES ('%s', %d, '%s', '%s', %.2f, %d, '%s', %d);",
            escapeString(getModelo()), 
            getAnoFabricacao(), 
            escapeString(getMontadora()), 
            escapeString(getCor()), 
            getKilometragem(),
            quantidadePassageiros, 
            escapeString(tipoFreio), 
            airbag ? 1 : 0
        );
    }

    // Método auxiliar para escapar strings e evitar problemas com aspas simples
    private String escapeString(String input) {
        if (input == null) return "";
        return input.replace("'", "''");
    }
}
