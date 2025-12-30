# TCM Health Android App - Prototype

A functional Android app prototype for Traditional Chinese Medicine health tracking and guidance.

## Features

✅ **Welcome Screen** - Beautiful onboarding with TCM philosophy
✅ **Constitution Assessment Quiz** - 8-question quiz to determine your TCM body type
✅ **Personalized Dashboard** - Health insights based on your constitution
✅ **Daily Recommendations** - Custom suggestions for food, herbs, exercises, and acupressure
✅ **Food Database** - TCM properties of common foods (thermal nature, flavors, elements)
✅ **Herbal Remedy Guide** - 5+ traditional Chinese herbs with properties and uses
✅ **Acupressure Point Library** - 5+ pressure points with locations and instructions

## Tech Stack

- **Language**: 100% Kotlin
- **UI**: Jetpack Compose with Material Design 3
- **Architecture**: MVVM pattern
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)

## Constitution Types Supported

1. **Balanced** - Well-balanced Qi
2. **Qi-Deficient** - Low energy, fatigue
3. **Yang-Deficient** - Cold sensitivity
4. **Yin-Deficient** - Heat sensitivity, insomnia
5. **Phlegm-Dampness** - Heavy feeling, excess weight
6. **Damp-Heat** - Oily skin, irritability
7. **Blood-Stasis** - Poor circulation
8. **Qi-Stagnation** - Mood swings, tension
9. **Allergic** - Sensitive to allergens

## How to Build & Install

### Option 1: Using Android Studio (Recommended)

1. **Install Android Studio**
   - Download from: https://developer.android.com/studio
   - Install with Android SDK

2. **Open Project**
   ```bash
   # Open Android Studio
   # Select "Open an Existing Project"
   # Navigate to the android-app folder
   ```

3. **Build APK**
   - Click `Build` → `Build Bundle(s) / APK(s)` → `Build APK(s)`
   - Wait for build to complete (first build takes 5-10 minutes)
   - Click "locate" to find the APK file

4. **Install on Your Phone**
   - Transfer APK to your Android device
   - Enable "Install from Unknown Sources" in Settings
   - Tap the APK file to install
   - Launch "TCM Health" app

### Option 2: Command Line Build

```bash
cd android-app

# First time setup (downloads Gradle wrapper)
./gradlew wrapper --gradle-version 8.2

# Build debug APK
./gradlew assembleDebug

# APK will be at:
# app/build/outputs/apk/debug/app-debug.apk
```

### Option 3: Quick Install with ADB

If you have Android Debug Bridge installed:

```bash
cd android-app
./gradlew installDebug
```

## Project Structure

```
android-app/
├── app/
│   ├── src/main/
│   │   ├── java/com/tcmhealth/app/
│   │   │   ├── MainActivity.kt          # App entry point
│   │   │   ├── data/
│   │   │   │   └── TCMData.kt           # TCM data models & database
│   │   │   └── ui/
│   │   │       ├── TCMHealthApp.kt      # Main app navigation
│   │   │       ├── screens/
│   │   │       │   ├── WelcomeScreen.kt
│   │   │       │   ├── QuizScreen.kt
│   │   │       │   └── DashboardScreen.kt
│   │   │       └── theme/
│   │   │           ├── Theme.kt
│   │   │           └── Type.kt
│   │   ├── res/
│   │   │   ├── values/
│   │   │   │   ├── strings.xml
│   │   │   │   ├── colors.xml           # TCM color palette
│   │   │   │   └── themes.xml
│   │   │   └── drawable/
│   │   │       └── ic_launcher_*.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
└── settings.gradle
```

## App Flow

1. **Welcome Screen**
   - Introduction to TCM Health
   - Feature highlights
   - "Get Started" button

2. **Quiz Screen**
   - 8 questions about:
     - Energy levels
     - Temperature sensitivity
     - Digestion
     - Sleep quality
     - Mood
     - Skin condition
     - Circulation
     - Allergies
   - Progress indicator
   - Calculates constitution from answers

3. **Dashboard Screen** (4 Tabs)
   - **Home Tab**:
     - Your constitution result
     - Personalized daily recommendations
     - Option to retake quiz

   - **Foods Tab**:
     - Browse TCM food database
     - See thermal nature, flavors, elements
     - Health benefits for each food

   - **Herbs Tab**:
     - Traditional Chinese herbal remedies
     - Properties and functions
     - Indications for use

   - **Acupressure Tab**:
     - Pressure point locations
     - Functions and benefits
     - Step-by-step usage instructions

## Customization

### Adding More Foods

Edit `app/src/main/java/com/tcmhealth/app/data/TCMData.kt`:

```kotlin
val foods = listOf(
    FoodItem(
        name = "Your Food",
        thermalNature = ThermalNature.NEUTRAL,
        flavors = listOf(Flavor.SWEET),
        elements = listOf(Element.EARTH),
        benefits = "Your benefits here"
    ),
    // ... add more
)
```

### Adding More Herbs

```kotlin
val herbs = listOf(
    HerbalRemedy(
        name = "Your Herb (中文)",
        chineseName = "Pinyin",
        properties = "Sweet, warm",
        functions = "Your functions",
        indications = listOf("Condition 1", "Condition 2")
    )
)
```

### Changing Colors

Edit `app/src/main/res/values/colors.xml`:

```xml
<color name="primary_red">#8B2635</color>
<color name="primary_gold">#D4AF37</color>
```

## Screenshots

### Welcome Screen
- Yin-Yang symbol
- App tagline
- Feature list
- Get Started button

### Quiz Screen
- Question counter
- Progress bar
- Multiple choice answers
- Clean, focused design

### Dashboard
- Constitution card
- Personalized recommendations
- Tabbed interface
- Rich content cards

## Next Steps for Development

### Phase 1 Enhancements
- [ ] Add more foods (expand to 100+)
- [ ] Add more herbs (expand to 50+)
- [ ] Add more acupressure points (expand to 50+)
- [ ] Implement local data persistence (Room database)
- [ ] Add food search functionality

### Phase 2 Features
- [ ] Food tracker with logging
- [ ] Symptom journal
- [ ] Health score calculation
- [ ] Daily notifications
- [ ] Yin-Yang balance meter
- [ ] Progress tracking over time

### Phase 3 Advanced
- [ ] Camera-based tongue diagnosis
- [ ] AR acupressure point overlay
- [ ] Wearable device integration
- [ ] AI-powered recommendations
- [ ] Social features / community

## Troubleshooting

### Build Fails
- Ensure Java 17+ is installed
- Check Android SDK is properly configured
- Try: `./gradlew clean` then rebuild

### App Won't Install
- Enable "Unknown Sources" in Android settings
- Check minimum Android version (7.0+)
- Uninstall any previous version first

### App Crashes
- Check Android version compatibility
- View logcat for error messages
- Report issues with stack trace

## License

Copyright © 2024 TCM Health. Educational prototype.

## Medical Disclaimer

This app is for educational purposes only. It does not provide medical advice. Always consult qualified healthcare professionals for medical concerns. TCM practices should complement, not replace, conventional medical care.

## Contact

For questions or feedback about this prototype, please refer to the main project documentation.

---

Built with ❤️ using Jetpack Compose
