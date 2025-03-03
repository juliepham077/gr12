package unit2;
/*
 * Julie Pham
 * Sept 14, 2023
 * Sort and merge files
 */
import java.io.*;
import java.util.*;
public class Code3JuliePham {
static int[] file1Num, file2Num, file3Num;
	public static void main(String[] args) {
		//Create Files
		File textFile1 = new File("file1.txt");
		File textFile2 = new File("file2.txt");
		File textFile3 = new File("file2.txt");
		//Collect file names
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the name of the first file: ");
		String file1 = input.nextLine();
		System.out.print("Enter the name of the second file: ");
		String file2 = input.nextLine();
		String file3 = "file3.txt";
		readFiles(file1, file2, file3); //read files
		input.close();
	}
		static void readFiles(String file1, String file2, String file3) {
			FileReader fin1, fin2, fin3;
			BufferedReader reader1, reader2, reader3;
			FileWriter out;
			BufferedWriter writer;
			
			try {
				fin1 = new FileReader(file1);
				fin2 = new FileReader(file2);
				fin3 = new FileReader(file3);
				reader1 = new BufferedReader(fin1);
				reader2 = new BufferedReader(fin2);
				reader3 = new BufferedReader(fin3);
				out = new FileWriter(file3);
				writer = new BufferedWriter(out);
				
				int numLine1 = 0, numLine2 = 0;
				
				//Determine the number of data/lines in text file and store in array
				String line;
				while ((line = reader1.readLine()) != null) {
					file1Num[numLine1] = Integer.parseInt(line);
					numLine1++;
				}
				while ((line = reader2.readLine()) != null) {
					file2Num[numLine2] = Integer.parseInt(line);
					numLine2++;
				}
				sortFiles(numLine1, numLine2);
				
				System.out.print("File 1: ");
				while (reader1.readLine() != null) {
					System.out.print(reader1 + " ");
				}
				System.out.print("File 2: ");
				while (reader2.readLine() != null) {
					System.out.print(reader2 + " ");
				}
				
				 // Copy content from the first file
			    while ((line = reader1.readLine()) != null) {
			    	writer.write(line);
	                writer.newLine();
			    }
			
			       // Copy content from the second file
			    while ((line = reader2.readLine()) != null) {
			    	writer.write(line);
	                writer.newLine();
			    }
			    int numLine3 = numLine1 + numLine2;
			    while ((line = reader3.readLine()) != null) {
					file3Num[numLine3] = Integer.parseInt(line);
				}
			    sortFile3(numLine3);
			    
			    System.out.print("Merged Data: ");
				while (reader3.readLine() != null) {
					System.out.print(reader3 + " ");
				}
			    
				out.close();
				writer.close();
				reader3.close();
				reader2.close();
				reader1.close();
				fin3.close();
				fin2.close();
				fin1.close();
			} catch (IOException e) {
				System.out.println("File Error: " + e.getMessage());
			}

		}
		static void sortFiles(int numLine1, int numLine2) {
			System.out.println("Sorted Data: ");
			for (int i = 0; i < numLine1; i++) {
				for (int subI = i; subI < numLine1; subI++){
					if (file1Num[subI] < file1Num[i]) {
						int tempNum = file1Num[i];
						file1Num[i] = file1Num[subI];
						file1Num[subI] = tempNum;
					}
				}
			}
			for (int i = 0; i < numLine2; i++) {
				for (int subI = i; subI < numLine2; subI++){
					if (file2Num[subI] < file2Num[i]) {
						int tempNum = file2Num[i];
						file2Num[i] = file2Num[subI];
						file2Num[subI] = tempNum;
					}
				}
			}
		}
		static void sortFile3(int numLine3) {
			for (int i = 0; i < numLine3; i++) {
				for (int subI = i; subI < numLine3; subI++){
					if (file3Num[subI] < file3Num[i]) {
						int tempNum = file3Num[i];
						file3Num[i] = file3Num[subI];
						file3Num[subI] = tempNum;
					}
				}
			}
		}
}