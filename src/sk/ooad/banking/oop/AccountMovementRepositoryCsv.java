package sk.ooad.banking.oop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

final class AccountMovementRepositoryCsv implements AccountMovementRepository {
	private static final String CSV_SEPARATOR = ",";

	private final String filename;
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
