package homework_4.custom_annotation.test_annotation;

public class TestClass {
    @BeforeSuite
    public void init() {
        System.out.println("@BeforeSuite");
    }

    @Test(priority = 4)
    public void test1() {
        System.out.println("test with priority 4");
    }

    @Test(priority = 1)
    public void test2() {
        System.out.println("test with priority 1");
    }

    @Test(priority = 5)
    public void test3() {
        System.out.println("test with priority 5");
    }

    @Test(priority = 2)
    public void test4() {
        System.out.println("test with priority 2");
    }

    @AfterSuite
    public void end() {
        System.out.println("@AfterSuite");
    }
}
