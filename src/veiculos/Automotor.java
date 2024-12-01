package veiculos;

public abstract class Automotor {
    private String modelo;
    private int anoFabricacao;
    private String montadora;
    private String cor;
    private double kilometragem;

    public Automotor(String modelo, int anoFabricacao, String montadora, String cor, double kilometragem) {
        if (modelo == null || modelo.isEmpty()) {
            throw new IllegalArgumentException("O modelo é obrigatório.");
        }
        if (anoFabricacao <= 0) {
            throw new IllegalArgumentException("O ano de fabricação deve ser um valor positivo.");
        }
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.montadora = montadora;
        this.cor = cor;
        this.kilometragem = kilometragem;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.isEmpty()) {
            throw new IllegalArgumentException("O modelo é obrigatório.");
        }
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        if (anoFabricacao <= 0) {
            throw new IllegalArgumentException("O ano de fabricação deve ser um valor positivo.");
        }
        this.anoFabricacao = anoFabricacao;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(double kilometragem) {
        this.kilometragem = kilometragem;
    }

    public abstract String gerarInsert();

    @Override
    public String toString() {
        return "Modelo: " + modelo + ", Ano: " + anoFabricacao + ", Montadora: " + montadora +
                ", Cor: " + cor + ", Kilometragem: " + kilometragem;
    }
}
