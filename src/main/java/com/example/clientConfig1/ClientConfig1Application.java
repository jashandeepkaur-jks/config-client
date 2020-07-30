package com.example.clientConfig1;

import com.sun.jersey.api.client.config.ClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class ClientConfig1Application {

	public static void main(String[] args) {
		SpringApplication.run(ClientConfig1Application.class, args);
	}

	@Autowired
	ClientConfugration confugration;

	@Value("${some.other.property}")
	private String someOtherProperty;

	@RequestMapping("/")
	public String getValue()
	{
		StringBuilder sb = new StringBuilder();

		sb.append(confugration.getProperty()).append("_").append(someOtherProperty);
		return sb.toString();
	}
}
