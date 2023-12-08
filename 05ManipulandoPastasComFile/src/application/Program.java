/* -------------------- packages section -------------------- */
package application;

/* -------------------- imports section -------------------- */
import java.io.File;
import java.util.Scanner;

/* -------------------- Program class -------------------- */
public class Program {

	/* -------------------- functions section -------------------- */	
	private static Scanner generateInstanceScanner() {
		return new Scanner(System.in);
	}
	
	private static String requestPathString(Scanner scanner) {
		 String path_string = scanner.nextLine();
		 return path_string;
	}
	
	private static File generateInstanceFile(String path_string) {
		return new File(path_string);
	}
	
	private static String requestDirectoryName(Scanner scanner) {
		String directory_name  = scanner.nextLine();
		 return "\\"+ directory_name;
	}
	
	private static void displayData(File[] vector) {
		if(vector != null) {
			for (File item : vector) {
				System.out.println(item);
			}
		}
	}
	
	private static void displayEndOfProgramMessage() {
		System.out.println("\n-> fim do arquivo");
	}
	
	/* -------------------- main method -------------------- */
	public static void main(String[] args) {
		
		Scanner scanner = generateInstanceScanner();
		
		System.out.print("\nDigite um caminho para listar diretórios e/ou arquivos [c:\\nome_do_diretorio]: ");
		String path_string = requestPathString(scanner);
		
		File path = generateInstanceFile(path_string);
		File[] files = path.listFiles(File::isFile); // list the files that exist from the path
		File[] folders = path.listFiles(File::isDirectory); // list the directories that exist from the path
		
		System.out.println("\nFolders");		
		displayData(folders);

		System.out.println("\nFiles");		
		displayData(files);

		System.out.print("\nDigite o nome do subdiretório a ser criado: ");
		String directory_name = requestDirectoryName(scanner);
		
		boolean success = new File(path_string.concat(directory_name)).mkdir(); // creates a sub directory from path
		System.out.println("Diretório criado com sucesso? " + success);
		
		if(success) {
			files = path.listFiles(File::isFile); // list the files that exist from the path		
			
			System.out.println("\nFolders");		
			displayData(folders);
	
			System.out.println("\nFiles");		
			displayData(files);		
		}
		else {
			System.out.printf("Subdiretório '%s' já existe %n", directory_name);
		}
		
		scanner.close();
		displayEndOfProgramMessage();
	}

}
