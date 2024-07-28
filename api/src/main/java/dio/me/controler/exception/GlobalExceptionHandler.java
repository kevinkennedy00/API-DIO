package dio.me.controler.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handlebusinessException(IllegalArgumentException businessException) {
		return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handlenotFoundException(NoSuchElementException notFoundException) {
		return new ResponseEntity<>("Resource ID not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleUnexpectedExEntity(Throwable unexpectedException) {
		var message = "Unexpected serve erros, see the logs";
		return new ResponseEntity<>("Unexpected serve erros, see the logs", HttpStatus.INTERNAL_SERVER_ERROR);

	}
}