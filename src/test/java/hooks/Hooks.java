package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        // ניתן להוסיף פעולות נוספות לפני כל תרחיש
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
