package com.sion.book.spring.web.dto;

import com.sion.book.spring.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content,String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
//Entity는 안건듬.
//Emtity와, DB에서 쓸 Dto는 따로 사용.