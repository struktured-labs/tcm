package com.tcmhealth.app.data

// TCM Elements
enum class Element(val displayName: String, val emoji: String, val color: Long) {
    WOOD("Wood", "🌳", 0xFF4A7C59),
    FIRE("Fire", "🔥", 0xFFD32F2F),
    EARTH("Earth", "🏔️", 0xFF8B7355),
    METAL("Metal", "⚙️", 0xFF9E9E9E),
    WATER("Water", "💧", 0xFF1976D2)
}

// Constitution Types
enum class ConstitutionType(val displayName: String, val description: String) {
    BALANCED("Balanced", "Well-balanced Qi, good adaptation to environment"),
    QI_DEFICIENT("Qi-Deficient", "Low energy, fatigue, weak immunity"),
    YANG_DEFICIENT("Yang-Deficient", "Cold sensitivity, low metabolism"),
    YIN_DEFICIENT("Yin-Deficient", "Heat sensitivity, dry skin, insomnia"),
    PHLEGM_DAMPNESS("Phlegm-Dampness", "Heavy feeling, sluggishness, excess weight"),
    DAMP_HEAT("Damp-Heat", "Sticky sweat, oily skin, irritability"),
    BLOOD_STASIS("Blood-Stasis", "Poor circulation, dark complexion"),
    QI_STAGNATION("Qi-Stagnation", "Mood swings, tension, bloating"),
    ALLERGIC("Allergic", "Sensitive to allergens, immune reactions")
}

// Thermal Nature of Foods
enum class ThermalNature { COLD, COOL, NEUTRAL, WARM, HOT }

// Flavors
enum class Flavor { SOUR, BITTER, SWEET, PUNGENT, SALTY }

// Food Item
data class FoodItem(
    val name: String,
    val thermalNature: ThermalNature,
    val flavors: List<Flavor>,
    val elements: List<Element>,
    val benefits: String
)

// Herbal Remedy
data class HerbalRemedy(
    val name: String,
    val chineseName: String,
    val properties: String,
    val functions: String,
    val indications: List<String>
)

// Acupressure Point
data class AcupressurePoint(
    val name: String,
    val location: String,
    val functions: String,
    val howToUse: String
)

// Health Recommendation
data class Recommendation(
    val title: String,
    val description: String,
    val type: String, // Food, Herb, Exercise, Acupressure
    val icon: String
)

// Sample Data
object TCMDatabase {
    val foods = listOf(
        FoodItem("Ginger", ThermalNature.WARM, listOf(Flavor.PUNGENT), listOf(Element.FIRE, Element.EARTH), "Warms the body, aids digestion, boosts circulation"),
        FoodItem("Green Tea", ThermalNature.COOL, listOf(Flavor.BITTER), listOf(Element.FIRE), "Clears heat, calms mind, antioxidant properties"),
        FoodItem("Brown Rice", ThermalNature.NEUTRAL, listOf(Flavor.SWEET), listOf(Element.EARTH), "Strengthens Spleen, nourishes Qi, sustained energy"),
        FoodItem("Cucumber", ThermalNature.COLD, listOf(Flavor.SWEET), listOf(Element.WATER), "Cools body, hydrates, reduces inflammation"),
        FoodItem("Cinnamon", ThermalNature.HOT, listOf(Flavor.SWEET, Flavor.PUNGENT), listOf(Element.FIRE), "Warms yang, improves circulation, aids metabolism"),
        FoodItem("Pear", ThermalNature.COOL, listOf(Flavor.SWEET), listOf(Element.METAL), "Moistens lungs, soothes throat, clears heat"),
        FoodItem("Black Beans", ThermalNature.NEUTRAL, listOf(Flavor.SWEET), listOf(Element.WATER), "Tonifies kidneys, nourishes blood, builds strength"),
        FoodItem("Spinach", ThermalNature.COOL, listOf(Flavor.SWEET), listOf(Element.WOOD), "Nourishes blood, benefits liver, improves vision")
    )

    val herbs = listOf(
        HerbalRemedy("Ginseng (人参)", "Rén Shēn", "Sweet, slightly bitter, warm",
            "Tonifies Qi, strengthens immunity",
            listOf("Fatigue", "Weak immunity", "Poor appetite", "Mental fog")),
        HerbalRemedy("Goji Berry (枸杞)", "Gǒu Qǐ", "Sweet, neutral",
            "Nourishes liver and kidneys, improves vision",
            listOf("Eye strain", "Dizziness", "Lower back pain", "Aging")),
        HerbalRemedy("Chrysanthemum (菊花)", "Jú Huā", "Sweet, bitter, cool",
            "Clears heat, calms liver, benefits eyes",
            listOf("Headache", "Red eyes", "Dizziness", "Hypertension")),
        HerbalRemedy("Astragalus (黄芪)", "Huáng Qí", "Sweet, warm",
            "Tonifies Qi, strengthens immune system",
            listOf("Frequent colds", "Fatigue", "Weak digestion", "Sweating")),
        HerbalRemedy("Licorice Root (甘草)", "Gān Cǎo", "Sweet, neutral",
            "Harmonizes formulas, tonifies Spleen",
            listOf("Sore throat", "Digestive issues", "Fatigue"))
    )

    val acupressurePoints = listOf(
        AcupressurePoint("LI4 - Hegu (合谷)", "Between thumb and index finger",
            "Relieves pain, headaches, stress, boosts immunity",
            "Press firmly for 1-2 minutes, breathe deeply"),
        AcupressurePoint("ST36 - Zusanli (足三里)", "Below knee, outer side of shin",
            "Strengthens digestion, boosts energy, builds immunity",
            "Massage in circular motions for 2-3 minutes"),
        AcupressurePoint("PC6 - Neiguan (内关)", "Inner wrist, 2 inches from palm",
            "Relieves nausea, anxiety, insomnia, calms heart",
            "Press gently for 30 seconds to 1 minute"),
        AcupressurePoint("LV3 - Taichong (太冲)", "Top of foot between big toe and second toe",
            "Relieves stress, headaches, regulates mood",
            "Press downward for 1-2 minutes while breathing"),
        AcupressurePoint("GV20 - Baihui (百会)", "Top center of head",
            "Clears mind, relieves headaches, lifts mood",
            "Gently massage in circular motions for 1 minute")
    )

    fun getRecommendationsFor(constitution: ConstitutionType): List<Recommendation> {
        return when (constitution) {
            ConstitutionType.QI_DEFICIENT -> listOf(
                Recommendation("Eat Warm Foods", "Focus on ginger, cinnamon, and warm soups to boost Qi", "Food", "🍲"),
                Recommendation("Ginseng Tea", "Drink ginseng tea in the morning to tonify Qi and energy", "Herb", "🍵"),
                Recommendation("Press ST36", "Massage Zusanli point daily to strengthen energy", "Acupressure", "☝️"),
                Recommendation("Gentle Qi Gong", "Practice 10 minutes of gentle Qi Gong to build Qi", "Exercise", "🧘")
            )
            ConstitutionType.YANG_DEFICIENT -> listOf(
                Recommendation("Warming Spices", "Add cinnamon, ginger, and garlic to meals", "Food", "🌶️"),
                Recommendation("Avoid Cold Foods", "Reduce raw foods, cold drinks, and ice cream", "Food", "❄️"),
                Recommendation("Warm Beverages", "Drink warm water and herbal teas throughout the day", "Herb", "☕"),
                Recommendation("Keep Warm", "Dress warmly, especially lower back and feet", "Lifestyle", "🧣")
            )
            ConstitutionType.YIN_DEFICIENT -> listOf(
                Recommendation("Cooling Foods", "Eat pears, cucumber, and watermelon to nourish Yin", "Food", "🍐"),
                Recommendation("Goji Berry Tea", "Drink goji berry tea to nourish liver and kidneys", "Herb", "🍵"),
                Recommendation("Evening Meditation", "Practice calming meditation before bed", "Exercise", "🧘"),
                Recommendation("Adequate Sleep", "Aim for 8 hours of quality sleep to restore Yin", "Lifestyle", "😴")
            )
            ConstitutionType.PHLEGM_DAMPNESS -> listOf(
                Recommendation("Light Diet", "Focus on vegetables, lean proteins, and whole grains", "Food", "🥗"),
                Recommendation("Avoid Dairy", "Reduce dairy, fried foods, and sweets", "Food", "🚫"),
                Recommendation("Daily Movement", "30 minutes of walking or gentle exercise", "Exercise", "🚶"),
                Recommendation("Digestive Tea", "Drink chrysanthemum or oolong tea after meals", "Herb", "🍵")
            )
            else -> listOf(
                Recommendation("Balanced Diet", "Eat a variety of seasonal, fresh foods", "Food", "🍎"),
                Recommendation("Regular Exercise", "Maintain consistent physical activity", "Exercise", "🏃"),
                Recommendation("Mindful Living", "Practice meditation and stress management", "Lifestyle", "🧘"),
                Recommendation("Herbal Tea", "Enjoy green tea or chrysanthemum tea", "Herb", "🍵")
            )
        }
    }
}
