package spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpringApplication.run(DeptProvider8003.class, args);

	}

}
