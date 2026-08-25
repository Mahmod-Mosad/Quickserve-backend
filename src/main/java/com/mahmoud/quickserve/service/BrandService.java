package com.mahmoud.quickserve.service;

import com.mahmoud.quickserve.model.Brand;
import com.mahmoud.quickserve.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    private  final    BrandRepository brandRepository;


    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

     public List<Brand> getBrands(){
        return brandRepository.findAll();
     }

     public Optional<Brand> getBrandById(Long id){

        return brandRepository.findById(id);

     }


     public Brand addBrand(Brand brand){
        return brandRepository.save(brand);
     }


     public Brand updateBrand(Brand brand,Long id){
        Brand brandOld =  brandRepository.findById(id).orElse(null);
        if (brandOld == null) {
            return null ;
        }

        if(brand.getDescription()!=null){
            brandOld.setDescription(brand.getDescription());
        }
        if(brand.getImageUrl()!=null){
            brandOld.setImageUrl(brand.getImageUrl());
        }
         if(brand.getCommissionRate()!=null){
             brandOld.setCommissionRate(brand.getCommissionRate());
         }

        return brandRepository.save(brandOld);
     }

     public Boolean deleteBrand(Long id){
        Boolean exists = brandRepository.existsById(id);
        if(exists){
            brandRepository.deleteById(id);

        }
        return exists;
     }



}
