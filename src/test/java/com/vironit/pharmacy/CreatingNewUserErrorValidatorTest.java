package com.vironit.pharmacy;

import com.vironit.pharmacy.exception.CustomGenericException;
import com.vironit.pharmacy.validator.CreatingNewUserErrorValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatingNewUserErrorValidatorTest {

    private String causeExistUser;
    private Exception ex;

    @Autowired
    CreatingNewUserErrorValidator creatingNewUserErrorValidator;

    @Before
    public void setError(){
        causeExistUser = "This user already exists in the system.";
        ex = new RuntimeException(causeExistUser);
    }

    @Test
    public void testExistUser(){
        try {
            throw new CustomGenericException("message", ex);
        }catch (CustomGenericException ex){
            System.out.println(12);
        }
    }
}
