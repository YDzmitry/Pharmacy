package com.vironit.pharmacy;

import com.vironit.pharmacy.service.MainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PharmacyApplicationTests {

	@Autowired
	MainService userService;

	@Test
	public void contextLoads() {
        System.out.println(userService.getByPK(141));
	}

}
