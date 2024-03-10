package nz.co.ruben.project.packageone;

import nz.co.ruben.project.packagethree.TestThree;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Using priority - if all methods in the class are set with the same priority then alphabetic order is followed.
 * If priorities are set properly then priority order is followed with 0 being the highest priority.
 * By default, all tests/methods have a priority level 0. So setting a priority as 0 is redundant.
 * Using dependsOnMethods alongside priorities - dependsOnMethods supersedes priority. i.e, if a method has higher
 * priority but if it depends on another method with a lower priority then the method with lower priority is executed
 * first.
 * Also, all the other methods with higher priority than the 'dependant method' gets executed first,
 * before the dependant method gets executed.
 * In simple words, if a method is dependent on another method then irrespective of its priority, it is put on hold
 * until the dependent method gets executed as per its priority.
 * Using dataProvider from a different class - define the class name using dataProviderClass and also
 * define the dataProvider name using dataProvider.
 */
public class TestOne {

    @BeforeMethod
    private void preRequisite() {
        System.out.println("Before method execution.");
    }

    @AfterMethod
    private void postTest() {
        System.out.println("After method execution.");
    }

    @Test(description = "1. Test one-1", priority = 4, dataProvider = "data", dataProviderClass = TestThree.class)
    public void testOne1(String param1, String param2, String param3) {
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(param3);
    }

    @Test(description = "2. Test one-2", priority = 3)
    public void testOne2() {
        System.out.println("Test one 2");
    }

    @Test(description = "3. Test one-3", priority = 2)
    public void testOne3() {
        System.out.println("Test one 3");
    }

    @Test(description = "4. Test one-4", priority = 1, dependsOnMethods = {"testOne2"})
    public void testOne4() {
        System.out.println("Test one 4");
    }
}
