package sk.ooad.banking.oop.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import sk.ooad.banking.oop.domain.AccountMovement;
import sk.ooad.banking.oop.domain.AccountMovementRepository;

/**
 * Implementation of AccountMovementRepository for reading the objects from CSV-file.
 * <p>
 * The file looks like this:<br>
 * datum,meno,kredit		<br>
 * 18.8.2018,Zdeno,500		<br>
 * 19.8.2018,Peter,50		<br>
 */
final class AccountMovementRepositoryCsv implements AccountMovementRepository {
	private static final String CSV_SEPARATOR = ",";

	private final String filename;
	/**
	 * Reader is used for reading the CSV file. 
	 * It does not exist at the begin. It is created during first read-request,
	 * then it used in every next reading. It has to be closed - see the close method. 
	 */
	private BufferedReader reader;
	
	public AccountMovementRepositoryCsv(String filename) {
		this.filename = filename;
	}

	@Override
	public Collection<AccountMovement> readAll() throws Exception {
		Collection<AccountMovement> result = new ArrayList<>();
		if ( reader == null ) {
			reader = new BufferedReader( new FileReader( filename ) );
			reader.readLine();
			// header can be ignored
		}
		
		String nextLine;
		while ( ( nextLine = reader.readLine() ) != null ) {
			String[] data = nextLine.split( CSV_SEPARATOR );
			result.add( new AccountMovement( data[1], data[0], new BigDecimal( data[2] ) ) );
		}
		return result;
	}

	@Override
	public void close() throws IOException {
		if ( reader != null ) {
			reader.close();
		}
	}


}
