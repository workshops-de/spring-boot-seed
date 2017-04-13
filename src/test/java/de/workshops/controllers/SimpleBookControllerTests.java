package de.workshops.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import de.workshops.TestingHelper;
import de.workshops.services.BookService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleBookControllerTests {
	
	private MockMvc mockMvc;
	
	@Mock
	private BookService bookService;
	
	@InjectMocks
	private BookController bookController;

    @Before
    public void setup() {
    	TestingHelper.mockBookService(bookService);
    	MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(bookController).build();
    }
    
    @Test
    public void testStartPage() throws Exception {
        this.mockMvc
        		.perform(get("/")
        		.accept(MediaType.parseMediaType("text/html;charset=UTF-8")))
                .andExpect(status().isOk());
    }

    @Test
    public void testApi() throws Exception {
        this.mockMvc
        		.perform(get("/api/books")
        		.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
}
