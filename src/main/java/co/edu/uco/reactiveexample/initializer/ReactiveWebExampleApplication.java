package co.edu.uco.reactiveexample.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.reactiveexample"})
@EnableR2dbcRepositories(basePackages = {"co.edu.uco.reactiveexample"})
public class ReactiveWebExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveWebExampleApplication.class, args);
    }

}
