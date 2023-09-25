package jpabook.model;

import jpabook.model.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

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

            //회원, 상품 생성 및 저장
//            Member member = new Member("김이름","서울시","XX로","00빋딩");
//            em.persist(member);
//
//            Item item1 = new Item("과자",1000,10);
//            Item item2 = new Item("음료수",2000,10);
//            em.persist(item1);
//            em.persist(item2);

            //주문, 주문상품 생성 및 저장
//            Member member = em.find(Member.class,1L);
//            Item item1 = em.find(Item.class,2L);
//            Order order = new Order();
//            order.setStatus(OrderStatus.ORDER);
//            order.setMember(member);
//            order.setOrderDate(new Date(System.currentTimeMillis()));
//
//            OrderItem orderItem = new OrderItem();
//            orderItem.setItem(item1);
//            orderItem.setCount(2);
//            orderItem.setOrderPrice(2000);
//            orderItem.setOrder(order);
//
//            em.persist(order);
//            em.persist(orderItem);
//            tx.commit();//트랜잭션 커밋

            //객체 그래프 탐색 1
//            Order order = em.find(Order.class, 4L);
//            Member member = order.getMember();
//            System.out.println("주문한 회원 이름: "+ member.getName());

            //객체 그래프 탐색 2
            Order order = em.find(Order.class,4L);
            Member member = order.getMember();
            OrderItem orderItem = order.getOrderItems().get(0);
            Item item = orderItem.getItem();
            System.out.println("주문 회원 정보 : "+member.getName());
            System.out.println("주문 회원 주소 : "+member.getCity()+" "+member.getStreet()+" "+member.getZipcode());
            System.out.println("주문 상품 : " + item.getName());
            System.out.println("주문 개수 : " + orderItem.getCount()+"개");
            System.out.println("주문 가격 : " + orderItem.getOrderPrice()+"원");
        } catch (Exception e) {
            e.printStackTrace();

            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }
        emf.close(); //엔티티 매니저 팩토리 종료
    }

}
