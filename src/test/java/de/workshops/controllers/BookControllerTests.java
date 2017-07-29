package de.workshops.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.webAppContextSetup;
import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTests {

	@Autowired
	private BookController bookController;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private FilterChainProxy filterChainProxy;

	@Before
	public void setup() {
		webAppContextSetup(webApplicationContext);
	}

	@Test
	@WithMockUser(roles="ADMIN")
	public void testBookList() throws Exception {
		given()
			.contentType("application/json;charset=UTF-8")
		.when()
			.post("/api/books")
		.then()
			.expect(authenticated().withUsername("user"))
			.statusCode(200)
			.body("size()", equalTo(3))
			.body("get(0).title", equalTo("Design Patterns"));
	}
	
	@Test
	@WithMockUser(roles="ADMIN")
	public void testBookDetail() throws Exception {
		given()
			.contentType("application/json;charset=UTF-8")
		.when()
			.post("/api/book/0")
		.then()
			.expect(authenticated().withUsername("user"))
			.statusCode(200)
			.body("title", equalTo("Design Patterns"));
	}
}
