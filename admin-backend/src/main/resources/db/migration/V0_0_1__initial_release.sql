CREATE TABLE t_amenities
(
    id      UUID      NOT NULL,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TIMESTAMP,

    name    VARCHAR(50),

    PRIMARY KEY (id)
);

CREATE TABLE t_jobs
(
    id         UUID      NOT NULL,
    created    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted    TIMESTAMP,
    amenity_id UUID REFERENCES t_amenities (id) ON UPDATE CASCADE ON DELETE CASCADE,

    name       VARCHAR(50),
    price      NUMERIC,

    PRIMARY KEY (id)
);
CREATE TABLE t_benefits
(
    id          UUID      NOT NULL,
    created     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted     TIMESTAMP,

    title       VARCHAR(250),
    description VARCHAR(500),

    PRIMARY KEY (id)
);
CREATE TABLE t_contacts
(
    id          UUID      NOT NULL,
    created     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted     TIMESTAMP,

    title       VARCHAR(250),
    description VARCHAR(500),

    PRIMARY KEY (id)
);

CREATE TABLE t_address
(
    id      UUID      NOT NULL,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TIMESTAMP,

    name    VARCHAR(250),

    PRIMARY KEY (id)
);

CREATE TABLE t_works
(
    id      UUID      NOT NULL,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TIMESTAMP,

    info    VARCHAR(250),

    PRIMARY KEY (id)
);

CREATE TABLE t_services
(
    id      UUID      NOT NULL,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TIMESTAMP,

    name    VARCHAR(250),
    price   NUMERIC,

    PRIMARY KEY (id)
);

CREATE TABLE t_orders
(
    id           UUID      NOT NULL,
    created      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted      TIMESTAMP,

    name         VARCHAR(250),
    phone_number VARCHAR(250),
    PRIMARY KEY (id)
);

CREATE TABLE t_questions
(
    id          UUID      NOT NULL,
    created     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted     TIMESTAMP,

    description VARCHAR(500),
    PRIMARY KEY (id)
);

CREATE TABLE t_answers
(
    id          UUID      NOT NULL,
    created     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted     TIMESTAMP,

    description VARCHAR(500),
    PRIMARY KEY (id)
);


CREATE TABLE t_files
(
    id          UUID      NOT NULL,
    created     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted     TIMESTAMP,

    name        VARCHAR(250),
    original_id UUID,
    type        VARCHAR(15),

    PRIMARY KEY (id)
);

CREATE TABLE t_promotions
(
    id       UUID      NOT NULL,
    created  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted  TIMESTAMP,

    end_date TIMESTAMP,
    value    VARCHAR(250),
    route    VARCHAR(250),
    type     VARCHAR(250),

    image_id UUID REFERENCES t_files (id) ON UPDATE CASCADE ON DELETE CASCADE,

    PRIMARY KEY (id)
);

CREATE TABLE t_goods_brands
(
    id                UUID      NOT NULL,
    created           TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated           TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted           TIMESTAMP,

    name              VARCHAR(250),
    route             VARCHAR(250),
    country_of_origin VARCHAR(250),

    logo_id           UUID REFERENCES t_files (id) ON UPDATE CASCADE ON DELETE CASCADE,

    PRIMARY KEY (id)
);

CREATE TABLE t_goods_collections
(
    id         UUID      NOT NULL,
    created    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted    TIMESTAMP,

    name       VARCHAR(250),
    route      VARCHAR(250),
    brand_id   UUID REFERENCES t_goods_brands (id) ON UPDATE CASCADE ON DELETE CASCADE,
    catalog_id UUID REFERENCES t_files (id) ON UPDATE CASCADE ON DELETE CASCADE,

    PRIMARY KEY (id)
);

CREATE TABLE t_goods_categories
(
    id      UUID      NOT NULL,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted TIMESTAMP,

    route   VARCHAR(250),

    PRIMARY KEY (id)
);
CREATE TABLE t_goods
(
    id            UUID      NOT NULL,
    created       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted       TIMESTAMP,

    finish        VARCHAR(250),
    usage         VARCHAR(250),
    area          VARCHAR(250),
    availability  BOOL,
    material      VARCHAR(250),
    color         VARCHAR(250),
    vendor_code   VARCHAR(250),
    price         NUMERIC,
    sale_price    NUMERIC,
    discount      NUMERIC,
    warranty      NUMERIC,
    promotion_id  UUID REFERENCES t_promotions (id) ON UPDATE CASCADE ON DELETE CASCADE,
    collection_id UUID REFERENCES t_goods_collections (id) ON UPDATE CASCADE ON DELETE CASCADE,
    category_id   UUID REFERENCES t_goods_categories (id) ON UPDATE CASCADE ON DELETE CASCADE,
    volume        VARCHAR(250),

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

