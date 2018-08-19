package sk.ooad.banking.oop.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Class represents a summary for a given account.
 * Responsibility: sum account movements.
 */
public final class AccountSummary {
	private final String account;
	private BigDecimal summary;

	public AccountSummary( AccountMovement movement ) {
		this.account = movement.getName();
		// Does not allow to create an invalid object with summary == null
		this.summary = Objects.requireNonNull( movement.getAmount() );
	}
	
	/**
	 * Add the amount of account movement to the existing summary.
	 * @param accountMovement
	 */
	public void add(AccountMovement accountMovement) {
		this.summary = this.summary.add( accountMovement.getAmount() );
		// The better implementation is to return a new AccountSummary object 
		// (make this class immutable)
	}
	
	public String getAccount() { return account;	}
	public BigDecimal getSummary() { return summary;	}
}
