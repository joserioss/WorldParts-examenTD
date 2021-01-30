package cl.jrios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private Integer productId;

	@Column(name = "PRODUCT_NAME")
	private String productsName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "STANDARD_COST")
	private String standardCost;

	@Column(name = "LIST_PRICE")
	private Double listPrice;

	@Column(name = "CATEGORY_ID")
	private String categoryId;

	public Products(Integer productId, String productsName, String description, String standardCost, Double listPrice,
			String categoryId) {
		super();
		this.productId = productId;
		this.productsName = productsName;
		this.description = description;
		this.standardCost = standardCost;
		this.listPrice = listPrice;
		this.categoryId = categoryId;
	}

	public Products() {
		super();
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductsName() {
		return productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStandarCost() {
		return standardCost;
	}

	public void setStandarCost(String standardCost) {
		this.standardCost = standardCost;
	}

	public Double getListPrice() {
		return listPrice;
	}

	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}
