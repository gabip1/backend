package zti.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

/**
 * The APIs will throw an exception whenever a movie with a given id is not found in the database.
 * @author Gabriela Penarska
 * @version 1.0
 *
 */

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
