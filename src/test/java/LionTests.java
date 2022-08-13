import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    Feline feline = new Feline();
    //Тест с заглушкой
    @Test
    public void getKittensForLionTests() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualGetKittens = lion.getKittens();
        assertEquals("getKittens with mock returns default int 1",1, actualGetKittens);
    }

    //Тест на проверку списка еды для Хищника (семейство кошачьих - хищники) c заглушкой
    @Test
    public void eatMeatReturnsListOfPredatorFoodForLionTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        System.out.println(feline.getFood("Хищник"));
        List <String> actual = lion.getFood();
        assertEquals("eatMeatList is correct",List.of("Животные", "Птицы", "Рыба"), actual);
    }


    //Тест на проверку, что список еды Хищника включает в себя Рыбу с заглушкой
    @Test
    public void eatMeatContainsFishInListOfPredatorFoodForLionTest() throws Exception {
        String fish = "Рыба";
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        boolean actual = lion.getFood().contains(fish);
        Assert.assertTrue("Fish is a part of getFood", actual);
    }

    //Тест на проверку, что список еды Хищника включает в себя Птиц с заглушкой
    @Test
    public void eatMeatContainsBirdsInListOfPredatorFoodForLionTest() throws Exception {
        String birds = "Птицы";
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        boolean actual = lion.getFood().contains(birds);
        Assert.assertTrue("Birds are a part of getFood",actual);
    }

    //Тест на проверку, что список еды Хищника включает в себя Животных с заглушкой
    @Test
    public void eatMeatContainsAnySmallAnimalsInListOfPredatorFoodTest() throws Exception {
        String anySmallAnimals = "Птицы";
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        boolean actual = lion.getFood().contains(anySmallAnimals);
        Assert.assertTrue("Any small animals are a part of eatMeatList",actual);
    }

    //Проверка исключения
    @Test (expected = Exception.class)
    public void testConstructorException() throws Exception {
        try {
            Lion lion = new Lion("Оно", new Feline());
        } catch (Exception exception) {
            String expected = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals("You are catch exception", expected, exception.getMessage());
            throw exception;
        }
    }

    //Проверка на Самку
    @Test
    public void checkingFemaleSexOfLion() throws Exception {
            Lion lion = new Lion("Самка", feline);
            boolean actualSex = lion.doesHaveMane();
            Assert.assertFalse( "The lion is a female" , actualSex);
    }

    //Проверка на Самца
    @Test
    public void checkingMaleSexOfLion() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean actualSex = lion.doesHaveMane();
        Assert.assertTrue( "The lion is a male" , actualSex);
    }

}
