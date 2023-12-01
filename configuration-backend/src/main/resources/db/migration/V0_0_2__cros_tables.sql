create table t_menu_children
(
    menu_id  uuid references t_menus (id),
    child_id uuid references t_menus (id),

    constraint t_menu_children_pk primary key (menu_id, child_id)
);

CREATE TABLE t_menu_names
(
    menu_id UUID REFERENCES t_menus (id) ON UPDATE CASCADE ON DELETE CASCADE,
    name_id UUID REFERENCES t_texts (id) ON UPDATE CASCADE ON DELETE CASCADE,

    PRIMARY KEY (menu_id, name_id)
);
