import org.junit.Assert;
import org.junit.Test;

public class TestBankomatu {

    @Test
    public void testWplaty(){
        Bankomat atm = new Bankomat();
        atm.wplataPieniedzy(200);
        Assert.assertTrue(atm.pokazSaldo() == 200);

        atm.wplataPieniedzy(-200);
        Assert.assertTrue(atm.pokazSaldo() == 200);
    }
    @Test
    public void testWyplaty(){
        Bankomat atm = new Bankomat();
        atm.wyplataPieniedzy(200);
        Assert.assertTrue(atm.pokazSaldo() == 0);

        atm.wplataPieniedzy(200);
        Assert.assertTrue(atm.pokazSaldo() == 200);

        atm.wyplataPieniedzy(100);
        Assert.assertTrue(atm.pokazSaldo() == 100);

    }
}
