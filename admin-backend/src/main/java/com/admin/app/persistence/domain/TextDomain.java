package com.admin.app.persistence.domain;

import com.admin.core.persistence.domain.BaseDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Entity
@Setter
@NoArgsConstructor
@Table(name = "t_texts")
public class TextDomain extends BaseDomain {

    @Column(name = "text")
    private String text;

    @Column(name = "lang_code")
    private String langCode;
}
