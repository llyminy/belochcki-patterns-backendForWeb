package com.OnlineBankingService.dto;

import com.OnlineBankingService.enums.Theme;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CreateUserSettingsDtoRequest {

    @NotNull
    private UUID userId;

    @NotNull
    @Schema(example = "LIGHT/DARK")
    private Theme theme;

    @NotEmpty
    private List<UUID> hiddenAccountIds;
}
