/* -------------------- packages section -------------------- */
package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/* -------------------- Program class -------------------- */
public class Program {

	/* -------------------- functions section -------------------- */	
	private static String[] generateInstanceOfFilledStringVector() {
		return new String[] {"Bom dia", "Boa tarde", "Boa noite"};
	}
	
	private static FileWriter generateIntanceFileWriter(String path, boolean do_not_recreate_file) throws IOException {
		return new FileWriter(path, do_not_recreate_file);
	}
	
	private static BufferedWriter generateBufferedWriter(FileWriter file_writer) {
		return new BufferedWriter(file_writer);
	}
	
	private static void displayMessageIOException(Throwable e) {
		e.printStackTrace();
	}
	
	private static void displayEndOfProgramMessage() {
		System.out.println("-> fim do arquivo");
	}
	
	/* -------------------- main method -------------------- */
	public static void main(String[] args) throws IOException {

		String[] lines = generateInstanceOfFilledStringVector();
		String path = "c:\\temp\\out.txt";
		boolean do_not_recreate_file = true;
		FileWriter file_writer = generateIntanceFileWriter(path, do_not_recreate_file);
		BufferedWriter buffered_writer = generateBufferedWriter(file_writer);
		
		try (buffered_writer) {
			for (String line : lines) {
				buffered_writer.write(line);
				buffered_writer.newLine(); // line break
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
