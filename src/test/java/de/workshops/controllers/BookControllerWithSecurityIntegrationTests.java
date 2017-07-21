package de.workshops.controllers;

import de.workshops.TestingHelper;
import de.workshops.services.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerWithSecurityIntegrationTests {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private FilterChainProxy filterChainProxy;

    @Before
    public void setup() {
        TestingHelper.mockBookService(bookService);
        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.initMocks(this);
        this.mockMvc = webAppContextSetup(wac).addFilters(filterChainProxy).build();
    }

    @Test
    public void testStartPage() throws Exception {
        this.mockMvc
                .perform(get("/").accept(MediaType.parseMediaType("text/html;charset=UTF-8")))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void testApi() throws Exception {
        this.mockMvc
                .perform(
                        get("/api/books")
                                .with(httpBasic("user", "password"))
                                .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
}
