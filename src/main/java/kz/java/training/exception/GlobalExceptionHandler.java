package kz.java.training.exception;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(DataAccessException.class)
	public ModelAndView handleBadFileNameException(DataAccessException  ex) {
		logger.error("IOException handler executeddddddddddddddddddddddddddddddddddddddddddddddd");
		ex.printStackTrace();
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("error", ex.getMessage());
		return modelAndView;
	}
}
