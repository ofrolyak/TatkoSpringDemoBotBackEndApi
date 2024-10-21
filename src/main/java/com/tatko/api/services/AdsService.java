package com.tatko.api.services;

import com.tatko.api.apis.models.AdApiObject;
import com.tatko.api.apis.models.AdCreateApiRequest;
import com.tatko.api.apis.models.AdsApiObject;
import com.tatko.api.entities.Ad;
import com.tatko.api.repositories.AdsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdsService {

    @Autowired
    AdsRepository adsRepository;

    public AdsApiObject adsRequest(Pageable pageable) {
        Page<Ad> adList = adsRepository.findAll(pageable);
        AdsApiObject ads = new AdsApiObject();
        ads.ad(adList.stream()
                .map(ad -> {
                    AdApiObject adApiInstance = new AdApiObject();
                    BeanUtils.copyProperties(ad, adApiInstance);
                    return adApiInstance;
                })
                .collect(Collectors.toList()));
        return ads;

    }

    public AdApiObject adCreate(AdCreateApiRequest body) {

        Ad ad = new Ad();
        BeanUtils.copyProperties(body, ad);
        ad.setCreatingTime(LocalDateTime.now());

        Ad save = adsRepository.save(ad);

        AdApiObject adApiInstance = new AdApiObject();

        BeanUtils.copyProperties(save, adApiInstance);

        return adApiInstance;

    }

    public void adDelete(Long adId) {
        adsRepository.deleteById(adId);
    }

    public AdApiObject adGetById(Long adId) {

        Ad byId = adsRepository.findById(adId).orElseThrow(() -> new RuntimeException("Ad not found"));

        AdApiObject adApiInstance = new AdApiObject();
        BeanUtils.copyProperties(byId, adApiInstance);
        return adApiInstance;
    }
}
