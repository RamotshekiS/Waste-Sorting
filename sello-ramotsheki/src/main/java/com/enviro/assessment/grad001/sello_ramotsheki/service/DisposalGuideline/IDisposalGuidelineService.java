package com.enviro.assessment.grad001.sello_ramotsheki.service.DisposalGuideline;

import com.enviro.assessment.grad001.sello_ramotsheki.model.DisposalGuideline;

import java.util.List;

public interface IDisposalGuidelineService {

    List<DisposalGuideline> getAllDisposalGuideline();
    DisposalGuideline findGuidelineById(Long id);
    void deleteGuidelineById(Long id);
    DisposalGuideline createDisposalGuideline(DisposalGuideline guideline);

}
