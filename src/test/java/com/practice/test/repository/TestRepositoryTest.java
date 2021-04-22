package com.practice.test.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TestRepositoryTest {
    @Autowired
    TestRepository testRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() {
        com.practice.test.domain.Test test = new com.practice.test.domain.Test();
        test.setUsername("memberA");
        Long savedId = testRepository.save(test);
        com.practice.test.domain.Test findMember = testRepository.find(savedId);
        Assertions.assertThat(findMember.getId()).isEqualTo(test.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(test.getUsername());
        Assertions.assertThat(findMember).isEqualTo(test);
    }
}

