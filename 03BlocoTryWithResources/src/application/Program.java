/* -------------------- packages section -------------------- */
package application;

/* -------------------- imports section -------------------- */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* -------------------- Program class -------------------- */
public class Program {

	/* -------------------- functions section -------------------- */	
	private static FileReader generateIntanceFileReader(String path) throws FileNotFoundException {
		return new FileReader(path);
	}
	
	private static BufferedReader generateBufferedReader(FileReader file_reader) {
		return new BufferedReader(file_reader);
	}
	
	private static void displayMessageIOException(Throwable e) {
		System.out.println("erro: " + e.getMessage());
	}
	
	private static void displayEndOfProgramMessage() {
		System.out.println("-> fim do arquivo");
	}
	
	/* -------------------- main method -------------------- */
	public static void main(String[] args) throws FileNotFoundException {

		String path = "c:\\temp\\in.txt";
		FileReader file_reader = generateIntanceFileReader(path);
		BufferedReader buffered_reader = generateBufferedReader(file_reader);
		
		try (buffered_reader) {	
			String line = buffered_reader.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = buffered_reader.readLine();
			}
		} 
		catch (IOException e) {
			displayMessageIOException(e); 
		}
		finally {			
			displayEndOfProgramMessage();
		}
	}

}
