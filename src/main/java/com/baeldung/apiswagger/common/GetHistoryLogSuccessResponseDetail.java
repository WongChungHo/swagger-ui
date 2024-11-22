package com.baeldung.apiswagger.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GetHistoryLogSuccessResponseDetail  {

    @Schema(description = "No of items returned", example = "3")
    private int totalItems;

    @Schema(description = "List of Note Template")
    private List<String> HistoryLogtemplates;
}
