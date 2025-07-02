
package com;

import com.example.consumingwebservice.CountrySoapClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.consumingwebservice.wsdl.GetCountryResponse;

@SpringBootApplication
public class Adaptor {

	public static void main(String[] args) {
		SpringApplication.run(Adaptor.class, args);
	}


}
