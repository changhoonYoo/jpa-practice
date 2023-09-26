package org.example;

import org.example.entity.Parent;
import org.example.entity.ParentId;
import org.example.entity.item.Book;
import org.example.entity.item.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

            //책 저장
//            Book book = new Book();
//            book.setAuthor("저자");
//            book.setIsbn("A01");
//            book.setName("책1");
//            book.setPrice(10000);
//            em.persist(book);
            //조인 전략: insert 두번
            //단일 테이블 전략: insert 한번

            //책 & 상품 조회
//            Book book = em.find(Book.class, 1L);
//            System.out.println("book.name= "+book.getName());

            //단일 테이블 전략: select * from item where item_id = ? and dtype='B'

//            Item item = em.find(Item.class, 1L);
//            System.out.println("item.getName= "+item.getName());
            //조인 전략: left outer join 세번
            //단일 테이블 전략: 조인 x


            //---------------------------------------------------------------//

            //예제 7.7 식별자 클래스 복합키 엔티티 저장
//            Parent parent = new Parent();
//            parent.setId1("myId1");
//            parent.setId2("myId2");
//            parent.setName("parentName");
//            em.persist(parent);

            //복합키로 조회
//            ParentId parentId = new ParentId("myId1","myId2");
//            Parent parent = em.find(Parent.class,parentId);

            //@EmbeddedId 사용 엔티티 저장
//            Parent parent = new Parent();
//            ParentId parentId = new ParentId("myId1","myId2");
//            parent.setId(parentId);
//            parent.setName("parentName");
//            em.persist(parent);

            //@EmbeddedId 사용 엔티티 조회
            ParentId parentId = new ParentId("myId1","myId2");
            Parent parent = em.find(Parent.class,parentId);
            System.out.println("parent.getName()= "+parent.getName());

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
