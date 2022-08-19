package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository
    private HeroRepository heroRepository;
    private Hero hero;

    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
        hero = new Hero("Desi", 2);
    }
    //create(Hero)
    //1. hero == null
    @Test(expected = NullPointerException.class)
    public void testCreateHeroIsNull() {
        heroRepository.create( null);

    }
    //2. duplicate name
    @Test (expected = IllegalArgumentException.class)
    public void testCreateHeroWithDuplicateName() {
     this.heroRepository.create(this.hero);
     this.heroRepository.create(this.hero);
    }
    //3. successful
    @Test
    public void testCreateSuccessfulHeroAndGetCount() {
        Assert.assertEquals(0, heroRepository.getCount());
        this.heroRepository.create(this.hero);
        Assert.assertEquals(1, heroRepository.getCount());
        Hero createdHero = this.heroRepository.getHero("Desi");

        Assert.assertEquals(createdHero.getName(), this.hero.getName());
        Assert.assertEquals(createdHero.getLevel(), this.hero.getLevel());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveWithNullName() {
        this.heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveWithEmptyName() {
        this.heroRepository.remove(" ");
    }

    @Test
    public void testRemoveSuccessfullyNameAndTestGetHero() {
        Assert.assertEquals(0, this.heroRepository.getCount());
        this.heroRepository.create(this.hero);
        Assert.assertEquals(1, this.heroRepository.getCount());
        this.heroRepository.remove("Desi");
        Assert.assertEquals(0, this.heroRepository.getCount());
        Hero removedHero = this.heroRepository.getHero("Desi");
        Assert.assertNull(removedHero);
    }

    @Test
    public void testGetHeroWithHighestLevelAndTestGetHeroes(){
        Hero hero1 = new Hero("Pesho", 2);
        Hero hero2 = new Hero("Gosho", 6);
        Hero hero3 = new Hero("Rasho", 1);
        this.heroRepository.create(hero1);
        this.heroRepository.create(hero2);
        this.heroRepository.create(hero3);

        Assert.assertEquals(3, heroRepository.getHeroes().size());
        Hero highestHero = this.heroRepository.getHeroWithHighestLevel();

        Assert.assertEquals(highestHero.getName(),hero2.getName());
        Assert.assertEquals(highestHero.getLevel(),hero2.getLevel());
    }
}
