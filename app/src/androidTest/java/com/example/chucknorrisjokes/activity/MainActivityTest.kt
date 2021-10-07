package com.example.chucknorrisjokes.activity


import android.content.Intent
import android.os.SystemClock
import android.provider.Telephony.Carriers.PORT
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.chucknorrisjokes.R
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.common.ConsoleNotifier
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.apache.commons.io.FileUtils.waitFor
import java.util.concurrent.TimeUnit


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {
    //    private val mockWebServer: MockWebServer? = null


    @Rule
    @JvmField
    var wireMockRule = WireMockRule(
        wireMockConfig()
            .notifier(ConsoleNotifier(true))
    )


    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun given_main_active_up_then_fragment_is_displayed() {
        onView(withId(R.id.fragmentContainerView)).check(matches(isDisplayed()))
    }

    @Test
    fun given_main_active_up_when_click_button_then_the_text_displayed() {

        stubFor(get(urlMatching("/random"))
            .willReturn(aResponse()
                .withStatus(200)
                .withBody("{\"value\":\"value1\"}")))

        onView(withId(R.id.button_new_joke)).perform(click())
        SystemClock.sleep(200);
        onView(withId(R.id.text_view_chuck)).check(matches(withText("value1")));
    }
}