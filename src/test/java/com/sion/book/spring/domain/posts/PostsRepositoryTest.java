package com.sion.book.spring.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After // Junit에서 단위 테스트가 끝날때마다 수행되는 메소드
    //테스트간을 위해서.
    public void cleanup(){
        postsRepository.deleteAll();
    }
    @Test
    @DisplayName("게시글 저장_불러오기")
    public void func(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        postsRepository.save(Posts.builder()    //디렉터리.save-> insert/update 쿼리 실행함
                    .title(title)
                .content(content)
                .author("sion@gmail.com")
                .build()
        );//id 있으면 update, 없으면 insert 실행
        //when
        List<Posts> postsList = postsRepository.findAll(); //조회해옴.
        //then
        Posts posts = postsList.get(0); //?
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}