package com.enviro.assessment.grad001.sello_ramotsheki.service.DisposalGuideline;

import com.enviro.assessment.grad001.sello_ramotsheki.exeptions.ResourceNotFoundExeption;
import com.enviro.assessment.grad001.sello_ramotsheki.model.DisposalGuideline;
import com.enviro.assessment.grad001.sello_ramotsheki.repository.DisposalGuidelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisposalGuidelineService implements  IDisposalGuidelineService{

    private final DisposalGuidelineRepository disposalGuidelineRepository;

    @Override
    public List<DisposalGuideline> getAllDisposalGuideline() {
        return disposalGuidelineRepository.findAll();
    }

    @Override
    public DisposalGuideline findGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Guideline not found!"));
    }

    @Override
    public void deleteGuidelineById(Long id) {
        disposalGuidelineRepository.findById(id).ifPresentOrElse(disposalGuidelineRepository::delete,
                () -> {throw new ResourceNotFoundExeption("Guideline not found");});
    }

    @Override
    public DisposalGuideline createDisposalGuideline(DisposalGuideline guideline) {
        return disposalGuidelineRepository.save(guideline);
    }


}
