package sk.ooad.banking.oop.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Class provides domain services for Account.
 */
public final class AccountServices {
	
	/**
	 * Reads collection of account movements and creates a collection of account summaries.
	 * This is a pure function. 
	 * 
	 * @param movements Account movement - contains the name of account and ammount of money
	 * @return	Account summary - account and a sum of money for it
	 */
	public static Collection<AccountSummary> summaryMovements( Collection<AccountMovement> movements ) {
		// Can you implement this function as a lambda expression?
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

	private AccountServices() {
		// no instances allowed
	}

}
