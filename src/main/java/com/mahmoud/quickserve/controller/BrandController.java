package com.mahmoud.quickserve.controller;

import com.cloudinary.Cloudinary;
import com.mahmoud.quickserve.model.Brand;
import com.mahmoud.quickserve.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("/brands")
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> brandList = brandService.getBrands();
        return new ResponseEntity<>(brandList, HttpStatus.OK);
    }


    @GetMapping("/brand/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
        return brandService.getBrandById(id)
                .map(brand -> new ResponseEntity<>(brand, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }


    @PostMapping("/brand/add")
    public ResponseEntity<Brand> addBrand(@RequestBody Brand brand) {
        Brand result = brandService.addBrand(brand);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


    @PutMapping("/brand/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id , @RequestBody Brand brand){
     Brand update = brandService.updateBrand(brand,id) ;
     if (update == null){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
     return new ResponseEntity<>(update, HttpStatus.OK);
    }


    @DeleteMapping("/brand/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id){

       if( brandService.deleteBrand(id)){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }





}
