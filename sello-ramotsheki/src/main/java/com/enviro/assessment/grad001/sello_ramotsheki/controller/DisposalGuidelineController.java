package com.enviro.assessment.grad001.sello_ramotsheki.controller;

import com.enviro.assessment.grad001.sello_ramotsheki.exeptions.ResourceNotFoundExeption;
import com.enviro.assessment.grad001.sello_ramotsheki.model.DisposalGuideline;
import com.enviro.assessment.grad001.sello_ramotsheki.response.ApiResponse;
import com.enviro.assessment.grad001.sello_ramotsheki.service.DisposalGuideline.IDisposalGuidelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/disposal-guidelines")
public class DisposalGuidelineController {
    private final IDisposalGuidelineService disposalGuidelineService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllGuidelines() {
        try {
            List<DisposalGuideline> guidelines = disposalGuidelineService.getAllDisposalGuideline();
            return ResponseEntity.ok(new ApiResponse("Success", guidelines));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Error", INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getGuidelineById(Long id) {
        try {
            DisposalGuideline guideline = disposalGuidelineService.findGuidelineById(id);
            return ResponseEntity.ok(new ApiResponse("Success", guideline));
        } catch (ResourceNotFoundExeption e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteGuideline(Long id) {
        try {
            disposalGuidelineService.deleteGuidelineById(id);
            return ResponseEntity.ok(new ApiResponse("Success", null));
        } catch (ResourceNotFoundExeption e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createGuideline(@RequestBody DisposalGuideline guideline) {
        try {
            DisposalGuideline theGuideline = disposalGuidelineService.createDisposalGuideline(guideline);
            return ResponseEntity.ok(new ApiResponse("Success", theGuideline));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), INTERNAL_SERVER_ERROR));
        }

    }
}
