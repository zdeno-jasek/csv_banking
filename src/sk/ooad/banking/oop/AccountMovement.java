package sk.ooad.banking.oop;

import java.math.BigDecimal;

public final class AccountMovement {
	
	private final String name;
	private final String date;
	private final BigDecimal amount;
	
	public AccountMovement(String name, String date, BigDecimal amount) {
		this.name = name;
		this.date = date;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	
}
