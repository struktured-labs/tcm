package com.tcmhealth.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tcmhealth.app.data.ConstitutionType

data class QuizQuestion(
    val question: String,
    val answers: List<Pair<String, ConstitutionType>>
)

@Composable
fun QuizScreen(onQuizComplete: (ConstitutionType) -> Unit) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    val constitutionScores = remember { mutableStateMapOf<ConstitutionType, Int>() }

    val questions = listOf(
        QuizQuestion(
            "How would you describe your energy levels?",
            listOf(
                "High and consistent throughout the day" to ConstitutionType.BALANCED,
                "Low, easily fatigued" to ConstitutionType.QI_DEFICIENT,
                "Fluctuates, sometimes energetic, sometimes tired" to ConstitutionType.QI_STAGNATION,
                "Low, especially in cold weather" to ConstitutionType.YANG_DEFICIENT
            )
        ),
        QuizQuestion(
            "How do you react to temperature?",
            listOf(
                "Comfortable in most temperatures" to ConstitutionType.BALANCED,
                "Always feeling cold, prefer warmth" to ConstitutionType.YANG_DEFICIENT,
                "Always feeling hot, prefer coolness" to ConstitutionType.YIN_DEFICIENT,
                "Sensitive to both hot and cold" to ConstitutionType.ALLERGIC
            )
        ),
        QuizQuestion(
            "How is your digestion?",
            listOf(
                "Strong, can eat most foods" to ConstitutionType.BALANCED,
                "Weak, easily bloated or gassy" to ConstitutionType.QI_DEFICIENT,
                "Heavy feeling after eating" to ConstitutionType.PHLEGM_DAMPNESS,
                "Alternating constipation and diarrhea" to ConstitutionType.QI_STAGNATION
            )
        ),
        QuizQuestion(
            "How is your sleep quality?",
            listOf(
                "Deep and restful most nights" to ConstitutionType.BALANCED,
                "Difficulty falling asleep, mind racing" to ConstitutionType.YIN_DEFICIENT,
                "Wake up frequently during the night" to ConstitutionType.YIN_DEFICIENT,
                "Excessive sleeping, hard to wake up" to ConstitutionType.PHLEGM_DAMPNESS
            )
        ),
        QuizQuestion(
            "How would you describe your mood?",
            listOf(
                "Generally calm and stable" to ConstitutionType.BALANCED,
                "Anxious or worried often" to ConstitutionType.QI_DEFICIENT,
                "Irritable or frustrated easily" to ConstitutionType.QI_STAGNATION,
                "Depressed or unmotivated" to ConstitutionType.YANG_DEFICIENT
            )
        ),
        QuizQuestion(
            "How is your skin condition?",
            listOf(
                "Clear and healthy" to ConstitutionType.BALANCED,
                "Dry and dull" to ConstitutionType.YIN_DEFICIENT,
                "Oily with breakouts" to ConstitutionType.DAMP_HEAT,
                "Dark circles or dark spots" to ConstitutionType.BLOOD_STASIS
            )
        ),
        QuizQuestion(
            "How is your circulation?",
            listOf(
                "Good, warm hands and feet" to ConstitutionType.BALANCED,
                "Cold hands and feet" to ConstitutionType.YANG_DEFICIENT,
                "Easy bruising, visible veins" to ConstitutionType.BLOOD_STASIS,
                "Swelling in legs or feet" to ConstitutionType.PHLEGM_DAMPNESS
            )
        ),
        QuizQuestion(
            "Do you have allergies or sensitivities?",
            listOf(
                "No significant allergies" to ConstitutionType.BALANCED,
                "Yes, to pollen, dust, or foods" to ConstitutionType.ALLERGIC,
                "Sensitive to medications" to ConstitutionType.ALLERGIC,
                "Occasional mild reactions" to ConstitutionType.QI_DEFICIENT
            )
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Progress indicator
        Text(
            text = "Discover Your Constitution",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        LinearProgressIndicator(
            progress = (currentQuestionIndex + 1) / questions.size.toFloat(),
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Question ${currentQuestionIndex + 1} of ${questions.size}",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Current question
        val currentQuestion = questions[currentQuestionIndex]

        Text(
            text = currentQuestion.question,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Answer options
        currentQuestion.answers.forEach { (answer, constitution) ->
            OutlinedButton(
                onClick = {
                    // Record answer
                    constitutionScores[constitution] = (constitutionScores[constitution] ?: 0) + 1

                    // Move to next question or show results
                    if (currentQuestionIndex < questions.size - 1) {
                        currentQuestionIndex++
                    } else {
                        // Quiz complete - determine constitution
                        val finalConstitution = constitutionScores.maxByOrNull { it.value }?.key
                            ?: ConstitutionType.BALANCED
                        onQuizComplete(finalConstitution)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = answer,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(vertical = 8.dp),
                    textAlign = TextAlign.Start
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Answer honestly for the most accurate assessment",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}
