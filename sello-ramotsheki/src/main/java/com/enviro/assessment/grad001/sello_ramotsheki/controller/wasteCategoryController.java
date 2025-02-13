package com.enviro.assessment.grad001.sello_ramotsheki.controller;

import com.enviro.assessment.grad001.sello_ramotsheki.exeptions.AlreadyExistExeption;
import com.enviro.assessment.grad001.sello_ramotsheki.exeptions.ResourceNotFoundExeption;
import com.enviro.assessment.grad001.sello_ramotsheki.model.WasteCategory;
import com.enviro.assessment.grad001.sello_ramotsheki.response.ApiResponse;
import com.enviro.assessment.grad001.sello_ramotsheki.service.WasteCategory.IWasteCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/waste-categories")
public class wasteCategoryController {
    private final IWasteCategoryService wasteCategoryService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse>  getAllCategories() {
        try {
            List<WasteCategory> categories = wasteCategoryService.getAllWasteCategory();
            return ResponseEntity.ok(new ApiResponse("Success", categories));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Error", INTERNAL_SERVER_ERROR));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long id) {
        try {
            WasteCategory category = wasteCategoryService.getWasteCategoryById(id);
            return ResponseEntity.ok(new ApiResponse("Success", category));
        } catch (ResourceNotFoundExeption e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createWasteCategory(@RequestBody WasteCategory name) {
        try {
            WasteCategory theCategory = wasteCategoryService.createWasteCategory(name);
            return ResponseEntity.ok(new ApiResponse("Success", theCategory));
        } catch (AlreadyExistExeption e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long id) {
        try {
            wasteCategoryService.deleteWasteById(id);
            return ResponseEntity.ok(new ApiResponse("Success", null));
        } catch (ResourceNotFoundExeption e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
