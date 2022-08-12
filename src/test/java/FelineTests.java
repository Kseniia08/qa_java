import com.example.Feline;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;


@RunWith(Parameterized.class)
public class FelineTests {

    Feline feline = new Feline();

    //Тест на проверку списка еды для Хищника (семейство кошачьих - хищники)
    @Test
    public void eatMeatReturnsListOfPredatorFoodTest() throws Exception {
        List <String> expected = List.of("Животные", "Птицы", "Рыба");
        List <String> actual = feline.eatMeat();
        assertEquals("eatMeatList is correct",expected, actual);
    }

    //Тест на семейство Кошачьих
    @Test
    public void getFamilyReturnsFelineFamilyTest() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals("getFamily for Feline is 'Кошачьи'", expected, actual);

    }

    //Тест на метод getKittens()
    @Test
    public void getKittensReturnsKittenCountTest() {
        int expectedReturn = 1;
        int actualReturn = feline.getKittens();
        assertEquals("Must return default kittens count. It's int=1", expectedReturn, actualReturn);

    }

    //Тест на метод getKittens(int kittensCount) с параметризацией
    private final int numberKittens;
    public FelineTests(int numberKittens) {
        this.numberKittens = numberKittens;
    }

    @Parameterized.Parameters
    public static Object getNumberKittens() {
        return new Object[][] {
                {0},
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
        };
    }

    @Test
    public void getKittensReturnsKittenCountParametrizedTest() {
        int expectedReturn = numberKittens;
        int actualReturn = feline.getKittens(numberKittens);
        assertEquals("Must return kittens count", expectedReturn, actualReturn);
    }

}
