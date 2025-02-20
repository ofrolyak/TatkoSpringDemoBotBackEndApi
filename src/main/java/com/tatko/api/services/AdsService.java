package com.tatko.api.services;

import com.tatko.api.apis.models.AdApiObject;
import com.tatko.api.apis.models.AdCreateApiRequest;
import com.tatko.api.apis.models.AdsApiObject;
import com.tatko.api.apis.models.FilterAdApiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdsService {

    @Autowired
    AdsUtilityService adsUtilityService;


    public AdsApiObject adsRequest(FilterAdApiRequest filterAdApiRequest, Pageable pageable) {

        AdsApiObject ads = adsUtilityService.adsRequest(filterAdApiRequest, pageable);

        return ads;

    }

    public AdApiObject adCreate(AdCreateApiRequest body) {

        AdApiObject adApiObject = adsUtilityService.adCreate(body);

        return adApiObject;

    }

    public void adDelete(Long adId) {

        adsUtilityService.deleteById(adId);

    }

    public AdApiObject adGetById(Long adId) {

        AdApiObject adApiObject = adsUtilityService.adGetById(adId);

        return adApiObject;
    }

}
