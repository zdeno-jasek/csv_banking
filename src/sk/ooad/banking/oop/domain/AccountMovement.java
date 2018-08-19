package sk.ooad.banking.oop.domain;

import java.math.BigDecimal;

/**
 * Class responsibity: holds data about an account movement.
 */
public final class AccountMovement {
	
	/** Account name. */
	private final String name;
	/** Date, when the movement was proceeded.
	 * There is no special requirement for a date manipulation,
	 * so the date is as a String.
	 */
	private final String date;
	/** Ammount of money in the movement. Cannot be null and cannot be changed. */
	private final BigDecimal amount;
	
	public AccountMovement(String name, String date, BigDecimal amount) {
		this.name = name;
		this.date = date;
		this.amount = amount == null ? BigDecimal.ZERO : amount;		
	}

	public String getName() {
		return name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	
}
