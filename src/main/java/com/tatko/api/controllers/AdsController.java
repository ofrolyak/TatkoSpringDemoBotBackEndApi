package com.tatko.api.controllers;

import com.tatko.api.apis.AdsApi;
import com.tatko.api.apis.models.AdApiObject;
import com.tatko.api.apis.models.AdCreateApiRequest;
import com.tatko.api.apis.models.AdsApiObject;
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
    public ResponseEntity<AdsApiObject> adsRequest(Integer page, Integer size) {
        AdsApiObject ads = adsService.adsRequest(Pageable.ofSize(size).withPage(page));
        return new ResponseEntity<>(ads, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AdApiObject> adCreate(AdCreateApiRequest body) {
        AdApiObject ad = adsService.adCreate(body);
        return new ResponseEntity<>(ad, HttpStatus.CREATED);
    }

}
