package com.example.chucknorrisjokes.activity

import android.os.Build
import androidx.lifecycle.Lifecycle
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.Robolectric
import androidx.test.core.app.ActivityScenario
import com.example.chucknorrisjokes.R
import com.example.chucknorrisjokes.fragment.JokeRandomFragment
import io.kotlintest.matchers.types.shouldBeInstanceOf
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import org.junit.Assert


@RunWith(RobolectricTestRunner::class)
@Config(
    sdk = [Build.VERSION_CODES.P]
)
class MainActivityTestRobolectric {

    @Test
    fun `WHEN main activity is created THEN fragment is created with correctly instance`() {
        val activity = ActivityScenario.launch(MainActivity::class.java)
        activity.moveToState(Lifecycle.State.CREATED)
        activity.onActivity {
            it.supportFragmentManager shouldNotBe null
            it.supportFragmentManager.findFragmentById(R.id.fragmentContainerView).shouldBeInstanceOf<JokeRandomFragment>()
        }


    }


}