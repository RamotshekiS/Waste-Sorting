package com.enviro.assessment.grad001.sello_ramotsheki.service.WasteCategory;

import com.enviro.assessment.grad001.sello_ramotsheki.model.WasteCategory;

import java.util.List;

public interface IWasteCategoryService {

    WasteCategory getWasteCategoryById(Long id);
    List<WasteCategory> getAllWasteCategory();
    void deleteWasteById(Long id);
    WasteCategory createWasteCategory(WasteCategory category);
}
