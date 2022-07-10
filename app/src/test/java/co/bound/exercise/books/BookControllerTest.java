package co.bound.exercise.books;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookControllerTest {

    @Autowired
    private BookController controller;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(controller);
    }

    @Test
    public void shouldReturnBookSummary() {
        var result = controller.findBookById(1);
        assertNotNull(result);
    }

    @Test
    public void shouldFail() {
        var result = controller.findBooks("authorName");
        assertNotNull(result);
    }
}
