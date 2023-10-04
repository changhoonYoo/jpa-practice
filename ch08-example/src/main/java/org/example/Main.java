package org.example;

import org.example.entity.Member;
import org.example.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            //TODO
            //회원 및 팀 저장
//            Team team = new Team();
//            team.setName("바르셀로나");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("홍길동");
//            member.setTeam(team); //연관관계 설정
//            em.persist(member);


//            printUserAndTeam(2L,em); //회원 및 팀 정보 출력
//            printUser(2L,em); // 회원의 정보 출력

            Member member = em.getReference(Member.class,2L);
            System.out.println("Member member = em.getReference(Member.class, 2L);");
            System.out.println("member 인스턴스 초기화 여부: " + em.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(member));
            String username = member.getUsername();
            System.out.println("member.getUsername();");
            System.out.println("member 인스턴스 초기화 여부: " + em.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(member));
            System.out.println("memberProxy = " + member.getClass().getName());

            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    //회원과 팀 정보를 출력하는 비즈니스 로직
    public static void printUserAndTeam(Long memberId, EntityManager em) {
        Member member = em.find(Member.class, memberId);
        Team team = member.getTeam();
        System.out.println("회원 이름: " + member.getUsername());
        System.out.println("소속 팀: " + team.getName());

    }
    //회원 정보만 출력하는 비즈니스 로직
    public static void printUser(Long memberId, EntityManager em) {
        Member member = em.find(Member.class, memberId);
        System.out.println("회원 이름: "+ member.getUsername());
    }
}