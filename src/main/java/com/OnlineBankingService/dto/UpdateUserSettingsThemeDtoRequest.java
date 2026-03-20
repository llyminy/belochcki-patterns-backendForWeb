package com.OnlineBankingService.dto;

import com.OnlineBankingService.enums.Theme;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateUserSettingsThemeDtoRequest {
    @NotNull
    @Schema(example = "LIGHT/DARK")
    private Theme theme;
}
