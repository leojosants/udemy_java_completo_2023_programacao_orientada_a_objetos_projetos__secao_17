/* -------------------- packages section -------------------- */
package application;

/* -------------------- imports section -------------------- */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/* -------------------- Program class -------------------- */
public class Program {

	/* -------------------- functions section -------------------- */
	private static File generateInstanceFile(String path) throws FileNotFoundException {
		return new File(path);
	}
	
	private static Scanner generateInstanceScanner(File file) throws FileNotFoundException {
		return new Scanner(file);
	}
	
	private static void displayMessageIOException(Throwable e) {
		System.out.println("erro: " + e.getMessage());
	}
	
	private static void displayEndOfProgramMessage() {
		System.out.println("-> fim do arquivo");
	}
	
	/* -------------------- main method -------------------- */
	public static void main(String[] args) throws FileNotFoundException {

		File file = generateInstanceFile("c:\\temp\\in.txt");
		Scanner scanner = null;
		
		try {
			scanner = generateInstanceScanner(file);
			
			while(scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		} 
		catch (IOException e) {
			displayMessageIOException(e); 
		}
		finally {
			if(scanner != null) {
				scanner.close();				
			}
			
			displayEndOfProgramMessage();
		}
	}

}
