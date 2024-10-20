package com.tatko.api.services;

import com.tatko.api.apis.models.AdApiInstance;
import com.tatko.api.apis.models.AdCreateRequest;
import com.tatko.api.apis.models.AdsApiInstance;
import com.tatko.api.entities.Ad;
import com.tatko.api.repositories.AdsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdsService {

    @Autowired
    AdsRepository adsRepository;

    public AdsApiInstance adsRequest(Pageable pageable) {
        Page<Ad> adList = adsRepository.findAll(pageable);
        AdsApiInstance ads = new AdsApiInstance();
        ads.ad(adList.stream()
                .map(ad -> {
                    AdApiInstance adApiInstance = new AdApiInstance();
                    BeanUtils.copyProperties(ad, adApiInstance);
                    return adApiInstance;
                })
                .collect(Collectors.toList()));
        return ads;

    }

    public AdApiInstance adCreate(AdCreateRequest body) {

        Ad ad = new Ad();
        BeanUtils.copyProperties(body, ad);
        ad.setCreatingTime(LocalDateTime.now());

        Ad save = adsRepository.save(ad);

        AdApiInstance adApiInstance = new AdApiInstance();

        BeanUtils.copyProperties(save, adApiInstance);

        return adApiInstance;

    }
}
