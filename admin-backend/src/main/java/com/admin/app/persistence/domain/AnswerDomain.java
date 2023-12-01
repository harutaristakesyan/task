package com.admin.app.persistence.domain;

import com.admin.core.persistence.domain.BaseDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_answers")
public class AnswerDomain extends BaseDomain {

    @Column(name = "description")
    private String description;
}
