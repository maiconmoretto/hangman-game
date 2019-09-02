package testes;

import java.util.Scanner;

public class JogoDaForca {

	public static void main(String[] args) {
		String palavra = "casa";
		int totalTentativas = palavra.length();
		int acertos = 0;
		String palavraFormada = palavra;
		int ultimoIndex = -1;
		String[] letraDescobertas = new String[palavra.length()];
		
		System.out.println("*** Jogo da forca ***");
		System.out.println("Dica: tem " + palavra.length() + " letras");
		for(int i = 1; i <= palavra.length(); i++) {
			if (acertos >= totalTentativas) {
				 break;
			}
		 	System.out.println("\nDigite uma letra:");
			Scanner input = new Scanner(System.in);
			String letra = input.next();
			
			int index = palavra.indexOf(letra);
			while (index >= 0) {
				letraDescobertas[index] = letra;
				acertos++;
				palavraFormada = palavra.substring(index, (index + 1));
				index = palavra.indexOf(letra, index + 1);
			}
			
			if (palavra.indexOf(letra) >= 0) {				
				System.out.println("existe a letra " + letra + " na palavra ");
			} else {
				System.out.println("não existe a letra '" + letra + "' na palavra ");
			}
			
			System.out.println("palavra descoberta até o momento... ");
			for(String letraDescoberta: letraDescobertas) {
				if (letraDescoberta == null) {
					System.out.print("_");
				} else {
					System.out.print(letraDescoberta);
				}
			}
			System.out.println("\ntentativa(s) restante(s) " + (totalTentativas - i));
		}

		if (acertos >= totalTentativas) {
			System.out.println("você ganhou!");
			System.out.println("a palavra é= " + palavra);		
		} else {
			System.out.println("você perdeu =(");
		}
		
		
		System.out.println("\n*** Jogo da forca ***");
	}

}
