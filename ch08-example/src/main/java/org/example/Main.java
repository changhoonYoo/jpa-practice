package org.example;

import org.example.entity.Child;
import org.example.entity.Member;
import org.example.entity.Parent;
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
//
//            printUserAndTeam(2L,em); //회원 및 팀 정보 출력
//            printUser(2L,em); // 회원의 정보 출력

//            Member member = em.getReference(Member.class,2L);
//            System.out.println("Member member = em.getReference(Member.class, 2L);");
//            System.out.println("member 인스턴스 초기화 여부: " + em.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(member));
//            String username = member.getUsername();
//            System.out.println("member.getUsername();");
//            System.out.println("member 인스턴스 초기화 여부: " + em.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(member));
//            System.out.println("memberProxy = " + member.getClass().getName());

//            지연 로딩 실행 코드
//            Member member = em.find(Member.class,2L);
//            Team team = member.getTeam(); // team 멤버변수에 프록시 객체를 넣어둠 -> DB 조회 x
//            System.out.println("Team team = member.getTeam();");
//            System.out.println("team.getName();" + team.getName()); // 팀 객체 실제 사용 -> DB 조회 o

//            saveNoCascade(em); //부모,자식 저장 (영속성 전이 x)
//            saveWithCascade(em); //부모,자식 저장 (영속성 전이 o)

//            deleteNoCascade(em); //부모,자식 삭제 (영속성 전이 x)
//            deleteWithCascade(em); //부모,자식 삭제 (영속성 전이 o)

//            Parent parent1 = em.find(Parent.class, 1L);
//            parent1.getChildren().clear(); // 고아객체 자동 제거 orphanRemoval = true

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    //회원과 팀 정보를 출력하는 비즈니스 로직
    private static void printUserAndTeam(Long memberId, EntityManager em) {
        Member member = em.find(Member.class, memberId);
        Team team = member.getTeam();
        System.out.println("회원 이름: " + member.getUsername());
        System.out.println("소속 팀: " + team.getName());

    }
    //회원 정보만 출력하는 비즈니스 로직
    private static void printUser(Long memberId, EntityManager em) {
        Member member = em.find(Member.class, memberId);
        System.out.println("회원 이름: "+ member.getUsername());
    }
    //부모 자식 저장 (영속성 전이 x)
    private static void saveNoCascade(EntityManager em) {
        //부모 저장
        Parent parent = new Parent();
        em.persist(parent);

        //1번 자식 저장
        Child child1 = new Child();
        child1.setParent(parent); //자식 -> 부모 연관관계 설정
        parent.getChildren().add(child1);
        em.persist(child1);

        //2번 자식 저장
        Child child2 = new Child();
        child2.setParent(parent);
        parent.getChildren().add(child2);
        em.persist(child2);
    }
    //부모 자식 저장 (영속성 전이 o)
    private static void saveWithCascade(EntityManager em) {
        Child child1 = new Child();
        Child child2 = new Child();

        Parent parent = new Parent();
        child1.setParent(parent);
        child2.setParent(parent);
        parent.getChildren().add(child1);
        parent.getChildren().add(child2);

        //부모 저장, 연관된 자식들 저장
        em.persist(parent);
    }

    private static void deleteNoCascade(EntityManager em) {
        Parent findParent = em.find(Parent.class, 3L);
        Child findChild1 = em.find(Child.class, 4L);
        Child findChild2 = em.find(Child.class, 5L);

        em.remove(findChild1);
        em.remove(findChild2);
        em.remove(findParent);
    }
    private static void deleteWithCascade(EntityManager em) {
        Parent findParent = em.find(Parent.class, 6L);
        em.remove(findParent);
    }
}