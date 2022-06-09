public class BonusService {
    public int calcBonus(int amount, boolean isRegistred) {
        int percent = isRegistred ? 3 : 1;
        long bonus = amount * percent / 100;
        long limit = 500;
        if (bonus > limit) {
            bonus = 500;
        }
        return (int) bonus;
    }
}
