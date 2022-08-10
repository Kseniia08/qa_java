import com.example.Feline;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;


/*@RunWith(MockitoJUnitRunner.class)*/
public class FelineTests {

    Feline feline = new Feline();

    //Тест на проверку списка еды для Хищника (семейство кошачьих - хищники)
    @Test
    public void eatMeatReturnsListOfPredatorFoodTest() throws Exception {
        List <String> expected = List.of("Животные", "Птицы", "Рыба");
        List <String> actual = feline.eatMeat();
        assertEquals("eatMeatList is correct",expected, actual);
    }

    //Тест на проверку, что список еды Хищника включает в себя Рыбу
    @Test
    public void eatMeatContainsFishInListOfPredatorFoodTest() throws Exception {
        String fish = "Рыба";
        boolean actual = feline.eatMeat().contains(fish);
        Assert.assertTrue("Fish is a part of eatMeatList", actual);
    }

    //Тест на проверку, что список еды Хищника включает в себя Птиц
    @Test
    public void eatMeatContainsBirdsInListOfPredatorFoodTest() throws Exception {
        String birds = "Птицы";
        boolean actual = feline.eatMeat().contains(birds);
        Assert.assertTrue("Birds are a part of eatMeatList",actual);
    }

    //Тест на проверку, что список еды Хищника включает в себя Животных
    @Test
    public void eatMeatContainsAnySmallAnimalsInListOfPredatorFoodTest() throws Exception {
        String anySmallAnimals = "Птицы";
        boolean actual = feline.eatMeat().contains(anySmallAnimals);
        Assert.assertTrue("Any small animals are a part of eatMeatList",actual);
    }


    //Проверка кейса, когда список еды хищника изменили
    /*@Spy
    Feline someFeline = new Feline();
    @Test
    public void eatMeatShouldReturnListObject() throws Exception {
        List <String> someEatMeatList = List.of("first", "second", "third");
        Mockito.doReturn(someEatMeatList).when(someFeline).getFood(Mockito.anyString());
        assertEquals(someEatMeatList, someFeline.eatMeat());
    }*/

    //Тест на исключение
    @Test (expected = Exception.class)
    public void getFoodReturnsException() throws Exception {
        feline.getFood(Mockito.anyString());
    }

    //Тест на семейство Кошачьих
    @Test
    public void getFamilyReturnsFelineFamilyTest() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals("getFamily for Feline is 'Кошачьи'", expected, actual);

    }



    @Test
    public void getKittensReturnsKittenCount() {
        int expectedReturn = 3;
        int actualReturn = feline.getKittens(3);

        assertEquals("Must return kittens count", expectedReturn, actualReturn);

    }

}
