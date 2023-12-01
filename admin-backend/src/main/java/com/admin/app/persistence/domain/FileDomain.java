package com.admin.app.persistence.domain;


import com.admin.core.persistence.domain.BaseDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "t_files")
public class FileDomain extends BaseDomain {

    @Column(name = "name")
    private String name;

    @Column(name = "original_id")
    private UUID originalId;

    @Column(name = "type")
    private String type;

}
