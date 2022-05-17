package com.anb.pocs.controller;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.anb.pocs.entity.AccountEntity;
import com.anb.pocs.model.RequestObject;
import com.anb.pocs.service.AccountService;

@RestController
@RequestMapping("/exception")
public class AccountController {

    @Autowired
    AccountService accountService;

    private static final Logger logger =LoggerFactory.getLogger(AccountController.class);

    @PostMapping("/account")
    public ResponseEntity<AccountEntity> getAccount(@RequestBody RequestObject req ) {
            logger.info("Request to fetch Account with AccountNum={}",req.getAccountNumber());
            AccountEntity acc = null;
			try {
				acc = accountService.getAccount(req);
			} catch (Exception e) {
				e.printStackTrace();
			}
            logger.info("Get Account Request Finished");
            return new ResponseEntity<>(acc, HttpStatus.OK);

    }
    
    @PostMapping("/addAccount")
    public ResponseEntity<AccountEntity> addAccount(@RequestBody AccountEntity account ) {
            logger.info("Request Received to Add Account{}",account.getAccountNumber());
            //Structured argument
            logger.info("Account Info {}, {}", keyValue("Account", account.getAccountNumber()), keyValue("Email", account.getEmail()));
            
            
            logger.debug("Account Object {}",account);
            AccountEntity acc = null;
			try {
				acc = accountService.addAccount(account);
			} catch (Exception e) {
				e.printStackTrace();
			}
            if(acc != null) {
            	logger.info("Account Upserted SUccessfully");
            }
           
            logger.info("Create Account Request Finished");
            return new ResponseEntity<>(acc, HttpStatus.OK);

    }
    
    @DeleteMapping("/deleteAccount/{account}")
    public void deleteAccount(@PathVariable Long account ) {
            
          //Structured argument
            logger.info("Account Delete Request {}", keyValue("Account Number", account));
            
            Boolean flag = accountService.deleteAccount(account);
            if(Boolean.FALSE.equals(flag))
            	logger.info("Failed to delete account");
            
            logger.info("Delete Account Request Finished");
    }
    
    
    


}
