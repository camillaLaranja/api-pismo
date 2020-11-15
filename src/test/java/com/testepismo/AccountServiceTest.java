package com.testepismo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testepismo.dto.AccountDto;
import com.testepismo.model.Account;
import com.testepismo.service.AccountService;

@SpringBootTest
@AutoConfigureMockMvc
class AccountServiceTest {

	@Autowired
	private AccountService accountService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void shouldCreateAccount() throws JsonProcessingException, Exception {

		AccountDto request = new AccountDto();

		request.setDocument_number(12345678900L);

		Account accountReturn = accountService.create(request);

		mockMvc.perform(post("/accounts").contentType("application/json")
				.content(objectMapper.writeValueAsString(accountReturn))).andExpect(status().isCreated());

		Assertions.assertEquals(accountReturn.getDocument_number(), 12345678900L);

	}

}
