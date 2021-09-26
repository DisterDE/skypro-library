package pro.sky.java.web.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.sky.java.web.library.bootstrap.Bootstrap;

@SpringBootApplication
public class App implements CommandLineRunner {

    private final Bootstrap bootstrap;

    public App(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        bootstrap.addAuthors();
        bootstrap.addBooks();
    }
}
