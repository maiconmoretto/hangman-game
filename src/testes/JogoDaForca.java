package testes;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JogoDaForca {

	public static void main(String[] args) throws ParserConfigurationException {
		
		File file = new File("C:\\Users\\Maicon Moretto\\eclipse-workspace\\testJava\\src\\testJava\\hangman.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
		        .newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		try {
			Document document = documentBuilder.parse(file);
			int numeroPalavrasXML = document.getElementsByTagName("word").getLength();
						
			for (int m = 0; m <= numeroPalavrasXML; m++) {
				String words = document.getElementsByTagName("word").item(m).getTextContent();
				String palavra = document.getElementsByTagName("word").item(m).getTextContent();
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
						System.out.println("existe a letra " + letra + " na palavra");
					} else {
						System.out.println("não existe a letra '" + letra + "' na palavra");
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
							
				System.out.println("\n*** Jogo da forca ***\n\n\n\n");
			}
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
