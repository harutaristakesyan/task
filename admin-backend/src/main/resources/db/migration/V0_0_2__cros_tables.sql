create table t_contacts_address
(
    contact_id uuid references t_contacts (id) on update cascade on delete cascade,
    address_id uuid references t_address (id) on update cascade on delete cascade,

    constraint t_contacts_address_pk primary key (contact_id, address_id)
);

CREATE TABLE t_goods_images
(
    good_id UUID REFERENCES t_goods (id) ON UPDATE CASCADE ON DELETE CASCADE,
    file_id UUID REFERENCES t_files (id) ON UPDATE CASCADE ON DELETE CASCADE,

    PRIMARY KEY (good_id, file_id)
);

CREATE TABLE t_goods_titles
(
    good_id  UUID REFERENCES t_goods (id) ON UPDATE CASCADE ON DELETE CASCADE,
    title_id UUID REFERENCES t_texts (id) ON UPDATE CASCADE ON DELETE CASCADE,

    PRIMARY KEY (good_id, title_id)
);

CREATE TABLE t_goods_descriptions
(
    good_id        UUID REFERENCES t_goods (id) ON UPDATE CASCADE ON DELETE CASCADE,
    description_id UUID REFERENCES t_texts (id) ON UPDATE CASCADE ON DELETE CASCADE,

    PRIMARY KEY (good_id, description_id)
);
CREATE TABLE t_goods_categories_names
(
    good_category_id UUID REFERENCES t_goods_categories (id) ON UPDATE CASCADE ON DELETE CASCADE,
    name_id          UUID REFERENCES t_texts (id) ON UPDATE CASCADE ON DELETE CASCADE,

    PRIMARY KEY (good_category_id, name_id)
);
CREATE TABLE t_goods_brands_descriptions
(
    good_brand_id  UUID REFERENCES t_goods_brands (id) ON UPDATE CASCADE ON DELETE CASCADE,
    description_id UUID REFERENCES t_texts (id) ON UPDATE CASCADE ON DELETE CASCADE,

    PRIMARY KEY (good_brand_id, description_id)
);
CREATE TABLE t_promotions_texts
(
    promotion_id UUID REFERENCES t_promotions (id) ON UPDATE CASCADE ON DELETE CASCADE,
    text_id      UUID REFERENCES t_texts (id) ON UPDATE CASCADE ON DELETE CASCADE,

    PRIMARY KEY (promotion_id, text_id)
);
