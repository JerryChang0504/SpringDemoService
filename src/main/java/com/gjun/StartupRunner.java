package com.gjun;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.gjun.entity.Product;
import com.gjun.service.ProductService;

@Component
public class StartupRunner implements ApplicationRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private DataSource dataSource;

	private boolean productTableExists = false;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try (Connection conn = dataSource.getConnection()) {
			DatabaseMetaData metaData = conn.getMetaData();
			System.out.println("資料庫連線成功：" + metaData.getURL());

			productTableExists = checkProductTable(metaData);

			if (productTableExists) {
				initProductDataIfEmpty();
			} else {
				System.out.println("[INFO] Product 資料表尚未建立（JPA 啟動後會自動建立）");
			}
		} catch (SQLException e) {
			System.err.println("資料庫連線失敗：" + e.getMessage());
		}
		// 確認連線是否成功
	}

	private boolean checkProductTable(DatabaseMetaData metaData) throws SQLException {
		ResultSet tables = metaData.getTables(null, null, "product", new String[] { "TABLE" });
		boolean exists = tables.next();
		System.out.println("[INFO] Product 資料表是否存在：" + exists);
		return exists;
	}

	private void initProductDataIfEmpty() {
		if (CollectionUtils.isEmpty(productService.QueryProduct())) {
			List<Product> products = List.of(new Product(null, "iPhone 15", "最新款蘋果手機", 32900, "iphone15.png"),
					new Product(null, "MacBook Pro", "蘋果筆記型電腦", 59900, "macbookpro.png"),
					new Product(null, "iPad Pro", "蘋果平板", 27900, "ipadpro.png"));
			productService.SaveProduct(products);
			System.out.println("[INFO] 已新增初始商品資料：" + products.size() + " 筆");
		} else {
			System.out.println("[INFO] Product 資料已存在，略過初始化");
		}
	}

}
