package servelt.model.book;

import java.sql.Date;

public class BookVo {
	private String isbn;
	private String title;
	private String catalogue;
	private String nation;
	private Date publish_date;
	private String publisher;
	private String author;
	private int price;
	private String currency;
	private String desc;
	
	public BookVo() {}
	
	public BookVo(String isbn, String title, String catalogue, String nation, Date publish_date, String publisher,
			String author, int price, String currency, String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.catalogue = catalogue;
		this.nation = nation;
		this.publish_date = publish_date;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.currency = currency;
		this.desc = desc;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "BookVo [isbn=" + isbn + ", title=" + title + ", catalogue=" + catalogue + ", nation=" + nation
				+ ", publish_date=" + publish_date + ", publisher=" + publisher + ", author=" + author + ", price="
				+ price + ", currency=" + currency + ", desc=" + desc + "]";
	}
}
