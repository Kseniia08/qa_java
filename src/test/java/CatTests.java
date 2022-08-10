import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTests {
    Feline feline = new Feline();

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
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Cat cat = new Cat(feline);
        List <String> actual = cat.getFood();
        assertEquals("eatMeatList is correct",expected, actual);
    }

    //Тест на проверку, что список еды Хищника включает в себя Рыбу
    @Test
    public void eatMeatContainsFishInListOfPredatorFoodForLionTest() throws Exception {
        String fish = "Рыба";
        Cat cat = new Cat(feline);
        boolean actual = cat.getFood().contains(fish);
        Assert.assertTrue("Fish is a part of getFood", actual);
    }

    //Тест на проверку, что список еды Хищника включает в себя Птиц
    @Test
    public void eatMeatContainsBirdsInListOfPredatorFoodForLionTest() throws Exception {
        String birds = "Птицы";
        Cat cat = new Cat(feline);
        boolean actual = cat.getFood().contains(birds);
        Assert.assertTrue("Birds are a part of getFood",actual);
    }

    //Тест на проверку, что список еды Хищника включает в себя Животных
    @Test
    public void eatMeatContainsAnySmallAnimalsInListOfPredatorFoodTest() throws Exception {
        String anySmallAnimals = "Птицы";
        Cat cat = new Cat(feline);
        boolean actual = cat.getFood().contains(anySmallAnimals);
        Assert.assertTrue("Any small animals are a part of eatMeatList",actual);
    }



}
