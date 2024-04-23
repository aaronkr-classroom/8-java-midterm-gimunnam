public class LibrarySystem {
    // 변수 정의
    private LibraryBook[] booklist;
    private int bookCount;

    // 생성자 정의

    public void addBook(Book book) {
        // 책 추가
        // 도움을 위해 Cart.java의 insertBook(Book book)을 참조하세요
        if (booklist == null) {
            booklist = new LibraryBook[10];
        }
        if (bookCount >= booklist.length) {
            expandBookList();
        }
        booklist[bookCount++] = new LibraryBook(book);
    }
    
    private void expandBookList() {
        LibraryBook[] newBooklist = new LibraryBook[booklist.length * 2]; // 현재 배열 크기의 두 배로 새 배열 생성
        for (int i = 0; i < booklist.length; i++) {
            newBooklist[i] = booklist[i]; // 기존 요소를 새 배열로 복사
        }
        booklist = newBooklist; // 새 배열을 기존 배열로 설정
    }

    public void removeBook(String title) {
        // 책 삭제
        for (int i = 0; i < bookCount; i++) {
            if (booklist[i].getTitle().equals(title)) {
                // 책이 발견되면 해당 책부터 시작하여 모든 요소를 왼쪽으로 이동합니다.
                for (int j = i; j < bookCount - 1; j++) {
                    booklist[j] = booklist[j + 1];
                }
                // 마지막 요소를 null로 설정하고 bookCount를 줄입니다.
                booklist[--bookCount] = null;
                System.out.println("라이브러리에서 '" + title + "' 삭제했습니다.");
                return; // 책 제거 후 종료 방법
            }
        }
        // 찾을 수 없으면 메시지를 인쇄합니다.
        System.out.println("# 오류: '" + title + "' 못 찾았습니다!");
    }

    public void borrowBook(String title) {
        // 책 대출
        for (int i = 0; i < bookCount; i++) {
            if (booklist[i].getTitle().equals(title)) {
                if (booklist[i].isAvailable()) {
                    booklist[i].setAvailable(false); // 대출 불가로 설정
                    System.out.println("'" + title + "' 책을 대출했습니다.");
                } else {
                    System.out.println("'" + title + "' 책은 이미 대출 중입니다.");
                }
                return;
            }
        }
        // 찾을 수 없으면 메시지를 인쇄합니다.
        System.out.println("# 오류: '" + title + "' 못 찾았습니다!");
    }

    public void returnBook(String title) {
        // 책 반납
        for (int i = 0; i < bookCount; i++) {
            if (booklist[i].getTitle().equals(title)) {
                if (!booklist[i].isAvailable()) {
                    booklist[i].setAvailable(true); // 대출 가능으로 설정
                    System.out.println("'" + title + "' 책을 반납했습니다.");
                } else {
                    System.out.println("'" + title + "' 책은 이미 도서관에 있습니다.");
                }
                return;
            }
        }
        // 찾을 수 없으면 메시지를 인쇄합니다.
        System.out.println("# 오류: '" + title + "' 못 찾았습니다!");
    }

    public void displayAllBooks() {
        // 책 목록 출력 (책이름, 저자, 출판년도, 대출가능여부 출력)
        if (bookCount == 0) {
            System.out.println("도서관에 책이 없습니다.");
            return;
        }
        System.out.println("도서관에 있는 모든 책:");
        for (int i = 0; i < bookCount; i++) {
            LibraryBook book = booklist[i];
            System.out.println(book.getIsbn() + " | " + book.getTitle() + " | " + book.getAuthor() + " | " + book.getYear() + " | " + (book.isAvailable() ? "Available" : "Out"));
        }
    }
}