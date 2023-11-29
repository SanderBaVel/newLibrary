package com.example.newlibrary;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.newlibrary.Activity.BarraNav;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class BarraNavInstrumentedTest {
    @Rule
    public ActivityScenarioRule<BarraNav> activityRule =
            new ActivityScenarioRule<>(BarraNav.class);

    @Test
    public void testActivityStart() {
        // Verifica que la actividad se inicie correctamente
        Espresso.onView(withId(R.id.botom_navigacion))
                .check(matches(isDisplayed()));

        // Haz clic en uno de los elementos del menú de navegación
        Espresso.onView(withId(R.id.downloal)).perform(click());

        // Verifica que el fragmento correspondiente se haya cargado
        Espresso.onView(withId(R.id.frame_conteiner))
                .check(matches(isDisplayed()));
    }
}
