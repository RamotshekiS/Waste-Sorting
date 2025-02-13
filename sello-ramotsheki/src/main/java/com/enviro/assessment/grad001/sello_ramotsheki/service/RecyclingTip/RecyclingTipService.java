package com.enviro.assessment.grad001.sello_ramotsheki.service.RecyclingTip;

import com.enviro.assessment.grad001.sello_ramotsheki.exeptions.ResourceNotFoundExeption;
import com.enviro.assessment.grad001.sello_ramotsheki.model.RecyclingTip;
import com.enviro.assessment.grad001.sello_ramotsheki.repository.RecyclingTipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecyclingTipService implements  IRecyclingTipService{

    private final RecyclingTipRepository recyclingTipRepository;
    @Override
    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipRepository.findAll();
    }

    @Override
    public RecyclingTip getTipById(Long id) {
        return recyclingTipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Tip not found"));
    }

    @Override
    public void deleteTipById(Long id) {
        recyclingTipRepository.findById(id).ifPresentOrElse(recyclingTipRepository::delete,
                () -> {throw new ResourceNotFoundExeption("Tip not found");});
    }

    @Override
    public RecyclingTip createRecyclingTip(RecyclingTip tip) {
        return recyclingTipRepository.save(tip);
    }
}
