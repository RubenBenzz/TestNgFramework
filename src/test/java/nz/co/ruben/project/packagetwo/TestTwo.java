package nz.co.ruben.project.packagetwo;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Using 'enabled' - setting a method with enabled=false excludes the test from execution.
 * 'enabled=false' supersedes 'alwaysRun=true'. i.e, if a method a has 'enabled=false' and 'alwaysRun=true' then
 * the test won't be executed.
 * Using 'dependsOnMethod' and 'alwaysRun' - 'alwaysRun' supersedes 'dependsOnMethod' i.e, if a method has both
 * 'dependsOnMethod' and 'alwaysRun=true' then the method gets executed irrespective of whether the dependent
 * method passes or fails.
 * On the other hand, if the method just has 'dependsOnMethod' and if the dependent method fails then this test gets
 * ignored.
 * using Parameters from .xml file - Use Parameters tag to define parameters in .xml file and use Parameters at the
 * method level to read the defined parameters by using parameters name.
 */
public class TestTwo {

    @BeforeClass
    private void preRequisite() {
        System.out.println("Before method execution.");
    }

    @AfterClass
    private void postTest() {
        System.out.println("After method execution.");
    }

    @Test(description = "1. Test two-1", enabled = false, alwaysRun = true)
    private void testTwo1() {
        System.out.println("Test two 1");
    }

    @Parameters({"param1", "param2"})
    @Test(description = "2. Test two-2", dependsOnMethods = {"testTwo3"}, alwaysRun = true)
    private void testTwo2(String param1, String param2) {
        System.out.println("Test two 2");
        System.out.println(param1);
        System.out.println(param2);
    }

    @Test(description = "3. Test two-3")
    private void testTwo3() {
        System.out.println("Test two 3");
        Assert.assertEquals(1,2);
    }

    @Test(description = "4. Test two-4", dependsOnMethods = {"testTwo3"})
    private void testTwo4() {
        System.out.println("Test two 4");
    }
}
