package sk.ooad.banking.oop.application;

import java.io.FileWriter;
import java.io.IOException;

import sk.ooad.banking.oop.domain.AccountSummary;
import sk.ooad.banking.oop.domain.AccountSummaryRepository;

/**
 * Implementation of AccountSummaryRepository for writing the objects to CSV-file.
 * <p>
 * The file looks like this:<br>
 * meno,suma_kreditov		<br>
 * Peter,70					<br>
 * Zdeno,1100				<br>
 */
final class AccountSummaryRepositoryCsv implements AccountSummaryRepository {
	private static final String CSV_SEPARATOR = ",";
	private static final String FILE_HEADER = "meno,suma_kreditov";

	private final String filename;
	/**
	 * Writer is used for writing to the CSV file. 
	 * It does not exist at the begin. It is created during first write-request,
	 * then it used in every next writing. It has to be closed - see the close method. 
	 */
	private FileWriter fileWriter;
	
	public AccountSummaryRepositoryCsv(String filename) {
		this.filename = filename;
		this.fileWriter = null;	// just to be explicit
	}

	@Override
	public void create(AccountSummary accountSummary) throws Exception {
		// right exception handling is missing
		if ( fileWriter == null ) {
			fileWriter = new FileWriter(filename);
			fileWriter.write( FILE_HEADER );
			fileWriter.write( System.lineSeparator() );
		}
		fileWriter.write( accountSummary.getAccount() );
		fileWriter.write( CSV_SEPARATOR );
		fileWriter.write( accountSummary.getSummary().toString() );
		fileWriter.write( System.lineSeparator() );
	}

	@Override
	public void close() throws IOException {
		if ( fileWriter != null ) {
			fileWriter.close();
		}
	}

}
