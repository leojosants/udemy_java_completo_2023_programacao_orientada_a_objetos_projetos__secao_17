/* -------------------- packages section -------------------- */
package application;

/* -------------------- imports section -------------------- */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Product;

/* -------------------- Program class -------------------- */
public class Program {

	/* -------------------- functions section -------------------- */
	private static Scanner generateInstanceScanner() {
		return new Scanner(System.in);
	}

	private static List<Product> generateInstanceListProduct() {
		List<Product> list = new ArrayList<>();
		return list;
	}

	private static String requestSourceFile(Scanner scanner) {
		String source_file = null;
		source_file = scanner.nextLine();

		while (source_file.isEmpty()) {
			System.out.print("-> campo não pode ser vazio, tente novamente! Entre com o caminho do arquivo ..: ");
			source_file = scanner.nextLine();
		}

		return source_file;
	}

	private static File generateInstanceFile(String path) {
		return new File(path);
	}

	private static boolean createSubdirectory(String folder_name) {
		boolean success = new File(folder_name + "\\out").mkdir();
		return success;
	}

	private static String returnTargetFileString(String source_folder) {
		String target_file = source_folder + "\\out\\summary.csv";
		return target_file;
	}

	private static FileReader generateInstanceFileReader(File source_file) throws FileNotFoundException {
		return new FileReader(source_file);
	}
	
	private static Product generateInstanceProduct(String name, double price, int quantity) {
		return new Product(name, price, quantity);
	}

	private static FileWriter generateInstanceFileWriter(String target_file) throws IOException {
		return new FileWriter(target_file);
	}

	private static void displayData(String target_file) {
		System.out.printf("Dados salvos, verifique em: %s%n", target_file);
	}

	private static void displayMessageIOException(Throwable e, String read_or_write) {
		if (read_or_write == "read") {
			System.out.println("Error reading file: " + e.getMessage());
		} 
		else if (read_or_write == "write") {
			System.out.println("Error writing file: " + e.getMessage());
		}
	}
	
	private static void displayEndMessage() {
		System.out.println("--- fim do programa ---");
	}

	/* -------------------- main method -------------------- */
	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner scanner = generateInstanceScanner();
		List<Product> products_list = generateInstanceListProduct();

		System.out.print("\nEntre com o caminho do arquivo [c:\\...\\...]: ");
		String source_file_string = requestSourceFile(scanner);

		File source_file = generateInstanceFile(source_file_string);
		String source_folder_string = source_file.getParent();

		boolean success = createSubdirectory(source_folder_string);

		String target_file_string = returnTargetFileString(source_folder_string);

		try (BufferedReader buffered_reader = new BufferedReader(generateInstanceFileReader(source_file))) {
			String item_csv = buffered_reader.readLine();

			while (item_csv != null) {
				String[] fields = item_csv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				products_list.add(generateInstanceProduct(name, price, quantity));

				item_csv = buffered_reader.readLine();
			}

			try (BufferedWriter buffered_writer = new BufferedWriter(generateInstanceFileWriter(target_file_string))) {
				for (Product item : products_list) {
					buffered_writer.write(item.getName().concat("," + String.format("%.2f", item.totalValue())));
					buffered_writer.newLine();
				}

				displayData(target_file_string);
			} 
			catch (IOException e) {
				displayMessageIOException(e, "write");
			}
		} 
		catch (IOException e) {
			displayMessageIOException(e, "read");
		}

		scanner.close();
		displayEndMessage();
	}
}