package veiculos;

import java.util.Locale; // Para usar Locale.US

public class Bicicleta extends Automotor {
    private String marca;
    private String material;
    private int quantidadeMarchas;
    private boolean amortecedor;

    public Bicicleta(String modelo, int anoFabricacao, String montadora, String cor, double kilometragem,
                     String marca, String material, int quantidadeMarchas, boolean amortecedor) {
        super(modelo, anoFabricacao, montadora, cor, kilometragem);
        if (quantidadeMarchas <= 0) {
            throw new IllegalArgumentException("A quantidade de marchas deve ser positiva.");
        }
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("A marca não pode ser nula ou vazia.");
        }
        if (material == null || material.isEmpty()) {
            throw new IllegalArgumentException("O material não pode ser nulo ou vazio.");
        }
        this.marca = marca;
        this.material = material;
        this.quantidadeMarchas = quantidadeMarchas;
        this.amortecedor = amortecedor;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material == null || material.isEmpty()) {
            throw new IllegalArgumentException("O material não pode ser nulo ou vazio.");
        }
        this.material = material;
    }

    public int getQuantidadeMarchas() {
        return quantidadeMarchas;
    }

    public void setQuantidadeMarchas(int quantidadeMarchas) {
        if (quantidadeMarchas <= 0) {
            throw new IllegalArgumentException("A quantidade de marchas deve ser positiva.");
        }
        this.quantidadeMarchas = quantidadeMarchas;
    }

    public boolean isAmortecedor() {
        return amortecedor;
    }

    public void setAmortecedor(boolean amortecedor) {
        this.amortecedor = amortecedor;
    }

    @Override
    public String gerarInsert() {
        return String.format(Locale.US,
            "INSERT INTO bicicleta (modelo, ano_fabricacao, montadora, cor, kilometragem, " +
            "marca, material, quantidade_marchas, amortecedor) VALUES ('%s', %d, '%s', '%s', %.2f, '%s', '%s', %d, %b);",
            escapeString(getModelo()), 
            getAnoFabricacao(), 
            escapeString(getMontadora()), 
            escapeString(getCor()), 
            getKilometragem(),
            escapeString(marca), 
            escapeString(material), 
            quantidadeMarchas, 
            amortecedor
        );
    }

    // Método auxiliar para escapar strings e evitar problemas com aspas simples
    private String escapeString(String input) {
        if (input == null) return "";
        return input.replace("'", "''");
    }
}
