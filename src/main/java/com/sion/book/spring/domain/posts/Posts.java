package com.sion.book.spring.domain.posts;

//import com.sion.book.spring.domain.BaseTimeEntity;
import com.sion.book.spring.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor // 기본생성자 자동추가 public Posts(){} 같은효과
@Entity //JPA 테이블과 링크될 클래스임을 나타냄 Setter 메소드를 만들지 않음.
//그러면 어떻게 DB에 값을 삽입?? -> 생성자를 통해서.값 변경이 필요한경우 그에 맞는 public 메소드 호출
//여기선 생성자 대신에 빌더 클래스.
public class Posts extends BaseTimeEntity {//실제 DB 테이블과 매칭될 클래스, 보통 Entity 클래스라고함
    @Id //PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //규칙.자동증가
    private Long id;

    @Column(length = 500, nullable=false) // 
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder //빌더 패턴 클래스 생성, 
    //생성 시점에 값을 채워주는거임. 생성자랑 비슷하지만 어떤값을 넣는지 명확하게 인지가능
    public Posts(String title,String content,String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }
    public void update(String title,String content){
        this.title=title;
        this.content=content;
    }

}
