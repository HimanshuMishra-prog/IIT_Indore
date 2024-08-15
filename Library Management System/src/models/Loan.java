package models;

public class Loan {
    private Book book;
    private Member member;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
    }

    // Getters and setters
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }
}
