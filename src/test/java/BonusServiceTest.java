import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calcBonus((int) amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calcBonus((int) amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void unregisteredUserLimits() {
        BonusService service = new BonusService();
        long amount = 49_900;
        boolean registred = false;
        long expected = 499;

        long actual = service.calcBonus((int) amount, registred);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void registeredUserLimits() {
        BonusService service = new BonusService();
        long amount = 16_643;
        boolean registred = true;
        long expected = 499;

        long actual = service.calcBonus((int) amount, registred);

        Assertions.assertEquals(expected, actual);
    }


    @Test
    void zeroCheckRegistred() {
        BonusService service = new BonusService();
        long amount = 0;
        boolean registred = true;
        long expected = 0;

        long actual = service.calcBonus((int) amount, registred);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void zeroCheckUnegistred() {
        BonusService service = new BonusService();
        long amount = 0;
        boolean registred = false;
        long expected = 0;

        long actual = service.calcBonus((int) amount, registred);

        Assertions.assertEquals(expected, actual);
    }
}