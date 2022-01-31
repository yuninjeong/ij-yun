package mini;

public class CartDTO {
	
	private String cimage;
	private String cmenu;
	private String csize;
	private Object choice1;
	private Object choice2;
	private Object choice3;
	private int ccount;
	private int cprice;
	private int ctotal;
	
	
	public Object getChoice1() {
		return choice1;
	}
	public void setChoice1(Object choice1) {
		this.choice1 = choice1;
	}
	public Object getChoice2() {
		return choice2;
	}
	public void setChoice2(Object choice2) {
		this.choice2 = choice2;
	}
	public Object getChoice3() {
		return choice3;
	}
	public void setChoice3(Object choice3) {
		this.choice3 = choice3;
	}
	public int getCtotal() {
		return ctotal;
	}
	public void setCtotal(int ctotal) {
		this.ctotal = ctotal;
	}
	
	public String getCimage() {
		return cimage;
	}
	public void setCimage(String cimage) {
		this.cimage = cimage;
	}
	
	public String getCmenu() {
		return cmenu;
	}
	public void setCmenu(String cmenu) {
		this.cmenu = cmenu;
	}
	public String getCsize() {
		return csize;
	}
	public void setCsize(String csize) {
		this.csize = csize;
	}
	public int getCcount() {
		return ccount;
	}
	public void setCcount(int ccount) {
		this.ccount = ccount;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}

}
