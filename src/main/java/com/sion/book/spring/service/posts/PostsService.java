package com.sion.book.spring.service.posts;

import com.sion.book.spring.domain.posts.Posts;
import com.sion.book.spring.domain.posts.PostsRepository;
import com.sion.book.spring.web.dto.PostsSaveRequestDto;
import com.sion.book.spring.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException(
                "해당 게시글이 없습니다. id="+id
        ));
        posts.update();
    }
}
