package com.file.managemnet.app.persistence.domain;

import com.file.managemnet.base.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_images")
public class ImageEntity extends BaseEntity {

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "size")
    private Long size;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "used")
    private Boolean used;

}
