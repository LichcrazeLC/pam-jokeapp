package com.isa.jokevault
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.isa.jokevault.view.MainActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule
/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UITest {
    @get:Rule
    var intentsRule: IntentsTestRule<MainActivity> = IntentsTestRule(MainActivity::class.java)
    @Test
    fun useAppContext() {
        onView(withId(R.id.getJokeButton)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.getJokeButton)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.getJokeInfo)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.button_first)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.button_second)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.fab)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.getJokeButton)).perform(click())
    }
}