package com.sion.book.spring.dto;

import com.sion.book.spring.web.dto.HelloResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name="test";
        int amount=1000;
        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        //then
        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getName()).isEqualTo(name);

    }
}
