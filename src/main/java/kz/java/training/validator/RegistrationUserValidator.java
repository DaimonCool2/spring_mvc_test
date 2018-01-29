package kz.java.training.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kz.java.training.dao.impl.UserDao;
import kz.java.training.entity.RegistrationUser;

@Service
public class RegistrationUserValidator implements Validator {
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	public void validate(Object regUser, Errors errors) {
		RegistrationUser user = (RegistrationUser) regUser;
		
		if(user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
			errors.rejectValue("confirmPassword", "password.empty");
		} else if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "confirm.password.doesn't.match");
		}
		if(userDao.isUserExist(user)) {
			errors.rejectValue("username", "user.exists");
		}
		
		
	}

}
