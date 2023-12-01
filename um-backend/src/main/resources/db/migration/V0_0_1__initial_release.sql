CREATE TABLE t_roles
(
    id          UUID      NOT NULL,
    created     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted     TIMESTAMP,

    name        VARCHAR(50),
    application VARCHAR(10),
    description VARCHAR(200),

    PRIMARY KEY (id)
);

CREATE TABLE t_permissions
(
    id          UUID      NOT NULL,
    created     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted     TIMESTAMP,

    name        VARCHAR(30),
    description VARCHAR(50),
    authority   VARCHAR(50),
    application VARCHAR(10),
    role_id     UUID REFERENCES t_roles (id),

    PRIMARY KEY (id)
);

CREATE TABLE t_users
(
    id         UUID      NOT NULL,
    created    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted    TIMESTAMP,

    username   VARCHAR(70),
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    email      VARCHAR(100),
    password   VARCHAR(200),
    role_id    UUID REFERENCES t_roles (id),

    PRIMARY KEY (id)
);
