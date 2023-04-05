package io.study.jpa;

import io.study.jpa.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerJpaExam {
    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam1");

//      EntityManagerFactory 통해 EntityManager 얻기
        EntityManager em = emf.createEntityManager();

        // JPA를 통해 데이터를 넣고 쓸 때에는 트랜젝션 단위로 과정이 진행 된다.
        // 트랜잭션이 끝나면 commit 및 rollback을 해줘야하는 단위의 개념을 가지고 있어야 한다.

        EntityTransaction tx = em.getTransaction();

        // 트랜잭션 시작
        tx.begin();

        // Customer create
        em.persist(Customer.sample());

        // 이상없으면 commit
        tx.commit();

        // 관련 리소스 반납 후 종료
        em.close();
        emf.close();
    }
}

