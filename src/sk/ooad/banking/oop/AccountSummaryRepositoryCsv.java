package sk.ooad.banking.oop;

import java.io.FileWriter;
import java.io.IOException;

final class AccountSummaryRepositoryCsv implements AccountSummaryRepository {
	private static final String CSV_SEPARATOR = ",";
	private static final String FILE_HEADER = "meno,suma_kreditov";

	private final String filename;
	private FileWriter fileWriter;
	
	public AccountSummaryRepositoryCsv(String filename) {
		this.filename = filename;
		this.fileWriter = null;
	}

	@Override
	public void create(AccountSummary accountSummary) throws Exception {
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
