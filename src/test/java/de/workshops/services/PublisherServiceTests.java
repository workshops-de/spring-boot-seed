package de.workshops.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.workshops.model.Publisher;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublisherServiceTests {

	@Mock
	private PublisherService publisherService;
    
    @Before
    public void setup() {
    	List<Publisher> publishers = new ArrayList<>();
		
		Publisher addisonWesley = new Publisher();
		addisonWesley.setName("Addison-Wesley");
		addisonWesley.setUrl("http://www.addison-wesley.de/");
		publishers.add(addisonWesley);
		Publisher dpunkt = new Publisher();
		dpunkt.setName("dpunkt.verlag");
		dpunkt.setUrl("http://dpunkt.de/");
		publishers.add(dpunkt);
		Publisher noStarchPress = new Publisher();
		noStarchPress.setName("No Starch Press");
		noStarchPress.setUrl("https://www.nostarch.com/");
		publishers.add(noStarchPress);
		
    	when(publisherService.getPublishers()).thenReturn(publishers);
    	when(publisherService.getPublisher(0)).thenReturn(addisonWesley);
    }
	
	@Test
	public void testGetPublisherList() {
		assertTrue(publisherService.getPublishers().size() > 0);
	}
	
	@Test
	public void testGetPublisherDetail() {
		Publisher publisher = publisherService.getPublisher(0);
		assertEquals("Addison-Wesley", publisher.getName());
	}
}
