package com.enviro.assessment.grad001.sello_ramotsheki.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
@Entity
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tip;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private WasteCategory category;
}
