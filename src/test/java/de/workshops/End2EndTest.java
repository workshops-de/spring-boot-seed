package de.workshops;

import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import org.fluentlenium.adapter.junit.FluentTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FluentConfiguration(webDriver = "phantomjs")
@Wait
public class End2EndTest extends FluentTest {

    @Value("${local.server.port}")
    private int serverPort;

    @Test
    public void testStartPage() {
        goTo("/");
        assertEquals("Book list", window().title());
    }
}
