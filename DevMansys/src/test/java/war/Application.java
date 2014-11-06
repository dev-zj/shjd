package war;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import controller.SimpleController;

@ComponentScan
@EnableAutoConfiguration
public class Application {
	public static void main(String[] args){
		SpringApplication.run(SimpleController.class, args);
	}
}
