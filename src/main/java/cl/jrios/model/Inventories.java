package cl.jrios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventories")
public class Inventories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer inventoriesId;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "inventories_products_FK"))
	private Products productId;

	@ManyToOne
	@JoinColumn(name = "warehouse_id", nullable = false, foreignKey = @ForeignKey(name = "inventories_warehouses_FK"))
	private Warehouses warehouseId;

	@Column(name = "quantity")
	private String quantity;

	public Inventories(Integer inventoriesId, Products productId, Warehouses warehouseId, String quantity) {
		super();
		this.inventoriesId = inventoriesId;
		this.productId = productId;
		this.warehouseId = warehouseId;
		this.quantity = quantity;
	}

	public Inventories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getInventoriesId() {
		return inventoriesId;
	}

	public void setInventoriesId(Integer inventoriesId) {
		this.inventoriesId = inventoriesId;
	}

	public Products getProductId() {
		return productId;
	}

	public void setProductId(Products productId) {
		this.productId = productId;
	}

	public Warehouses getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Warehouses warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
