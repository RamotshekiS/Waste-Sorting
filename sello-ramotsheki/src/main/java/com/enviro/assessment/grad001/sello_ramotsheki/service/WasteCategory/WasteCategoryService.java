package com.enviro.assessment.grad001.sello_ramotsheki.service.WasteCategory;

import com.enviro.assessment.grad001.sello_ramotsheki.exeptions.AlreadyExistExeption;
import com.enviro.assessment.grad001.sello_ramotsheki.exeptions.ResourceNotFoundExeption;
import com.enviro.assessment.grad001.sello_ramotsheki.model.WasteCategory;
import com.enviro.assessment.grad001.sello_ramotsheki.repository.WasteCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WasteCategoryService implements IWasteCategoryService{

    private final WasteCategoryRepository wasteCategoryRepository;

    @Override
    public WasteCategory getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Waste category not found"));
    }

    @Override
    public List<WasteCategory> getAllWasteCategory() {
        return wasteCategoryRepository.findAll();
    }

    @Override
    public void deleteWasteById(Long id) {
        wasteCategoryRepository.findById(id)
                .ifPresentOrElse(wasteCategoryRepository::delete, () -> {
                    throw new ResourceNotFoundExeption("Waste category not found");
                });
    }

    @Override
    public WasteCategory createWasteCategory(WasteCategory category) {
        //Check if the category already exist either Plastics / cans
        //if not create new category
        return Optional.of(category).filter(c -> !wasteCategoryRepository.existsByName(c.getName()))
                .map(wasteCategoryRepository::save)
                .orElseThrow(() -> new AlreadyExistExeption(category.getName() + "Already exist!"));
    }
}
