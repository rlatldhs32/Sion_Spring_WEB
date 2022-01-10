package com.sion.book.spring.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//db접근하게 해주는 레포지토리임. 인터페이스로.
//jpareposiroty<Entity 클래스, PK타입>  상속하면 기본적인 CRUD 메소드가 자동으로 생성됨.
//Entity와 레포지토리는 함께 위치해야함. !!
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
