package models;

public class Member extends User {
    private boolean isSuspended = false ;

    public Member(String id, String password, String name, boolean isSuspended) {
        super(id, password, name);
        this.isSuspended = isSuspended;
    }

    // Getters and setters
    public boolean isSuspended() { return isSuspended; }
    public void setSuspended(boolean suspended) { isSuspended = suspended; }
}
