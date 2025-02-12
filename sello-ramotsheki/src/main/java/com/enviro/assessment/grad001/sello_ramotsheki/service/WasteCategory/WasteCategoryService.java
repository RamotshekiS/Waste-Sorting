package com.enviro.assessment.grad001.sello_ramotsheki.service.WasteCategory;

import com.enviro.assessment.grad001.sello_ramotsheki.model.WasteCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WasteCategoryService implements IWasteCategoryService{

    @Override
    public WasteCategory getWasteCategoryById(Long id) {
        return null;
    }

    @Override
    public List<WasteCategory> getAllWasteCategory() {
        return List.of();
    }

    @Override
    public void deleteWasteById(Long id) {

    }

    @Override
    public WasteCategory saveWasteCategory(WasteCategory category) {
        return null;
    }
}
