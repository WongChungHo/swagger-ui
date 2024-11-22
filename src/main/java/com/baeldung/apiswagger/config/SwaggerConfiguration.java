package com.baeldung.apiswagger.config;

import com.baeldung.apiswagger.common.ErrorResponse;
import com.baeldung.apiswagger.common.GetHistoryLogSuccessResponseDetail;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    public static final String BOOK_TAG = "book service";
    private final TypeResolver typeResolver;

    @Autowired
    public SwaggerConfiguration(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }


    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .additionalModels(
                        typeResolver.resolve(GetHistoryLogSuccessResponseDetail.class),
                        typeResolver.resolve(ErrorResponse.class)
                )
                .groupName("1wqewq2132121321")
          .select()
//          .apis(RequestHandlerSelectors.any())
//          .paths(PathSelectors.any())
          .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
          .paths(PathSelectors.any())
          .build()
          .tags(new Tag(BOOK_TAG, "the book API with description api tag"));
    }

    @Bean
    public Docket api2() {

        return new Docket(DocumentationType.SWAGGER_2)
                .additionalModels(
                        typeResolver.resolve(GetHistoryLogSuccessResponseDetail.class),
                        typeResolver.resolve(ErrorResponse.class)
                )
                .groupName("1wqewq21321")
                .select()
//          .apis(RequestHandlerSelectors.any())
//          .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(BOOK_TAG, "the book API with description api tag"));
    }


}
