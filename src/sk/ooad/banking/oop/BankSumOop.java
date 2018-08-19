package sk.ooad.banking.oop;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BankSumOop {
	
	public static void main(String[] args) {
		bankSummary( "csvInput.txt", "csvOutputOOP.txt" );
	}
	
private static void bankSummary( String inputFileName, String outputFileName ) {
	try ( 	AccountMovementRepository accountMovementRepository = new AccountMovementRepositoryCsv(inputFileName);
			AccountSummaryRepository accountSummaryRepository = new AccountSummaryRepositoryCsv(outputFileName); ) {
	
		Collection<AccountMovement> accountMovements = accountMovementRepository.readAll();
		Collection<AccountSummary> accountSummaries = summaryMovements( accountMovements );
		for (AccountSummary accountSummary : accountSummaries ) {
			accountSummaryRepository.create(accountSummary);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
private static Collection<AccountSummary> summaryMovements( Collection<AccountMovement> movements ) {
	Map<String, AccountSummary> result = new HashMap<>();
	for (AccountMovement accountMovement : movements) {
		AccountSummary existing = result.get( accountMovement.getName() );
		if ( existing == null ) {
			result.put( accountMovement.getName(), new AccountSummary(accountMovement) );
		} else {
			existing.add( accountMovement );
		}
	}
	return result.values();
}

	/*
	private static Collection<AccountSummary> summaryMovementsFnc( Collection<AccountMovement> movements ) {
		Collector<AccountSummary, ?, ArrayList<AccountSummary>> sumarizacia = Collector.of( 
				new ArrayList<AccountSummary>(), ArrayList::add, (sum1, sum2) -> sum2.forEach( sum2element -> sum1.add( sum2element ) ) );
		
		//Map<String, Optional<AccountSummary>> accountSummaries = movements.stream()
		Collection<AccountSummary> accountSummaries = movements.stream()
				.map( movement -> new AccountSummary(movement) )
				.collect( Collectors.groupingBy( AccountSummary::getAccount ) )
				.entrySet().stream()
				.map( sameAccount -> )
				.get();
		return null;
	}
	*/
	
}
