package com.enviro.assessment.grad001.sello_ramotsheki.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<DisposalGuideline> disposalGuidelines;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<RecyclingTip> recyclingTips;

}
