package com.tatko.api.controllers;

import com.tatko.api.apis.AdsApi;
import com.tatko.api.apis.models.AdApiInstance;
import com.tatko.api.apis.models.AdCreateRequest;
import com.tatko.api.apis.models.AdsApiInstance;
import com.tatko.api.entities.Ad;
import com.tatko.api.services.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class AdsController implements AdsApi {

    @Autowired
    AdsService adsService;

    @Override
    public ResponseEntity<AdsApiInstance> adsRequest(Integer page, Integer size) {
        AdsApiInstance ads = adsService.adsRequest(Pageable.ofSize(size).withPage(page));
        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AdApiInstance> adCreate(AdCreateRequest body) {
        AdApiInstance ad = adsService.adCreate(body);
        return new ResponseEntity<>(ad, HttpStatus.CREATED);
    }

}
