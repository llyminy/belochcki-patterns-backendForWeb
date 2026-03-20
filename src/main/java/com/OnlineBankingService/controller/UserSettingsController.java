package com.OnlineBankingService.controller;

import com.OnlineBankingService.dto.*;
import com.OnlineBankingService.service.UserSettingsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/userSettings")
@RequiredArgsConstructor
public class UserSettingsController {

    private final UserSettingsService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserSettingsDtoResponse create(@Valid @RequestBody CreateUserSettingsDtoRequest request) {
        return service.create(request);
    }

    @GetMapping("/{userId}/theme")
    public UserThemeDtoResponse getThemeByUserId(@PathVariable UUID userId) {
        return service.getThemeByUserId(userId);
    }

    @GetMapping("/{userId}/hiddenAccounts")
    public UserHiddenAccountsDtoResponse getHiddenAccountsByUserId(@PathVariable UUID userId) {
        return service.getHiddenAccountsByUserId(userId);
    }

    @PutMapping("/{userId}/theme")
    public UserThemeDtoResponse updateTheme(@PathVariable UUID userId, @Valid @RequestBody UpdateUserSettingsThemeDtoRequest request) {
        return service.updateTheme(userId, request);
    }

    @PutMapping("/{userId}/hiddenAccounts")
    public UserHiddenAccountsDtoResponse updateHiddenAccounts(@PathVariable UUID userId, @Valid @RequestBody UpdateUserSettingsHiddenAccountDtoRequest request) {
        return service.updateHiddenAccounts(userId, request);
    }

    @DeleteMapping("/{userId}/hiddenAccounts")
    public UserHiddenAccountsDtoResponse removeHiddenAccounts(@PathVariable UUID userId, @Valid @RequestBody DeleteUserSettingsHiddenAccountDtoRequest request) {
        return service.removeHiddenAccounts(userId, request);
    }
}
