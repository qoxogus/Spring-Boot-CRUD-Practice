package com.practice.test.repository;

import com.practice.test.domain.Test;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TestRepository {

    @PersistenceContext
    EntityManager em;

    public Long save(Test test) {
        em.persist(test);
        return test.getId();
    }
    public Test find(Long id) {
        return em.find(Test.class, id);
    }
}
