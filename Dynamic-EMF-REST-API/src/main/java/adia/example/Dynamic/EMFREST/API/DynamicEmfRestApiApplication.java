package adia.example.Dynamic.EMFREST.API;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "GENERIC EMF-REST API",
        version = "1.0",
        description = "<center><a href=\"https://ibb.co/0D0vprv\"><img src=\"https://i.ibb.co/smTzpqz/familia.png\" alt=\"familia\" border=\"0\"></a>"
        		+ "<figcaption>Fig.1 - Simple Ecore model.</figcaption>"
        		+ "<p><em>With our approach you can navigate through your model to get a list of all model elements<br>http://server/packageName/className/all<br>For instance http://localhost:8080/Example/Family/all<br></em></p></center>",
        license = @io.swagger.v3.oas.annotations.info.License(
                name = "License Name",
                url = "http://www.example.com/license"
        ),
        contact = @io.swagger.v3.oas.annotations.info.Contact(
                name = "Adiel Tuyishime",
                url = "http://www.example.com/contact",
                email = "adiel.tuyishime@gssi.it"
        ),
        termsOfService = "http://www.example.com/terms",
        extensions = {
                @Extension(name = "image", properties = {
                        @ExtensionProperty(name = "url", value = "/img/image.png")
                })
        }
))
public class DynamicEmfRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicEmfRestApiApplication.class, args);
	}

}
