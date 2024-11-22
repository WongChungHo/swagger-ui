package com.baeldung.apiswagger.controller;

import com.baeldung.apiswagger.common.ErrorResponse;
import com.baeldung.apiswagger.common.GetHistoryLogSuccessResponseDetail;
import com.baeldung.apiswagger.config.SwaggerConfiguration;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/book")
@Api(tags = {SwaggerConfiguration.BOOK_TAG})
public class BookController {

    @GetMapping("/")
    @Operation(summary = "Retrieve ActionItem History Log from CMS And Combine With EDoc ActionItem History ", operationId = "SWR-PN14")
    @Parameters(value = {
            @Parameter(name = "cms-access-token", description = "CMS Access Token", required = true, example = "{JWT}", in = ParameterIn.COOKIE, schema = @Schema(type = "string")),
            @Parameter(name = "cms-common-cache-key", description = "CMS Common Cache Key", required = true, example = "{UUID}", in = ParameterIn.COOKIE, schema = @Schema(type = "string")),
            @Parameter(name = HttpHeaders.CONTENT_TYPE, description = "Content Type", required = true, example = MediaType.APPLICATION_JSON_VALUE, in = ParameterIn.HEADER, schema = @Schema(type = "string")),
            @Parameter(name = "X-Request-ID", description = "X-Request-ID", required = true, example = "{UUID}", in = ParameterIn.HEADER, schema = @Schema(type = "string"))
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS", content = {
                    // @Content(schema = @Schema(implementation =
                    // CreateProgressNoteSuccessResponse.class))}),
                    @Content(schema = @Schema(implementation = GetHistoryLogSuccessResponseDetail.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class)) })
    })
    public List<String> getBooks() {
        return Arrays.asList("book1", "book2");
    }
}