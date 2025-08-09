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

	@Column(name = "product_description")
	@Schema(description = "產品敘述", example = "MAC")
	private String description;

	@Column(name = "product_price")
	@Schema(description = "產品價格", example = "1000")
	private Integer price;

	@Column(name = "product_image")
	@Schema(description = "產品圖片路徑", example = "macbookpro.png")
	private String image;

}
