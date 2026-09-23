package Unguided;

public abstract class WashService {
    private String id;
    private int days;
    private int units;

    

  public WashService(String id, int days) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException  ("ID cannot be null or empty");
        }
        if (days <= 0 || days > 30) {
            throw new IllegalArgumentException("Days must be positive and not exceed 30  ");
        }

        this.id = id;
        this.days = days;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    @Override
    public abstract int calculateCharge();

    public abstract int calculateCharge(int units); {
    if (units <= 1 || units > 10) {
            throw new IllegalArgumentException("Units must be between 1 and 10");
        }

        return units * calculateCharge();
    }

    public String label() {
        return "Wash";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }







}
