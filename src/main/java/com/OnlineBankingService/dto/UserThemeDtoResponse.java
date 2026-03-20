package com.OnlineBankingService.dto;

import com.OnlineBankingService.enums.Theme;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserThemeDtoResponse {

    private Theme theme;
}
