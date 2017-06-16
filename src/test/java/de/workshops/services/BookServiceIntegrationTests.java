package de.workshops.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceIntegrationTests {

    @Autowired
    private BookService bookService;

    @Test
    public void testCreateBook() {
        assertTrue(false);
    }

    @Test
    public void testUpdateBook() {
        assertTrue(false);
    }

    @Test
    public void testDeleteBook() {
        assertTrue(false);
    }
}
