package sk.ooad.banking.oop;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

public interface AccountMovementRepository extends Closeable {

	Collection<AccountMovement> readAll() throws Exception;
}
