package cl.jrios.dto;

public class EntidadFiltradoDTO {

	private Integer warehouseId;
	private Integer productCategoriesId;

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getProductCategoriesId() {
		return productCategoriesId;
	}

	public void setProductCategoriesId(Integer productCategoriesId) {
		this.productCategoriesId = productCategoriesId;
	}

	@Override
	public String toString() {
		return "EntidadFiltradoDTO [warehouseId=" + warehouseId + ", productCategoriesId=" + productCategoriesId + "]";
	}

}
