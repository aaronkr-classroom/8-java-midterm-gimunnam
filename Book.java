
public interface Book {
	String getIsbn();
	String getTitle();
	String getAuthor();
	int getYear();
	boolean isAvailable();
	void setAvailable(boolean available);
}
