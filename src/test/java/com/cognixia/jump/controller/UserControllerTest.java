package com.cognixia.jump.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cognixia.jump.model.Address;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;
import com.cognixia.jump.service.MyUserDetailsService;
import com.cognixia.jump.service.UserService;
import com.cognixia.jump.util.JwtUtil;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	UserService service;

	@MockBean
	UserRepository repo;

	@MockBean
	PasswordEncoder encoder;

	@MockBean
	MyUserDetailsService myUserDetailsService;

	@MockBean
	JwtUtil jwtUtil;

	@InjectMocks
	UserController controller;

	@Test
	public void testFindAllUsers() throws Exception {
		String uri = "/api/user";

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void testFindUserById() throws Exception {
		String uri = "/api/user/{id}";
		String id = "";

		Address address = new Address("A Street", "S City", "BB", "12345");
		User user = new User("1", "bob", "123", address, User.Role.ROLE_USER, true);

		when(service.findUserById(id)).thenReturn(user);

		mockMvc.perform(get(uri, id)).andDo(print()).andExpect(status().isOk());

		verify(service, times(1)).findUserById(id);
		verifyNoMoreInteractions(service);

	}
}
