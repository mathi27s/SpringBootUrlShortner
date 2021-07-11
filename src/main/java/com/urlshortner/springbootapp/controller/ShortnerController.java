package com.urlshortner.springbootapp.controller;


import com.urlshortner.springbootapp.dto.ShortnerDto;
import com.urlshortner.springbootapp.service.ShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
public class ShortnerController {

    @Autowired
    ShortnerService shortnerService;

    @PostMapping("shortner")
    public String convertUrlToShort(@RequestBody ShortnerDto dto) {

        return shortnerService.convertUrlToShort(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity getLongUrlRedirect(@PathVariable String id) {
        Optional<String> result =  shortnerService.getLongUrl(id);
        if(result.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(result.get())).build();
        }
        return ResponseEntity.notFound().build();
    }
}
