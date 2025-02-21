package com.tatko.api.dao;

import com.tatko.api.MockitoExtensionBaseMockTests;
import com.tatko.api.apis.models.FilterAdApiRequest;
import com.tatko.api.apis.models.FilterOptionalDateTimeApiObject;
import com.tatko.api.apis.models.FilterOptionalLongApiObject;
import com.tatko.api.apis.models.FilterOptionalStringApiObject;
import com.tatko.api.services.PredicatesHolderService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AdsDaoService4buildPredicate4MockedTest extends MockitoExtensionBaseMockTests {

    @Mock
    DaoService daoService;
    @Mock
    PredicatesHolderService predicatesHolderService;
    @Spy
    @InjectMocks
    AdsDaoService adsDaoService;

    @Test
    void base4Test() {

        // Prepare
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);
        From from = mock(From.class);
        FilterAdApiRequest filterAdApiRequest = getGen().nextObject(FilterAdApiRequest.class);

        // When
        doReturn(Optional.empty())
                .when(predicatesHolderService)
                .filterOptionalLongPredicate(nullable(CriteriaBuilder.class), nullable(From.class), anyString(), nullable(FilterOptionalLongApiObject.class));
        doReturn(Optional.empty())
                .when(predicatesHolderService)
                .filterOptionalStringPredicate(nullable(CriteriaBuilder.class), nullable(From.class), anyString(), nullable(FilterOptionalStringApiObject.class));
        doReturn(Optional.empty())
                .when(predicatesHolderService)
                .filterOptionalDateTimePredicate(nullable(CriteriaBuilder.class), nullable(From.class), anyString(), nullable(FilterOptionalDateTimeApiObject.class));

        // Action
        Predicate predicate = adsDaoService.buildPredicate(criteriaBuilder, from, filterAdApiRequest);

        // Then
        assertThat(predicate)
                .isNull();
//        verify(daoService, times(1))
//                .entityFilter(any(PredicateCreator.class), any(Pageable.class), eq(AdJpaEntity.class));


    }

}