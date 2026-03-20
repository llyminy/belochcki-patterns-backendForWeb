package com.OnlineBankingService.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class DeleteUserSettingsHiddenAccountDtoRequest {

    @NotEmpty
    private List<UUID> accountIds;
}
