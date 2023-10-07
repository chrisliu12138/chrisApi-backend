package com.chrisliu12138.apiinterface;

import com.chrisliu12138.chrisapiclientsdk.client.ChrisApiClient;
import com.chrisliu12138.chrisapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ChrisApiInterfaceApplicationTests {

	@Resource
	private ChrisApiClient chrisApiClient;

	@Test
	void contextLoads() {
		String result = chrisApiClient.getNameByGet("chris");
//		User user = new User();
//		user.setUsername("chrisliu");
//		String usernameByPost = chrisApiClient.getUsernameByPost(user);
//		System.out.println(result);
//		System.out.println(usernameByPost);
	}

}
