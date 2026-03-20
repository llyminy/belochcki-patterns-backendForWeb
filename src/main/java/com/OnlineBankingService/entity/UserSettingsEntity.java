package com.OnlineBankingService.entity;

import com.OnlineBankingService.enums.Theme;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSettingsEntity {

    @Id
    @Column(name = "user_id", nullable = false, updatable = false)
    private UUID userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "theme", nullable = false)
    private Theme theme;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "hidden_account_ids", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "account_id", nullable = false)
    @Builder.Default
    private List<UUID> hiddenAccountIds = new ArrayList<>();
}
