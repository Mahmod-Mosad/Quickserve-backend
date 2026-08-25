package com.mahmoud.quickserve.controller;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Autowired
    private Cloudinary cloudinary;

    private static final Map<String, String> ALLOWED_FOLDERS = Map.of(
            "brand", "brands",
            "product", "products",
            "category", "categories"
    );

    @GetMapping("/signature")
    public ResponseEntity<?> getUploadSignature(@RequestParam String type) {

        String folder = ALLOWED_FOLDERS.get(type);
        if (folder == null) {
            return ResponseEntity.badRequest().body("Invalid type: " + type);
        }

        long timestamp = System.currentTimeMillis() / 1000L;

        Map<String, Object> paramsToSign = new HashMap<>();
        paramsToSign.put("timestamp", timestamp);
        paramsToSign.put("folder", folder);

        String signature = cloudinary.apiSignRequest(
                paramsToSign,
                cloudinary.config.apiSecret
        );

        Map<String, Object> response = new HashMap<>();
        response.put("signature", signature);
        response.put("timestamp", timestamp);
        response.put("apiKey", cloudinary.config.apiKey);
        response.put("cloudName", cloudinary.config.cloudName);
        response.put("folder", folder);

        return ResponseEntity.ok(response);
    }
}