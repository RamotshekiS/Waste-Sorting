package com.enviro.assessment.grad001.sello_ramotsheki.service.RecyclingTip;

import com.enviro.assessment.grad001.sello_ramotsheki.model.RecyclingTip;

import java.util.List;

public interface IRecyclingTipService {

    List<RecyclingTip> getAllRecyclingTips();
    RecyclingTip getTipById(Long id);
    void deleteTipById(Long id);
    RecyclingTip createRecyclingTip(RecyclingTip tip);
}
