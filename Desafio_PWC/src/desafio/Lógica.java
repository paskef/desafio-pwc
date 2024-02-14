package desafio;

// Importa a biblioteca de Arrays.

import java.util.Arrays; 

public class Lógica {

	    public String[] processarEndereco(String endereco) {
	        String[] resultado = new String[2]; // Array para armazenar a rua e o número da rua.

	        // Divisão da string de endereço em palavras utilizando split.
	        String[] partes = endereco.split(" ");

	        // O último elemento deve ser o número da rua.
	        resultado[1] = partes[partes.length - 1];

	        // A rua é formada pelas partes restantes.
	        resultado[0] = String.join(" ", Arrays.copyOfRange(partes, 0, partes.length - 1));

	        return resultado;
	        
	        //TODO: Casos mais complexos.
	        
	    }
	}

