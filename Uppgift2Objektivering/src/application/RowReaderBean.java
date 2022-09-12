package application;

public class RowReaderBean {

	// states
	String OrderDate;
	String Rep1;
	String Rep2;
	String Item;
	String Units;
	String UnitCost;
	String Total;
	
	public RowReaderBean(String orderDate, String region, String rep1, String rep2, String item, String units,
			String unitCost, String total) {
		super();
		OrderDate = orderDate;
		Region = region;
		Rep1 = rep1;
		Rep2 = rep2;
		Item = item;
		Units = units;
		UnitCost = unitCost;
		Total = total;
	}
	
	String Region;
	public String getOrderDate() {
		return OrderDate;
	}
	public String getRegion() {
		return Region;
	}
	public String getRep1() {
		return Rep1;
	}
	public String getRep2() {
		return Rep2;
	}
	public String getItem() {
		return Item;
	}
	public String getUnits() {
		return Units;
	}
	public void setUnitCost(String unitCost) {
		UnitCost = unitCost;
	}
	public String getUnitCost() {
		return UnitCost;
	}
	public String getTotal() {
		return Total;
	}
	
	public void setTotal(String total) {
		Total = total;
	}
}
