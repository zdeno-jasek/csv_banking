package sk.ooad.banking.oop.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class AccountServicesTest {

	@Test
	void summaryMovementAddAllSummariesForSameAccount() {
		AccountMovement ac1 = new AccountMovement( "Zdeno", "18.8.2018", BigDecimal.TEN );
		AccountMovement ac2 = new AccountMovement( "Zdeno", "21.8.2018", BigDecimal.ONE );
		Collection<AccountMovement> allMovements = Arrays.asList( ac1, ac2 );
		
		Collection<AccountSummary> summary = AccountServices.summaryMovements(allMovements);
		
		assertEquals( 1, summary.size() );
		assertEquals( 11, summary.iterator().next().getSummary().longValue() );
		
	}

	@Test
	void summaryMovementDoesntSumTwoDifferentAccounts() {
		AccountMovement ac1 = new AccountMovement( "Zdeno", "18.8.2018", BigDecimal.TEN );
		AccountMovement ac2 = new AccountMovement( "Peter", "21.8.2018", BigDecimal.ONE );
		Collection<AccountMovement> allMovements = Arrays.asList( ac1, ac2 );
		
		Collection<AccountSummary> summary = AccountServices.summaryMovements(allMovements);
		
		assertEquals( 2, summary.size() );
		assertTrue( summary.stream().anyMatch( sum -> sum.getSummary() == BigDecimal.TEN ));
		assertTrue( summary.stream().anyMatch( sum -> sum.getSummary() == BigDecimal.ONE ));
	}

	@Test
	void summaryMovementWorksWithEmptyCollection() {
		Collection<AccountMovement> allMovements = Collections.emptyList();
		
		Collection<AccountSummary> summary = AccountServices.summaryMovements(allMovements);
		
		assertEquals( 0, summary.size() );
	}

}
