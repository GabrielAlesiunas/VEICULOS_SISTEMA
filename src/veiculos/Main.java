package veiculos;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection conexao = Conexao.getConexao()) {
            if (conexao != null) {
                // Criar instâncias de veículos
                Automovel carro = new Automovel("Gol Quadrado", 1992, "Volkswagem", "Prata", 15000, 5, "ABS", true);
                Motocicleta moto = new Motocicleta("XJ6", 2012, "Yamaha", "Branca", 3000, 600, 77.0);
                Caminhao caminhao = new Caminhao("Volvo FH", 2025, "Volvo", "Preto", 0, 3, 35500.0);
                Bicicleta bicicleta = new Bicicleta("Caloi", 2023, "Caloi", "Azul", 0, "Giant", "Alumínio", 21, true);
                Skate skate = new Skate("SkaterPro", 2023, "X-Games", "Verde", 0, "X-Games", "Duplas");

                // Exibir os detalhes dos objetos no console
                System.out.println("Detalhes do carro: " + carro);
                System.out.println("Detalhes da motocicleta: " + moto);
                System.out.println("Detalhes do caminhão: " + caminhao);
                System.out.println("Detalhes da bicicleta: " + bicicleta);
                System.out.println("Detalhes do skate: " + skate);

                // Executar os inserts no banco de dados
                conexao.createStatement().executeUpdate(carro.gerarInsert());
                conexao.createStatement().executeUpdate(moto.gerarInsert());
                conexao.createStatement().executeUpdate(caminhao.gerarInsert());
                conexao.createStatement().executeUpdate(bicicleta.gerarInsert());
                conexao.createStatement().executeUpdate(skate.gerarInsert());

                System.out.println("Dados inseridos com sucesso.");

                // Exibir os valores inseridos no console após a inserção
                System.out.println("\nValores inseridos:");
                System.out.println(carro);
                System.out.println(moto);
                System.out.println(caminhao);
                System.out.println(bicicleta);
                System.out.println(skate);
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar o programa: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
