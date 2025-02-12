package com.enviro.assessment.grad001.sello_ramotsheki.repository;

import com.enviro.assessment.grad001.sello_ramotsheki.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisposalGuidelineRepository extends JpaRepository<WasteCategory, Long> {

}
