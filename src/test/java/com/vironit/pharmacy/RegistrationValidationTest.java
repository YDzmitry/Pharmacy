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
        String passport = "123a12";
        registrationValidator.validate(login,password,passport);
    }

    @Test
    public void testWrongLoginField(){
        String login = "21";
        String password = "123as123a";
        String passport = "MP3256743";
        try {
            registrationValidator.validate(login,password,passport);
        }catch (RegistrationValidatorException ex){
            assertEquals("The login must consist of letters, numbers, hyphens and underscores, the password length must be at least 4 and not more than 16 characters.", ex.getErrMessageMap().get("login"));
        }
    }

    @Test
    public void testWrongPasswordField(){
        String login = "qwewsasdqw";
        String password = "2a";
        String passport = "MP3256743";
        try {
            registrationValidator.validate(login,password,passport);
        }catch (RegistrationValidatorException ex){
            assertEquals("The password must consist of letters, numbers, hyphens and underscores, the password length must be at least 6 and not more than 18 characters.", ex.getErrMessageMap().get("password"));
        }
    }


    @Test
    public void testWrongPassportField(){
        String login = "2rtyy1";
        String password = "123as123a";
        String passport = "MP325673";
        try {
            registrationValidator.validate(login,password,passport);
        }catch (RegistrationValidatorException ex){
            assertEquals("Passport must begin with 2 letters of the Latin alphabet and have 7 digits.", ex.getErrMessageMap().get("passport"));
        }
    }

    @Test
    public void testCorrectLoginField(){
        String login = "asaswsas";
        String password = "123as123a";
        String passport = "MP3256743";
        try {
            registrationValidator.validate(login,password,passport);
        }catch (RegistrationValidatorException ex){
            assertEquals(false, ex.getErrMessageMap().containsKey("login"));
        }
    }

    @Test
    public void testCorrectPasswordField(){
        String login = "qwewsasdqw";
        String password = "2artyyyyto";
        String passport = "MP3556743";
        try {
            registrationValidator.validate(login,password,passport);
        }catch (RegistrationValidatorException ex){
            assertEquals(false, ex.getErrMessageMap().containsKey("password"));
        }
    }


    @Test
    public void testCorrectPassportField(){
        String login = "2rtyy61";
        String password = "23a567567";
        String passport = "MP2112223";
        try {
            registrationValidator.validate(login,password,passport);
        }catch (RegistrationValidatorException ex){
            assertEquals(false, ex.getErrMessageMap().containsKey("passport"));
        }
    }



}