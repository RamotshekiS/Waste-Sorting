package com.enviro.assessment.grad001.sello_ramotsheki.controller;

import com.enviro.assessment.grad001.sello_ramotsheki.exeptions.ResourceNotFoundExeption;
import com.enviro.assessment.grad001.sello_ramotsheki.model.RecyclingTip;
import com.enviro.assessment.grad001.sello_ramotsheki.response.ApiResponse;
import com.enviro.assessment.grad001.sello_ramotsheki.service.RecyclingTip.IRecyclingTipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/recycling-tip")
public class RecyclingTipController {
    private final IRecyclingTipService recyclingTipService;

    @GetMapping("/All")
    public ResponseEntity<ApiResponse> getAllTips() {
        try {
            List<RecyclingTip> tips = recyclingTipService.getAllRecyclingTips();
            return ResponseEntity.ok(new ApiResponse("Success", tips));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Error", INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getTipById(@PathVariable Long id) {
       try {
           RecyclingTip tip = recyclingTipService.getTipById(id);
           return ResponseEntity.ok(new ApiResponse("Success", tip));
       } catch (ResourceNotFoundExeption e) {
           return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
       }
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createTip(@RequestBody RecyclingTip tip) {
        try {
            RecyclingTip theTip = recyclingTipService.createRecyclingTip(tip);
            return ResponseEntity.ok(new ApiResponse("Success", theTip));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Error", INTERNAL_SERVER_ERROR));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTip(@PathVariable Long id) {
        try {
            recyclingTipService.deleteTipById(id);
            return ResponseEntity.ok(new ApiResponse("Success", null));
        } catch (ResourceNotFoundExeption e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
