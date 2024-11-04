package trythis.comp;

public class InvoiceItem {
		private String id;
		private String desc;
		private int qty;
		private double unitPrice;

		public InvoiceItem(String id, String desc, int qty, double unitPrice) {
				this.id = id;
				this.desc = desc;
				this.qty = qty;
				this.unitPrice = unitPrice;
		}

		public String getId() {
				return id;
		}

		public void setId(String id) {
				this.id = id;
		}

		public String getDesc() {
				return desc;
		}

		public void setDesc(String desc) {
				this.desc = desc;
		}

		public int getQty() {
				return qty;
		}

		public void setQty(int qty) {
				this.qty = qty;
		}

		public double getUnitPrice() {
				return unitPrice;
		}

		public void setUnitPrice(double unitPrice) {
				this.unitPrice = unitPrice;
		}

		public double getTotal() {
				return this.qty * this.unitPrice;

		}

		@Override
		public String toString() {
				return "InvoiceItem[id=%s,desc=%s,qty=%d,unitPrice=%.1f]의 구매총액은 -> %.0f".formatted(getId(), getDesc(), getQty(),
						getUnitPrice(), getTotal());
		}

		@Override
		public int hashCode() {
				return super.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
				if (this == obj) {
						return true;
				}
				if (obj == null || getClass() != obj.getClass()) {
						return false;
				}
				InvoiceItem invoiceItem = (InvoiceItem)obj;
				return this.id == invoiceItem.id && this.id.equals(invoiceItem.id);
		}
}
