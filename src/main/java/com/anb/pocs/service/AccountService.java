package com.anb.pocs.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anb.pocs.entity.AccountEntity;
import com.anb.pocs.model.RequestObject;
import com.anb.pocs.repo.AccountRepository;
import com.anb.pocs.util.FiledValidator;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    FiledValidator validator;
   

    private static final Logger logger =LoggerFactory.getLogger(AccountService.class);

    public AccountEntity getAccount(RequestObject req) throws Exception  {
        AccountEntity acc;
        if(validator.isAccountValid(req.getAccountNumber())){
        	logger.debug("Account format is Valid");
            acc = accountRepository.findByAccountNumber(Long.parseLong(req.getAccountNumber()));
            if(acc == null ){
            	logger.error("Exception occured while fetching account", new Exception("Account Number not Found").getMessage());
                throw new Exception("Account Number not Found");
            }
            else
            	logger.info("Account found Successfully");
        }
        else{
            logger.warn("Invalid Account");
            throw new Exception("Account Number is invalid");
        }
            return acc;
    }
    
    public AccountEntity addAccount(AccountEntity account) throws Exception {
        AccountEntity acc;
        if(validator.validateFileds(account)){
        	
            logger.debug("Account object is valid with all fields");
            
            acc = accountRepository.findByAccountNumber(account.getAccountNumber());
            try {
                if(acc == null ) {
                	logger.debug("No Account found in DB, creating new account - Account={}",account.getAccountNumber());
                	acc = accountRepository.save(account);
                }
                else {
                	logger.debug("Account found in DB, Updating account - Account={}",account.getAccountNumber());
                	account.setId(acc.getId());
                	accountRepository.save(account);
                }
			} catch (Exception e) {
				logger.error("Failed to upsert Account in DB", new Exception("Failed to upsert Account in DB").getMessage());
			}
            return acc;
        }
        else {
            logger.warn("Invalid Account");
            throw new Exception("Account Number is invalid");
        }
       
    }
    
    
    public boolean deleteAccount(Long account){
        
        if(validator.isAccountValid(String.valueOf(account))){
            logger.debug("Account format is Valid");
          
            try {
            	RequestObject request = new RequestObject();
            	request.setAccountNumber(String.valueOf(account));
            	AccountEntity acc = getAccount(request);
            	if(acc != null) {
    				accountRepository.delete(acc);
    				logger.info("Account Deleted Successfully {}",account);            		
            	}
            	else {
            		logger.info("No Account found to delete {}",account);        
            	}

			} catch (Exception e) {
				 logger.error("Exception Occured While Deleteing acount",new Exception());
				 return false;
			}
            return true;
        }
        else {
        	logger.warn("Account number is Invalid");
            logger.info("Unable to delete account");
            return false;
        }
        
    }
    
    
}