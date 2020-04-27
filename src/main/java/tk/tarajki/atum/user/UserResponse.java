package tk.tarajki.atum.user;

public class UserResponse {
    private Long id;
    private boolean operationStatus;

    public UserResponse(Long id, boolean operationStatus) {
        this.id = id;
        this.operationStatus = operationStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(boolean operationStatus) {
        this.operationStatus = operationStatus;
    }
}
