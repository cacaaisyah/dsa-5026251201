package Lw01.Unguided;

public class CarWash extends WashService {
    private static final int FIRST_TIER_DAYS = 3;
    private static final int FIRST_TIER_RATE = 35000;
    private static final int NEXT_TIER_RATE = 25000;
    private static final int SETUP_FEE = 15000;

    public CarWash(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int days = getDays();
        int firstTier = Math.min(days, FIRST_TIER_DAYS);
        int beyondTier = Math.max(0, days - FIRST_TIER_DAYS);
        return firstTier * FIRST_TIER_RATE + beyondTier * NEXT_TIER_RATE + SETUP_FEE;
    }

    @Override
    public String label() {
        return "Car";
    }
}