package com.tatko.api.services;

import com.tatko.api.MockitoExtensionBaseMockTests;
import com.tatko.api.apis.models.AdApiObject;
import com.tatko.api.apis.models.AdCreateApiRequest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AdsService4adDelete4Test extends MockitoExtensionBaseMockTests {

    @Mock
    AdsUtilityService adsUtilityService;
    @InjectMocks
    AdsService adsService;

    @Test
    void base4Test() {

        // Prepare
        long id = getGen().nextLong();

        // When
        doNothing()
                .when(adsUtilityService)
                .deleteById(eq(id));

        // Action
        adsService.adDelete(id);

        // Then
        verify(adsUtilityService, times(1))
                .deleteById(eq(id));

    }

}