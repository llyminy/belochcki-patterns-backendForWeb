package com.OnlineBankingService.serviceImpl;

import com.OnlineBankingService.dto.*;
import com.OnlineBankingService.entity.UserSettingsEntity;
import com.OnlineBankingService.repository.UserSettingsRepository;
import com.OnlineBankingService.service.UserSettingsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserSettingsServiceImpl implements UserSettingsService {

    private final UserSettingsRepository repository;

    @Override
    @Transactional
    public UserSettingsDtoResponse create(CreateUserSettingsDtoRequest request) {

        if (repository.existsById(request.getUserId())) {
            throw new IllegalArgumentException(
                    "Настройки для пользователя с id " + request.getUserId() + " уже существуют"
            );
        }

        UserSettingsEntity entity = UserSettingsEntity.builder()
                .userId(request.getUserId())
                .theme(request.getTheme())
                .hiddenAccountIds(request.getHiddenAccountIds())
                .build();

        UserSettingsEntity saved = repository.save(entity);

        return UserSettingsDtoResponse.builder()
                .userId(saved.getUserId())
                .theme(saved.getTheme())
                .hiddenAccountIds(saved.getHiddenAccountIds())
                .build();
    }

    @Override
    @Transactional
    public UserThemeDtoResponse getThemeByUserId(UUID userId) {
        UserSettingsEntity entity = repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Пользователь с id " + userId + " не найден"));
        return new UserThemeDtoResponse(entity.getTheme());
    }

    @Override
    @Transactional
    public UserHiddenAccountsDtoResponse getHiddenAccountsByUserId(UUID userId) {
        UserSettingsEntity entity = repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Пользователь с id " + userId + " не найден"));
        return new UserHiddenAccountsDtoResponse(entity.getHiddenAccountIds());
    }

    @Override
    @Transactional
    public UserThemeDtoResponse updateTheme(UUID userId, UpdateUserSettingsThemeDtoRequest request) {
        UserSettingsEntity entity = repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Пользователь с id " + userId + " не найден"));
        entity.setTheme(request.getTheme());

        UserSettingsEntity updated = repository.save(entity);
        return new UserThemeDtoResponse(updated.getTheme());
    }

    @Override
    @Transactional
    public UserHiddenAccountsDtoResponse updateHiddenAccounts(UUID userId, UpdateUserSettingsHiddenAccountDtoRequest request) {
        UserSettingsEntity entity = repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Пользователь с id " + userId + " не найден"));
        entity.setHiddenAccountIds(new ArrayList<>(request.getHiddenAccountIds()));

        UserSettingsEntity updated = repository.save(entity);
        return new UserHiddenAccountsDtoResponse(updated.getHiddenAccountIds());
    }

    @Override
    @Transactional
    public UserHiddenAccountsDtoResponse removeHiddenAccounts(UUID userId, DeleteUserSettingsHiddenAccountDtoRequest request) {
        UserSettingsEntity entity = repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Пользователь с id " + userId + " не найден"));

        List<UUID> currentAccounts = entity.getHiddenAccountIds();

        currentAccounts.removeAll(request.getAccountIds());

        entity.setHiddenAccountIds(currentAccounts);

        UserSettingsEntity updated = repository.save(entity);

        return new UserHiddenAccountsDtoResponse(updated.getHiddenAccountIds());
    }

}
