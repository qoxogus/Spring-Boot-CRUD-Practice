package com.practice.test.repository;

import com.practice.test.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
