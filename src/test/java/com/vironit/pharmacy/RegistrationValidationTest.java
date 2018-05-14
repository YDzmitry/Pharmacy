package com.vironit.pharmacy;

import com.vironit.pharmacy.exception.RegistrationValidatorException;
import com.vironit.pharmacy.validator.RegistrationValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationValidationTest {

    @Autowired
    RegistrationValidator registrationValidator;

    @Test(expected = RegistrationValidatorException.class)
    public void testAllFieldsValidator() {
        String login = "123+";
        String password = "123asa";
        registrationValidator.validate(login,password);
    }

    @Test
    public void testWrongLoginField(){
        String login = "21";
        String password = "123as123a";
        try {
            registrationValidator.validate(login,password);
        }catch (RegistrationValidatorException ex){
            assertEquals("The login must consist of letters, numbers, hyphens and underscores, the password length must be at least 4 and not more than 16 characters.", ex.getErrMessageMap().get("login"));
        }
    }

    @Test
    public void testWrongPasswordField(){
        String login = "qwewsasdqw";
        String password = "2a";
        try {
            registrationValidator.validate(login,password);
        }catch (RegistrationValidatorException ex){
            assertEquals("The password must consist of letters, numbers, hyphens and underscores, the password length must be at least 6 and not more than 18 characters.", ex.getErrMessageMap().get("password"));
        }
    }



    @Test
    public void testCorrectLoginField(){
        String login = "asaswsas";
        String password = "123as123a";
        try {
            registrationValidator.validate(login,password);
        }catch (RegistrationValidatorException ex){
            assertEquals(false, ex.getErrMessageMap().containsKey("login"));
        }
    }

    @Test
    public void testCorrectPasswordField(){
        String login = "qwewsasdqw";
        String password = "2artyyyyto";
        try {
            registrationValidator.validate(login,password);
        }catch (RegistrationValidatorException ex){
            assertEquals(false, ex.getErrMessageMap().containsKey("password"));
        }
    }



}