package shop.jy.DTO;

public class guestBuyDTO {
	private String no;
	private String title;
	private int quantity;
	private int price;
	private int total;
	private int lasttotal;
	
	private String name;//이아래 부턴 테이블 뷰로 에들어갈 변수
	private String tel;
	private String addr;
	
	
	public int getLasttotal() {
		return lasttotal;
	}
	public void setLasttotal(int lasttotal) {
		this.lasttotal = lasttotal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
