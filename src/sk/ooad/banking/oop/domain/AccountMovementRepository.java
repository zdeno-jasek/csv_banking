package sk.ooad.banking.oop.domain;

import java.io.Closeable;
import java.util.Collection;

/**
 * Repository is responsible for providing an access to AccountMovement objects.
 */
public interface AccountMovementRepository extends Closeable {

	/**
	 * @return All data about account movements from repository.
	 * @throws Exception If the data cannot be read (a source does not exists).
	 */
	Collection<AccountMovement> readAll() throws Exception;
}
