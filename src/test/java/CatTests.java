import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {
    //Создаем заглушку
    @Mock
    Feline feline;

    //Позитивный сценарий с Мяу
    @Test
    public void checkingSoundsOfCatPositiveTest() {
        Cat cat = new Cat(feline);
        String actualSound = cat.getSound();
        String expectedSound = "Мяу";
        Assert.assertEquals("Sounds are similar", expectedSound, actualSound);
    }

    //Негативный сценарий с Мяу
    @Test
    public void checkingSoundsOfCatNegativeTest() {
        Cat cat = new Cat(feline);
        String actualSound = cat.getSound();
        String expectedSound = "Гав";
        Assert.assertNotEquals("Sounds are not similar", expectedSound, actualSound);
    }

    //Тест на проверку списка еды для Хищника (семейство кошачьих - хищники)
    @Test
    public void eatMeatReturnsListOfPredatorFoodForLionTest() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List <String> actual = cat.getFood();
        assertEquals("eatMeatList is correct",List.of("Животные", "Птицы", "Рыба"), actual);
    }


}
