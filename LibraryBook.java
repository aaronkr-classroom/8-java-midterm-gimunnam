
public class LibraryBook {

	private String isbn;
	private String title;
	private String author;
	private int year;
	private boolean available;

	public LibraryBook(Book book) {
		this.isbn = book.getIsbn();
	    this.title = book.getTitle();
	    this.author = book.getAuthor();
	    this.year = book.getYear();
	    this.available = true;
	}

	public LibraryBook(String isbn, String title, String author, int year) {
		 this.isbn = isbn;
		    this.title = title;
		    this.author = author;
		    this.year = year;
		    this.available = true;
	}

	
}
