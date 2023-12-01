package com.admin.app.persistence.domain;


import com.admin.app.data.PromotionType;
import com.admin.core.persistence.domain.BaseDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "t_promotions")
public class PromotionDomain extends BaseDomain {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "t_promotions_texts", joinColumns = @JoinColumn(name = "promotion_id"), inverseJoinColumns = @JoinColumn(name = "text_id"))
    private Set<TextDomain> texts;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "value")
    private String value;

    @Column(name = "route")
    private String route;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PromotionType type;

    @JoinColumn(name = "image_id")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private FileDomain image;

}
