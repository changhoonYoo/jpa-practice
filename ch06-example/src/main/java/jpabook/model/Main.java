package jpabook.model;

import jpabook.model.entity.Member;
import jpabook.model.entity.MemberTwo;
import jpabook.model.entity.Team;
import jpabook.model.entity.TeamTwo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by 1001218 on 15. 4. 5..
 */
public class Main {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            //TODO 비즈니스 로직

            // 멤버 및 팀 생성
//            Member member = new Member();
//            Team team = new Team();
//            member.setUsername("김유저");
//            team.setName("팀1");
//            member.setTeam(team);

//            em.persist(team);
//            em.persist(member);

            // 멤버2 생성
//            Member member = new Member();
//            member.setUsername("박유저");
//            Team team = em.find(Team.class, 1L);
//            member.setTeam(team);
//
//            em.persist(member);

            // 팀1 삭제 시도
//            Team team = em.find(Team.class, 1L);
//            List<Member> members = team.getMembers();
//            for (Member member : members) {
//                member.setTeam(null);
//            }
//            em.remove(team);

            //예제 6.5 일대다 단방향 회원 엔티티
            MemberTwo member1 = new MemberTwo("member1");
            MemberTwo member2 = new MemberTwo("member2");

            TeamTwo team1 = new TeamTwo("team1");
            team1.getMembers().add(member1);
            team1.getMembers().add(member2);

            em.persist(member1); //INSERT - member1
            em.persist(member2); //INSERT - member2
            em.persist(team1); //INSERT - team1, UPDATE - member1.fk, member2.fk

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
