package com.gjun.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
@Schema(description = "會員資料傳入值")
public class Product extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer id;

	@Schema(description = "產品名稱", example = "電腦")
	@Column(name = "product_name")
	private String name;

	@Schema(description = "產品描述", example = "MAC")
	@Column(name = "product_description")
	private String description;

	@Schema(description = "產品價格", example = "27900")
	@Column(name = "product_price")
	private Integer price;

	@Schema(description = "產品照片", example = "iphone15.png")
	@Column(name = "product_image")
	private String image;

}
