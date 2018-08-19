package sk.ooad.banking.oop;

import java.math.BigDecimal;

public final class AccountSummary {
	private final String account;
	private BigDecimal summary;

	public AccountSummary( AccountMovement movement ) {
		this.account = movement.getName();
		this.summary = movement.getAmount();
	}
	
	public void add(AccountMovement accountMovement) {
		this.summary = this.summary.add( accountMovement.getAmount() );
	}
	
	public String getAccount() { return account;	}
	public BigDecimal getSummary() { return summary;	}
}
