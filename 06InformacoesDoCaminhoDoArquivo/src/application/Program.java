/* -------------------- packages section -------------------- */
package application;

import java.io.File;
import java.util.Scanner;

/* -------------------- imports section -------------------- */

/* -------------------- Program class -------------------- */
public class Program {

	/* -------------------- functions section -------------------- */
	private static Scanner generateInstanceScanner() {
		return new Scanner(System.in);
	}
	
	private static String requestPath(Scanner scanner) {
		String path_string = scanner.nextLine();
		return path_string;
	}
	
	private static File generateInstanceFile(String path_string) {
		return new File(path_string);
	}
	
	private static void displayData(File path_file) {
		System.out.printf("Nome do arquivo: %s%n", path_file.getName());
		System.out.printf("Caminho do arquivo digitado: %s%n", path_file.getParent());
		System.out.printf("Caminho completo do arquivo digitado: %s%n", path_file.getPath());
	}
	
	private static void displayEndOfProgramMessage() {
		System.out.println("\n-> fim do arquivo");
	}
	
	/* -------------------- main method -------------------- */
	public static void main(String[] args) {
		
		Scanner scanner = generateInstanceScanner();
		
		System.out.print("\nDigite o caminho do arquivo: ");
		String path_string = requestPath(scanner);
		
		File path_file = generateInstanceFile(path_string);
		
		displayData(path_file);
		
		scanner.close();

		displayEndOfProgramMessage();
	}

}
