package br.edu.fatecsjc.lgnspringapi.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    ADMIN_CREATE("admin:create"),
    ADMIN_UPDATE("admin:update");

    private final String permission;
}
