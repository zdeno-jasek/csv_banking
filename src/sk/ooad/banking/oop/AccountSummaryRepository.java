package sk.ooad.banking.oop;

import java.io.Closeable;
import java.io.IOException;

public interface AccountSummaryRepository extends Closeable {

	void create( AccountSummary accountSummary ) throws Exception;
}
