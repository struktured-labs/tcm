package com.tcmhealth.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tcmhealth.app.data.ConstitutionType
import com.tcmhealth.app.ui.screens.DashboardScreen
import com.tcmhealth.app.ui.screens.QuizScreen
import com.tcmhealth.app.ui.screens.WelcomeScreen

sealed class Screen {
    object Welcome : Screen()
    object Quiz : Screen()
    object Dashboard : Screen()
}

@Composable
fun TCMHealthApp() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Welcome) }
    var userConstitution by remember { mutableStateOf<ConstitutionType?>(null) }

    when (currentScreen) {
        is Screen.Welcome -> {
            WelcomeScreen(
                onGetStarted = { currentScreen = Screen.Quiz }
            )
        }
        is Screen.Quiz -> {
            QuizScreen(
                onQuizComplete = { constitution ->
                    userConstitution = constitution
                    currentScreen = Screen.Dashboard
                }
            )
        }
        is Screen.Dashboard -> {
            DashboardScreen(
                constitution = userConstitution ?: ConstitutionType.BALANCED,
                onRetakeQuiz = { currentScreen = Screen.Quiz }
            )
        }
    }
}
