package com.sion.book.spring.service.posts;

import com.sion.book.spring.domain.posts.Posts;
import com.sion.book.spring.domain.posts.PostsRepository;
import com.sion.book.spring.web.dto.PostsResponseDto;
import com.sion.book.spring.web.dto.PostsSaveRequestDto;
import com.sion.book.spring.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional//dto를 받고, 그 dto에 있는대로 postsRepository를 변경
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    //id받고, request dto 받고, posts의 id가 있으면, 받아온 요청 dto의 이름과 컨텐트로 업데이트
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException(
                "해당 게시글이 없습니다. id="+id
        ));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    } // id로 찾는거 :
    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}
