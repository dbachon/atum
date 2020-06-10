package tk.tarajki.atum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiDocumentation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .ignoredParameterTypes(AuthenticationPrincipal.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("tk.tarajki.atum"))
                .paths(PathSelectors.any())
                .build()
                .globalResponseMessage(RequestMethod.GET,responseMessagesList())
                .globalResponseMessage(RequestMethod.POST,responseMessagesList())
                .globalResponseMessage(RequestMethod.PUT,responseMessagesList())
                .globalResponseMessage(RequestMethod.PATCH,responseMessagesList())
                .globalResponseMessage(RequestMethod.DELETE,responseMessagesList())
                .securitySchemes(Collections.singletonList(apiKey()));

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Atum")
                .version("Beta")
                .description("")
                .build();
    }

    private List<ResponseMessage> responseMessagesList(){
        return Collections.singletonList(new ResponseMessageBuilder()
                .code(500)
                .message("Internal Server Error")
                .build());
    }

    private ApiKey apiKey(){
        return new ApiKey("Token","Authorization","header");
    }
}
