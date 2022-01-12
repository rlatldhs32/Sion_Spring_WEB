package com.sion.book.spring.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들도 칼럼으로 인식하도록
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity 클래스에 Auditing 기능 포함함
public abstract class BaseTimeEntity { //모든 Entity의 상의클래스가 되어서 entity들의 만들고 수정타임을 관리함!!
    @CreatedDate //Entity 생성되어 저장될때 시간저장됨
    private LocalDateTime createdDate;

    @LastModifiedDate//변경시간저장
    private LocalDateTime modifiedDate;
}
