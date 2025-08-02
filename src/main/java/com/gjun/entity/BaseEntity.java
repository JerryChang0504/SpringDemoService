package com.gjun.entity;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass // 表示這不是一張資料表，但會被繼承的 Entity 當作基礎欄位
@EntityListeners(AuditingEntityListener.class) // 啟用 JPA的自動時間監聽功能
                                               // （需開啟@EnableJpaAuditing）
public class BaseEntity {

  @CreatedDate // 當 Entity 第一次儲存時自動填入時間
  @Column(updatable = false) // 此欄位建立後不可被更新
  protected LocalDateTime createdAt;

  @LastModifiedDate // 每次更新時會自動填入目前時間
  protected LocalDateTime updatedAt;
}


