CREATE TABLE t_images
(
    id               UUID      NOT NULL,
    created          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted          TIMESTAMP,

    application_name VARCHAR(50),
    original_name    VARCHAR(250),
    file_type        VARCHAR(20),
    size             NUMERIC,
    image_url        VARCHAR(300),
    used             BOOL,

    PRIMARY KEY (id)
);