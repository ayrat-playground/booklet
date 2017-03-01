import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisOperations;

import com.example.booklet.models.Link;
import com.example.booklet.repositories.*;

@SpringBootApplication
public class Application {
    @Autowired
    LinkRepository repository;
    @Autowired
    RedisOperations<Link, String> operations;

    public static void main(String[] args) {
	Link link = new Link("goog.le", "google.com");
	System.out.println("Hello!");
    }
}
