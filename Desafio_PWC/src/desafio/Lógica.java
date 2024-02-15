package desafio;

// Importa classes

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lógica {

    public static String[] processarEndereco(String endereco) {
        String[] resultado = new String[2];

        // Verifica se a string contém "No"
        if (endereco.contains("No")) {
            // Divide a string em duas partes usando "No" como delimitador
            String[] partes = endereco.split("No");
            resultado[0] = partes[0].trim(); // Nome da rua
            resultado[1] = "No " + partes[1].trim(); // Número da rua
            
            return resultado;
        } else {
        	
        // Padrões de expressões regulares
        String avPattern = "^(.*?)(?:(?:\\s*No\\s*\\d+)|(?:\\s*[bB]\\b)|$)";
        String numberPattern = "(No\\s*\\d+|\\d+\\s?\\w?\\b)";

        // Compilar padrões
        Pattern patternAv = Pattern.compile(avPattern);
        Pattern patternNumber = Pattern.compile(numberPattern);

        // Procurar correspondências e adicionar à lista de endereços
        Matcher matcherAv = patternAv.matcher(endereco);
        Matcher matcherNumber = patternNumber.matcher(endereco);

        if (matcherAv.find()) {
            resultado[0] = matcherAv.group(1).trim();
        } else {
            resultado[0] = "";
        }

        if (matcherNumber.find()) {
            resultado[1] = matcherNumber.group().trim();
        } else {
            resultado[1] = "";
        }
        }

        // Remover vírgulas
        resultado[0] = resultado[0].replaceAll("\\d+\\s?\\w?\\b,?\\s?", "").trim();

        return resultado;
    }
}



