package com.enviro.assessment.grad001.sello_ramotsheki.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
@Entity
public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String guideline;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private WasteCategory category;
}
