package com.example.test.test.Repositories.Specifications;

import com.example.test.test.Models.DTOs.PeriodFilter;
import com.example.test.test.Models.DTOs.PeriodSort;
import com.example.test.test.Models.Entities.Period;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNullApi;

import java.util.ArrayList;
import java.util.List;

public class PeriodSpecification implements Specification<Period> {

    private final PeriodFilter filter;
    private final PeriodSort sort;

    public PeriodSpecification(PeriodFilter filter, PeriodSort sort) {
        this.filter = filter;
        this.sort = sort;
    }

    @Override
    public Predicate toPredicate(Root<Period> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        // Пример фильтрации по полю id
        if (filter.getId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("id"), filter.getId()));
        }
        // Добавьте другие условия фильтрации по необходимости

        // Пример сортировки
        if (sort != null && sort.getField() != null && sort.getDirection() != null) {
            if (sort.getDirection().equals("ASC")) {
                query.orderBy(criteriaBuilder.asc(root.get(String.valueOf(sort.getField()))));
            } else if (sort.getDirection().equals("DESC")) {
                query.orderBy(criteriaBuilder.desc(root.get(String.valueOf(sort.getField()))));
            }
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
