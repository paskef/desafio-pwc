package desafio;

// Importa classes
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Lógica {

    /**
     * Processa o endereço fornecido, separando o nome da rua e o número.
     * @param endereco String contendo informações do endereço concatenado
     * @return Array de String com duas posições: nome da rua e número
     */
    public String[] processarEndereco(String endereco) {
        String[] resultado = new String[2];

        // Remove vírgulas da string
        endereco = endereco.replace(",", "");

        // Verifica se a string está vazia, caso esteja, fornece uma mensagem de erro
        if (endereco.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, forneça um endereço válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return resultado;
        }

        // Verifica se a string contém "No"
        if (endereco.contains("No")) {
            // Divide a string em duas partes usando "No" como delimitador
            String[] partes = endereco.split("No");
            resultado[0] = partes[0].trim(); // Nome da rua
            resultado[1] = "No " + partes[1].trim(); // Número da rua
            return resultado;
        } else {
            try {
                // Padrões de expressões regulares
                String avPattern = "^(.*?)(?:(?:\\s*No\\s*\\d+)|(?:\\s*[bB]\\b)|$)";
                String numberPattern = "(No\\s*\\d+|\\d+\\s?\\w?\\b)";

                // Compilar padrões
                Pattern patternAv = Pattern.compile(avPattern);
                Pattern patternNumber = Pattern.compile(numberPattern);

                // Procurar correspondências e adicionar à lista de endereços
                Matcher matcherAv = patternAv.matcher(endereco);
                Matcher matcherNumber = patternNumber.matcher(endereco);

                // Busca pelo nome da rua
                if (matcherAv.find()) {
                    resultado[0] = matcherAv.group(1).trim(); 
                } else {
                    // Exibir mensagem se não for possível encontrar o nome da rua
                    JOptionPane.showMessageDialog(null, "Não foi possível encontrar o nome da rua.");
                    resultado[0] = "";
                }

                // Busca pelo número da rua
                if (matcherNumber.find()) {
                    resultado[1] = matcherNumber.group().trim();
                } else {
                    // Exibir mensagem se não for possível encontrar o número da rua
                    JOptionPane.showMessageDialog(null, "Não foi possível encontrar o número da rua.");
                    resultado[1] = "";
                }
            } catch (Exception e) {
                // Lidar com outras exceções
                System.err.println("Erro ao processar endereço: " + e.getMessage());
            }
        }

        // Ajusta as expressões.
        resultado[0] = resultado[0].replaceAll("\\d+\\s?\\w?\\b,?\\s?", "").trim();

        return resultado;
    }
}
