CREATE TABLE t_menus
(
    id         UUID      NOT NULL,
    created    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted    TIMESTAMP,

    icon_name  VARCHAR(50),
    route      VARCHAR(50),
    is_nav_bar BOOL,

    PRIMARY KEY (id)
);

CREATE TABLE t_texts
(
    id        UUID      NOT NULL,
    created   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted   TIMESTAMP,

    text      VARCHAR(250),
    lang_code VARCHAR(10),

    PRIMARY KEY (id)
);
