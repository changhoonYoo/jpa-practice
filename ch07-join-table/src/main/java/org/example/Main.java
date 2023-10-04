package org.example;


import org.example.manytomanyjointable.Child;
import org.example.manytomanyjointable.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            //TODO 비즈니스 로직

            //예제 7.14 일대일 조인 테이블 저장
//            Parent parent = new Parent();
//            parent.setName("부모1");
//
//            Child child = new Child();
//            child.setName("자식1");
//
//            parent.setChild(child);
//            child.setParent(parent);
//
//            em.persist(parent);
//            em.persist(child);

            //일대일 조인 테이블 양방향 조회
//            Child child = em.find(Child.class, 3L);
//            System.out.println("자식1의 부모= "+child.getParent().getName());
//            Parent parent = em.find(Parent.class,2L);
//            System.out.println("부모1의 자식= "+parent.getChild().getName());

            //일대다 조인 테이블 저장
//            Parent parent = new Parent();
//            parent.setName("부모");
//
//            Child child1 = new Child();
//            Child child2 = new Child();
//            child1.setName("자식1");
//            child2.setName("자식2");
//
//            List<Child> children = new ArrayList<>();
//            children.add(child1);
//            children.add(child2);
//
//            parent.setChild(children);
//
//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);

            //일대다 조인 테이블 조회
//            Parent parent = em.find(Parent.class,1L);
//            List<Child> children = parent.getChild();
//            for(Child child : children) {
//                System.out.println(parent.getName()+"의 자식 : "+child.getName());
//            }
//            Child child = em.find(Child.class,3L);
//            System.out.println("CHILD_ID=3 : "+child.getName());

            //다대일 조인 테이블 저장
//            Parent parent = new Parent();
//            parent.setName("부모");
//
//            Child child1 = new Child();
//            Child child2 = new Child();
//            child1.setName("자식1");
//            child2.setName("자식2");
//            child1.setParent(parent);
//            child2.setParent(parent);
//
//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);

            //다대일 조인 테이블 조회
//            Parent parent = em.find(Parent.class, 1L);
//            for(Child child : parent.getChild()) {
//                System.out.println(child.getName());
//            }

            //다대다 조인 테이블 저장
//            Parent parent = new Parent();
//            parent.setName("부모");
//
//            Child child1 = new Child();
//            Child child2 = new Child();
//            child1.setName("자식1");
//            child2.setName("자식1");
//
//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);

            //다대다 조인 테이블 조회 및 연관관계 설정
//            Parent parent = em.find(Parent.class, 1L);
//            Child child1 = em.find(Child.class, 2L);
//            Child child2 = em.find(Child.class, 3L);
//
//            List<Child> children = new ArrayList<>();
//            children.add(child1);
//            children.add(child2);
//            parent.setChild(children);

            
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

}
