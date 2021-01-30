package cl.jrios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "warehouses")
public class Warehouses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer warehouseId;

	@Column(name = "warehouse_name")
	private String warehouseName;

	@Column(name = "location_id")
	private String location;

	public Warehouses(Integer warehouseId, String warehouseName, String location) {
		super();
		this.warehouseId = warehouseId;
		this.warehouseName = warehouseName;
		this.location = location;
	}

	public Warehouses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
