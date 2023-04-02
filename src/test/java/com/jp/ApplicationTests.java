package com.jp;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jp.api.Welcome;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// @RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApplicationTests {

	@Autowired
	private Welcome welcome;

	@Test
	void contextLoads() {
		assertThat(welcome).isNotNull();
	}

}
