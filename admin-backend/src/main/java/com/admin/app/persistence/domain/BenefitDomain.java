package com.admin.app.persistence.domain;

import com.admin.core.persistence.domain.BaseDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "t_benefits")
public class BenefitDomain extends BaseDomain {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
}
