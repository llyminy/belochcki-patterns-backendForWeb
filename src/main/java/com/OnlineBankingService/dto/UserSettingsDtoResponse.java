package com.OnlineBankingService.dto;

import com.OnlineBankingService.enums.Theme;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class UserSettingsDtoResponse {

    @NotNull
    private UUID userId;

    @NotNull
    private Theme theme;

    @NotEmpty
    private List<UUID> hiddenAccountIds;
}
