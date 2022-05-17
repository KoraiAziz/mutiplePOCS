package com.anb.pocs.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.anb.pocs.entity.AccountEntity;


@Component
public class FiledValidator {

	private static final Logger logger =LoggerFactory.getLogger(FiledValidator.class);

    public boolean isAccountValid(String  acc){

        return acc.matches("^[0-9]+$");
    }
    
    
    public boolean validateFileds(AccountEntity account) {
    	if(account.getAccountNumber() == null || !isAccountValid(String.valueOf(account.getAccountNumber()))) {
    		logger.debug("Account number is null OR its not numeric");
    		return false;
    	}
    	
    	if(account.getName() == null || account.getName().isEmpty()) {
    		logger.debug("Name is NULL or Empty");
    		return false;
    	}
    	
    	if(account.getEmail() == null || account.getEmail().isEmpty()) {
    		logger.debug("Email is NULL or Empty");
    		return false;
    	}
    	
    	return true;
    	
    }


}
