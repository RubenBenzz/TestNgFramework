package nz.co.ruben.project.packagethree;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Using dataProvider -
 */
public class TestThree {

    @DataProvider(name = "data")
    private Object[][] testData() {
        Object[][] data = {
                {"abc1", "pqr1", "xyz1"},
                {"abc2", "pqr2", "xyz2"},
                {"abc3", "pqr3", "xyz3"},
                {"abc4", "pqr4", "xyz4"}
        };
        return data;
    }

    @Test(description = "1. Test three-1", dataProvider = "data")
    @Parameters({"param3", "param2", "param1"})
    private void testThree1(String param1, String param2, String param3) {
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(param3);
    }

    @Test(description = "2. Test three-2")
    private void testThree2() {
        System.out.println("Test three 2");
    }

    @Test(description = "3. Test three-3")
    private void testThree3() {
        System.out.println("Test three 3");
    }

    @Test(description = "4. Test three-4")
    private void testThree4() {
        System.out.println("Test three 4");
    }
}
