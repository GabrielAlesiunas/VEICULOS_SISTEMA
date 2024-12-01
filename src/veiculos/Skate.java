package veiculos;

import java.util.Locale; // Para usar Locale.US

public class Skate extends Automotor {
    private String marca;
    private String tipoRodas;

    public Skate(String modelo, int anoFabricacao, String montadora, String cor, double kilometragem,
                 String marca, String tipoRodas) {
        super(modelo, anoFabricacao, montadora, cor, kilometragem);

        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("A marca não pode ser nula ou vazia.");
        }
        if (tipoRodas == null || tipoRodas.isEmpty()) {
            throw new IllegalArgumentException("O tipo de rodas não pode ser nulo ou vazio.");
        }

        this.marca = marca;
        this.tipoRodas = tipoRodas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("A marca não pode ser nula ou vazia.");
        }
        this.marca = marca;
    }

    public String getTipoRodas() {
        return tipoRodas;
    }

    public void setTipoRodas(String tipoRodas) {
        if (tipoRodas == null || tipoRodas.isEmpty()) {
            throw new IllegalArgumentException("O tipo de rodas não pode ser nulo ou vazio.");
        }
        this.tipoRodas = tipoRodas;
    }

    @Override
    public String gerarInsert() {
        return String.format(Locale.US,
            "INSERT INTO skate (modelo, ano_fabricacao, montadora, cor, kilometragem, " +
            "marca, tipo_rodas) VALUES ('%s', %d, '%s', '%s', %.2f, '%s', '%s');",
            escapeString(getModelo()), 
            getAnoFabricacao(), 
            escapeString(getMontadora()), 
            escapeString(getCor()), 
            getKilometragem(),
            escapeString(marca), 
            escapeString(tipoRodas)
        );
    }

    // Método auxiliar para escapar strings e evitar problemas com aspas simples
    private String escapeString(String input) {
        if (input == null) return "";
        return input.replace("'", "''");
    }
}
