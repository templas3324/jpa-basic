package io.study.jpa;

import io.study.jpa.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerJpaExam {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam1");

//      EntityManagerFactory 통해 EntityManager 얻기
        EntityManager em = emf.createEntityManager();

        // JPA를 통해 데이터를 넣고 쓸 때에는 트랜젝션 단위로 과정이 진행 된다.
        // 트랜잭션이 끝나면 commit 및 rollback을 해줘야하는 단위의 개념을 가지고 있어야 한다.

        EntityTransaction tx = em.getTransaction();

        // 트랜잭션 시작
        tx.begin();

        try {
            // Customer create
//            em.persist(Customer.sample());

            // 엔티티 매니저의 find 메소드로 객체 찾기      find(Customer 객체로 받을것임, ID )
            // 엔티티 매니저는 데이터를 가지고 왔을 때 기본생성자를 만들어서 Customer 객체를 생성 할 수 있어야 한다.
            Customer foundCustomer = em.find(Customer.class, "ID0001");

            // 수정
            // 트랜잭션 내에서 객체의 값이 변경 되고 커밋이 되면 자동으로 엔티티매니저가 관리하에 있는 data는 update 한다.
//            foundCustomer.setName("Park");

            // 삭제
            em.remove(foundCustomer);

            System.out.println(foundCustomer.toString());

            // 이상없으면 commit
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        }finally {
            // 관련 리소스 반납 후 종료
            em.close();
        }
        emf.close();
    }
}

