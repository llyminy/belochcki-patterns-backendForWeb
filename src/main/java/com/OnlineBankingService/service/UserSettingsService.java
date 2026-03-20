package com.OnlineBankingService.service;

import com.OnlineBankingService.dto.*;

import java.util.UUID;

public interface UserSettingsService {

    UserSettingsDtoResponse create(CreateUserSettingsDtoRequest request);

    UserThemeDtoResponse getThemeByUserId(UUID userId);

    UserHiddenAccountsDtoResponse getHiddenAccountsByUserId(UUID userId);

    UserThemeDtoResponse updateTheme(UUID userId, UpdateUserSettingsThemeDtoRequest request);

    UserHiddenAccountsDtoResponse updateHiddenAccounts(UUID userId, UpdateUserSettingsHiddenAccountDtoRequest request);

    UserHiddenAccountsDtoResponse removeHiddenAccounts(UUID userId, DeleteUserSettingsHiddenAccountDtoRequest request);
}
