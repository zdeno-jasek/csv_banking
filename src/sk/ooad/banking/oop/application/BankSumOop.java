package sk.ooad.banking.oop.application;

import java.util.Collection;

import sk.ooad.banking.oop.domain.*;

public class BankSumOop {
	
	public static void main(String[] args) {
		bankSummary( "csvInput.txt", "csvOutputOOP.txt" );
	}
	
	private static void bankSummary( String inputFileName, String outputFileName ) {
		try ( 	AccountMovementRepository accountMovementRepository = new AccountMovementRepositoryCsv(inputFileName);
				AccountSummaryRepository accountSummaryRepository = new AccountSummaryRepositoryCsv(outputFileName); ) {
		
			Collection<AccountMovement> accountMovements = accountMovementRepository.readAll();
			Collection<AccountSummary> accountSummaries = AccountServices.summaryMovements( accountMovements );
			for (AccountSummary accountSummary : accountSummaries ) {
				accountSummaryRepository.create(accountSummary);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
}
