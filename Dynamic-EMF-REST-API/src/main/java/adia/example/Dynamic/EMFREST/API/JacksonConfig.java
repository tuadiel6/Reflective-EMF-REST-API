package adia.example.Dynamic.EMFREST.API;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import Example.Daughter;
import Example.Family;
import Example.Parent;
import Example.Son;

@Configuration
public class JacksonConfig {
	@Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.addMixIn(Family.class, FamilyMixin.class);
		
		  
		  objectMapper.addMixIn(Daughter.class, DaughterMixin.class);
		  objectMapper.addMixIn(Son.class, SonMixin.class);
		  objectMapper.addMixIn(Parent.class, ParentMixin.class);
		 
        return objectMapper;
    }

}
