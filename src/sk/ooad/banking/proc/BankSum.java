package sk.ooad.banking.proc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BankSum {
	
	private static final String CSV_SEPARATOR = ",";
	private static final Object FILE_HEADER = "meno,suma_kreditov";
	

	/*
	 * Importuje kredity z CSV suboru v tvare
	 * datum,meno,kredit
	 * 
	 * Na zaklade importu vytvori exportny subor v tvare
	 * meno,suma_kreditov
	 * 
	 * Exportny subor obsahuje nasumovane kredity z importneho suboru
	 */
	public static void main(String[] args) {
		bankSummary( "csvInput.txt", "csvOutput.txt" );
	}
	
private static void bankSummary( String inputFileName, String outputFileName ) {
	Map<String, BigDecimal> summary = new HashMap<>();
	
	try ( BufferedReader reader = new BufferedReader( new FileReader( inputFileName ) ) ) {
		reader.readLine(); // header is ignored
		String nextLine;
		while ( ( nextLine = reader.readLine() ) != null ) {
			String[] data = nextLine.split( CSV_SEPARATOR );
			BigDecimal credit = new BigDecimal( data[2] );
			BigDecimal sum = summary.get( data[1] );
			sum = sum == null ? credit : sum.add(credit);
			summary.put(data[1], sum );
		}
	} catch (Exception e) { e.printStackTrace(); }
	
	 try ( FileWriter fileWriter = new FileWriter(outputFileName) ) {
	 	fileWriter.append(FILE_HEADER.toString());
	 	fileWriter.append( System.lineSeparator() );
	 	for (Map.Entry<String, BigDecimal> entry : summary.entrySet() ) {
			fileWriter.append( entry.getKey() );
			fileWriter.append( CSV_SEPARATOR );
			fileWriter.append( entry.getValue().toString() );
		 	fileWriter.append( System.lineSeparator() );
		}
	 } catch (Exception e) { e.printStackTrace(); }
}

}
