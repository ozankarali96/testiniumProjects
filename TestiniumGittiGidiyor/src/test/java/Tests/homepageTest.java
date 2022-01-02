package Tests;

import Base.BaseTest;
import Pages.homepage;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class homepageTest extends BaseTest{
    Pages.homepage homepage;
    @Before
    public void beforeTest() { homepage = new homepage(getDriver());
    }
    @Test
    public void amazonTest() throws InterruptedException, IOException {
        homepage.goToGittiGidiyor().searchProduct().randomProductSelect().namePriceControl().basketThings().deleteProduct();
    }
}