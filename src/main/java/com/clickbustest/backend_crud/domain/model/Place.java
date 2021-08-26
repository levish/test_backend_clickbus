package com.clickbustest.backend_crud.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data

public class Place {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String slug;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @CreationTimestamp
    @Column(nullable = false,columnDefinition = "datetime")
    private LocalDateTime createdAt;

    @Column(nullable = false,columnDefinition = "datetime")
    @UpdateTimestamp
    private LocalDateTime updateAt;
}
