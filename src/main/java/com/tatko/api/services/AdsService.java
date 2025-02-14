package com.tatko.api.services;

import com.tatko.api.apis.models.AdApiObject;
import com.tatko.api.apis.models.AdCreateApiRequest;
import com.tatko.api.apis.models.AdsApiObject;
import com.tatko.api.apis.models.FilterAdApiRequest;
import com.tatko.api.apis.models.FilterLongApiObject;
import com.tatko.api.apis.models.FilterOptionalLongApiObject;
import com.tatko.api.entities.Ad;
import com.tatko.api.repositories.AdsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdsService {

    @Autowired
    AdsRepository adsRepository;

    @PersistenceContext
    private EntityManager entityManager;

//    Optional<Predicate> createStringFilterPredicate(
//            CriteriaBuilder criteriaBuilder, From root, String fieldName,
//            String value) {
//
//        if (StringUtils.isEmpty(value)) {
//            return Optional.empty();
//        }
//
//        return Optional.of(numberFindPredicateGetterService.getPredicate4StringValue(criteriaBuilder, root,
//                fieldName, value));
//    }

    Optional<Predicate> filterOptionalLongPredicate(
            CriteriaBuilder criteriaBuilder, From root, String fieldName, FilterOptionalLongApiObject filterOptionalLongApiObject) {

        if (Objects.isNull(filterOptionalLongApiObject) || !filterOptionalLongApiObject.isPresent()) {
            return Optional.empty();
        }

        Predicate predicate;

        if (filterOptionalLongApiObject.getValue().getAction().equals(FilterLongApiObject.ActionEnum.IS_NULL)) {
            predicate = criteriaBuilder.isNull(root.get(fieldName).as(Long.class));
//        } else if (numericFilter.getFilterValue().getNumberAction().equals(NumericFilterValueApiObject.NumberActionEnum.EQUAL)) {
//            predicate = criteriaBuilder.equal(root.get(fieldName).as(Integer.class),
//                    numericFilter.getFilterValue().getOnValue());
//        } else if (numericFilter.getFilterValue().getNumberAction().equals(NumericFilterValueApiObject.NumberActionEnum.LESS_EQUAL)) {
//            predicate = criteriaBuilder.lessThanOrEqualTo(root.get(fieldName).as(Integer.class),
//                    numericFilter.getFilterValue().getOnValue());
//        } else if (numericFilter.getFilterValue().getNumberAction().equals(NumericFilterValueApiObject.NumberActionEnum.GREATER_EQUAL)) {
//            predicate = criteriaBuilder.greaterThanOrEqualTo(root.get(fieldName).as(Integer.class),
//                    numericFilter.getFilterValue().getOnValue());
//        } else if (numericFilter.getFilterValue().getNumberAction().equals(NumericFilterValueApiObject.NumberActionEnum.BETWEEN)) {
//            predicate = criteriaBuilder.between(root.get(fieldName).as(Integer.class),
//                    numericFilter.getFilterValue().getMinValue(), numericFilter.getFilterValue().getMaxValue());
        } else {
            throw new IllegalArgumentException("Invalid action: " + filterOptionalLongApiObject.getValue().getAction());
        }

        // Process negate case
        if (filterOptionalLongApiObject.getValue().isNegate()) {
            predicate = criteriaBuilder.not(predicate);
        }

        return Optional.of(predicate);
    }


    public AdsApiObject adsRequest(FilterAdApiRequest filterAdApiRequest, Pageable pageable) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ad> criteriaQuery = criteriaBuilder.createQuery(Ad.class);
        Root<Ad> root = criteriaQuery.from(Ad.class);
        List<Optional<Predicate>> predicates = new ArrayList<>();


        // -----------------------------------------------------------------------
        predicates.add(filterOptionalLongPredicate(criteriaBuilder, root, "id", filterAdApiRequest.getId()));
        // -----------------------------------------------------------------------




        Predicate predicate = criteriaBuilder.and(predicates.stream().filter(Optional::isPresent).map(Optional::get).toList().toArray(new Predicate[0]));

        CriteriaQuery<Ad> select = criteriaQuery.select(root).where(predicate);
        TypedQuery<Ad> typedQuery = entityManager.createQuery(select);

        typedQuery.setFirstResult(pageable.getPageNumber());
        typedQuery.setMaxResults(pageable.getPageSize());

        List<Ad> adList = typedQuery.getResultList();

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
