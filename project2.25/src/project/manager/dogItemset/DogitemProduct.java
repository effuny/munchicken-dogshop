package project.manager.dogItemset;

public class DogitemProduct {
	
	
	int newnum;
	String newname;
	String newprice;
	String newinfor;
	String newtoyimg;
	
	public DogitemProduct() {
		
	}
	
	public DogitemProduct(Integer newnum, String newname, String newprice, String newinfor, String newtoyimg) {
		super();
		this.newnum = newnum;
		this.newname = newname;
		this.newprice = newprice;
		this.newinfor = newinfor;
		this.newtoyimg = newtoyimg;
		
	}
	



	public int getNewnum() {
		return newnum;
	}

	public void setNewnum(int newnum) {
		this.newnum = newnum;
	}

	public String getNewname() {
		return newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public String getNewprice() {
		return newprice;
	}

	public void setNewprice(String newprice) {
		this.newprice = newprice;
	}

	public String getNewinfor() {
		return newinfor;
	}

	public void setNewinfor(String newinfor) {
		this.newinfor = newinfor;
	}

	public String getNewtoyimg() {
		return newtoyimg;
	}

	public void setNewtoyimg(String newtoyimg) {
		this.newtoyimg = newtoyimg;
	}
}