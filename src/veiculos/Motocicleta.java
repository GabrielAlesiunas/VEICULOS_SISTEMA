package veiculos;

import java.util.Locale; // Adicione esta importação se estiver usando Locale.US

public class Motocicleta extends Automotor {
    private int cilindradas;
    private double torque;

    public Motocicleta(String modelo, int anoFabricacao, String montadora, String cor, double kilometragem,
                       int cilindradas, double torque) {
        super(modelo, anoFabricacao, montadora, cor, kilometragem);
        if (cilindradas <= 0) {
            throw new IllegalArgumentException("A cilindrada deve ser positiva.");
        }
        this.cilindradas = cilindradas;
        this.torque = torque;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        if (cilindradas <= 0) {
            throw new IllegalArgumentException("A cilindrada deve ser positiva.");
        }
        this.cilindradas = cilindradas;
    }

    public double getTorque() {
        return torque;
    }

    public void setTorque(double torque) {
        this.torque = torque;
    }

    @Override
    public String gerarInsert() {
        return String.format(Locale.US,
            "INSERT INTO motocicleta (modelo, ano_fabricacao, montadora, cor, kilometragem, " +
            "cilindradas, torque) VALUES ('%s', %d, '%s', '%s', %.2f, %d, %.2f);",
            escapeString(getModelo()), 
            getAnoFabricacao(), 
            escapeString(getMontadora()), 
            escapeString(getCor()), 
            getKilometragem(),
            cilindradas, 
            torque
        );
    }

    // Método auxiliar para escapar strings e evitar problemas com aspas simples
    private String escapeString(String input) {
        if (input == null) return "";
        return input.replace("'", "''");
    }
}
