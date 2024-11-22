package com.baeldung.apiswagger.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    @Schema(description = "api version", example = "v1.0.18" )
    private transient String apiVersion;

    @Schema(description = "Error response time", example = "2021-03-26T12:11:11+08:00", format = "yyyy-MM-dd'T'HH:mm:ssXXX")
    @Pattern(message = "datetime must follow ISO 8601 standard", regexp = "^(?:[1-9]\\d{3}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1\\d|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[1-9]\\d(?:0[48]|[2468][048]|[13579][26])|(?:[2468][048]|[13579][26])00)-02-29)T(?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d(?:Z|[+-][01]\\d:[0-5]\\d)$")
    @NotEmpty(message = "datetime must not be empty")
    @NonNull
    private String datetime;

    @Schema(description = "Detailed error object", example =
            "[\n" +
                    "    {\n" +
                    "        \"statusCode\": 400,\n" +
                    "        \"errorMessages\": [\n" +
                    "            {\n" +
                    "                \"errorCode\": \"SYSTEM_002\",\n" +
                    "                \"message\": \"Invalid format value [d35870e1-02c2-4ed3-a80f-969ec9cae1cb]\"\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"source\": \"/SWRProgressNote/v1/getPatientRecords\",\n" +
                    "        \"embedded\": null\n" +
                    "    }\n" +
                    "]")
    private List<Error> errors;

    @Schema(description = "uuid from request", example = "b64e04d8-52e4-40e6-8ecb-ebc1f7c98986" )
    @NonNull
    private transient String requestId;
}
