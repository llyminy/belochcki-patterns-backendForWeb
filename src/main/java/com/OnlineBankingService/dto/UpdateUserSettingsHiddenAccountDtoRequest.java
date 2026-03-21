package com.OnlineBankingService.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UpdateUserSettingsHiddenAccountDtoRequest {

    private List<UUID> hiddenAccountIds;
}
