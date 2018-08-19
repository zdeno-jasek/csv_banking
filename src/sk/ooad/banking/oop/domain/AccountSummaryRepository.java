package sk.ooad.banking.oop.domain;

import java.io.Closeable;

/**
 * Repository is responsible for providing an access to AccountSummary objects.
 */
public interface AccountSummaryRepository extends Closeable {

	/**
	 * Write AccountSummary object to repository.
	 * 
	 * @param accountSummary	The object, which should be written to the repository.
	 * @throws Exception		If the write operation is not successful. 
	 */
	void create( AccountSummary accountSummary ) throws Exception;
}
