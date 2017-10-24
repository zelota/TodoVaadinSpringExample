package todoexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * https://www.youtube.com/watch?v=qUBt8k4pQgQ
 * https://www.youtube.com/watch?v=tnVKN25dIm8
 */
@SpringBootApplication
public class TodoApplication {

    public static void main( String[] args ) {
        //SpringApplication.run(TodoApplication.class, args);
        SpringApplication app = new SpringApplication(TodoApplication.class);
        app.run(args);
    }
}
