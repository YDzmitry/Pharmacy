package com.vironit.pharmacy;

import com.vironit.pharmacy.exception.CustomGenericException;
import com.vironit.pharmacy.validator.CreatingNewUserErrorValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatingNewUserErrorValidatorTest {

    private String causeExistUser;
    private RuntimeException runtimeException;
    private DataIntegrityViolationException ex;

    @Autowired
    CreatingNewUserErrorValidator creatingNewUserErrorValidator;

    @Before
    public void setError(){
        causeExistUser = "users_login_key";
        runtimeException = new RuntimeException(causeExistUser);
        ex = new DataIntegrityViolationException("login",runtimeException);
    }

    @Test
    public void testExistUser(){
        Map<String, String> errMessageMap = creatingNewUserErrorValidator.validate(ex);
        assertEquals(errMessageMap.get("login"),"This user already exists in the system.");

    }
}
