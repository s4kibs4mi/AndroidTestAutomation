package ninja.sakib.androidtestautomation;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;

import com.robotium.solo.Solo;
import com.squareup.spoon.Spoon;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * := Coded with love by Sakib Sami on 9/26/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

@RunWith(AndroidJUnit4.class)
public class AndroidTestAutomationTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);
    private Solo mainSolo;

    @Rule
    public ActivityTestRule<PreviewActivity> previewActivityTestRule
            = new ActivityTestRule<>(PreviewActivity.class);
    private Solo previewSolo;

    @Before
    public void setup() {
        mainSolo = new Solo(InstrumentationRegistry.getInstrumentation(),
                mainActivityTestRule.getActivity());
        previewSolo = new Solo(InstrumentationRegistry.getInstrumentation(),
                previewActivityTestRule.getActivity());
    }

    @After
    public void shutdown() {
        mainSolo.finishOpenedActivities();
        previewSolo.finishOpenedActivities();
    }

    @Test
    public void start() throws Exception {
        Spoon.screenshot(mainSolo.getCurrentActivity(), "InitialScreen");
        mainSolo.clickOnEditText(0);
        mainSolo.enterText((EditText) mainActivityTestRule.getActivity()
                .findViewById(R.id.mainTextField), "Hello Automation");
        Spoon.screenshot(mainSolo.getCurrentActivity(), "BeforeNextScreen");
        mainSolo.clickOnButton("Next");
        Spoon.screenshot(mainSolo.getCurrentActivity(), "AfterNextScreen");

        mainSolo.waitForActivity(PreviewActivity.class);
        Spoon.screenshot(mainSolo.getCurrentActivity(), "BeforeSaveScreen");
        previewSolo.clickOnButton("Save");
        Spoon.screenshot(mainSolo.getCurrentActivity(), "AfterSaveScreen");
    }
}
