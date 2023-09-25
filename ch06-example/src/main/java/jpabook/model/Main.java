package jpabook.model;

import jpabook.model.manytomany2.MemberEntity;
import jpabook.model.manytomany2.MemberProduct;
import jpabook.model.manytomany2.MemberProductId;
import jpabook.model.manytomany2.ProductEntity;
import jpabook.model.manytomany3.Member;
import jpabook.model.manytomany3.Order;
import jpabook.model.manytomany3.Product;

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
//            MemberOTO member = new MemberOTO();
//            Team team = new Team();
//            member.setUsername("김유저");
//            team.setName("팀1");
//            member.setTeam(team);

//            em.persist(team);
//            em.persist(member);

            // 멤버2 생성
//            MemberOTO member = new MemberOTO();
//            member.setUsername("박유저");
//            Team team = em.find(Team.class, 1L);
//            member.setTeam(team);
//
//            em.persist(member);

            // 팀1 삭제 시도
//            Team team = em.find(Team.class, 1L);
//            List<MemberOTO> members = team.getMembers();
//            for (MemberOTO member : members) {
//                member.setTeam(null);
//            }
//            em.remove(team);

            //예제 6.5 일대다 단방향 회원 엔티티
//            MemberTwo member1 = new MemberTwo("member1");
//            MemberTwo member2 = new MemberTwo("member2");
//
//            TeamTwo team1 = new TeamTwo("team1");
//            team1.getMembers().add(member1);
//            team1.getMembers().add(member2);
//
//            em.persist(member1); //INSERT - member1
//            em.persist(member2); //INSERT - member2
//            em.persist(team1); //INSERT - team1, UPDATE - member1.fk, member2.fk

            //예제 6.15 저장
//            Product productA = new Product();
//            productA.setId("productA");
//            productA.setName("상품A");
//            em.persist(productA);
//
//            MemberMTM member1 = new MemberMTM();
//            member1.setId("member1");
//            member1.setUsername("회원1");
//            member1.getProducts().add(productA); //연관관계 설정
//            em.persist(member1);


            //에제 6.16 탐색
//            MemberMTM member = em.find(MemberMTM.class, "member1");
//            List<Product> products = member.getProducts(); //객체그래프 탐색
//            for(Product product : products) {
//                System.out.println("product.name = "+product.getName());
//            }

            //예제 6.17 역방향 추가 후
//            MemberMTM member = em.find(MemberMTM.class, "member1");
//            Product product = em.find(Product.class,"productA");
//            member.addProduct(product);
//

            //예제 6.18 역방향 탐색
//            Product product = em.find(Product.class, "productA");
//            List<MemberMTM> members = product.getMembers();
//            for(MemberMTM member : members) {
//                System.out.println("member = "+ member.getUsername());
//            }

            //예제 6.19 ~ 6.23
//            //회원저장
//            MemberEntity member1 = new MemberEntity();
//            member1.setId("member1");
//            member1.setUsername("회원1");
//            em.persist(member1);
//
//            //상품저장
//            ProductEntity productA = new ProductEntity();
//            productA.setId("productA");
//            productA.setName("상품A");
//            em.persist(productA);
//
//            //회원상품 저장
//            MemberProduct memberProduct = new MemberProduct();
//            memberProduct.setMember(member1);   //주문 회원 - 연관관계 설정
//            memberProduct.setProduct(productA); //주문 상품 - 연관관계 설정
//            memberProduct.setOrderAmount(2);    //주문 수량
//            em.persist(memberProduct);

            //예제 6.24 조회 코드
//            //기본 키 값 생성
//            MemberProductId memberProductId = new MemberProductId();
//            memberProductId.setMember("member1");
//            memberProductId.setProduct("productA");
//
//            MemberProduct memberProduct = em.find(MemberProduct.class, memberProductId);
//
//            MemberEntity member = memberProduct.getMember();
//            ProductEntity product = memberProduct.getProduct();
//
//            System.out.println("member = "+member.getUsername());
//            System.out.println("product = "+product.getName());
//            System.out.println("orderAmount = "+memberProduct.getOrderAmount());

            //예제 6.27 저장 코드
//            //회원 저장
//            Member member1 = new Member();
//            member1.setId("member1");
//            member1.setUsername("회원1");
//            em.persist(member1);
//
//            //상품 저장
//            Product productA = new Product();
//            productA.setId("productA");
//            productA.setName("상품A");
//            em.persist(productA);
//
//            //주문 저장
//            Order order = new Order();
//            order.setMember(member1);
//            order.setProduct(productA);
//            order.setOrderAmount(2);
//            em.persist(order);

            //예제 6.28 조회코드
//            Long orderId = 1L;
//            Order order = em.find(Order.class,orderId);
//
//            Member member = order.getMember();
//            Product product = order.getProduct();
//
//            System.out.println("member = "+member.getUsername());
//            System.out.println("product = "+product.getName());
//            System.out.println("orderAmount = "+ order.getOrderAmount());
//
//            List<Order> orders = member.getOrders();
//            for(Order order1 : orders) {
//                System.out.println("order = "+order1.getId());
//            }

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
