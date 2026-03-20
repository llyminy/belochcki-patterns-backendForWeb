package com.OnlineBankingService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UserHiddenAccountsDtoResponse {

    private List<UUID> hiddenAccountIds;
}
