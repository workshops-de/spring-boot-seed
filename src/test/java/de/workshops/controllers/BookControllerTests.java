package de.workshops.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTests {

	@Autowired
	private BookController bookController;

	@Before
	public void setup() {
		standaloneSetup(bookController);
	}

	@Test
	public void testBookList() throws Exception {
		given()
			.contentType("application/json;charset=UTF-8")
		.when()
			.post("/api/books")
		.then()
			.statusCode(200)
			.body("size()", equalTo(3))
			.body("get(0).title", equalTo("Design Patterns"));
	}
	
	@Test
	public void testBookDetail() throws Exception {
		given()
			.contentType("application/json;charset=UTF-8")
		.when()
			.post("/api/book/0")
		.then()
			.statusCode(200)
			.body("title", equalTo("Design Patterns"));
	}
}
