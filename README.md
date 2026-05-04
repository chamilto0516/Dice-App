# Dice-App 🎲

A modern, simple 2-dice roller application built for Android using Kotlin and Jetpack Compose. This project was developed as a learning exercise to explore declarative UI and custom graphics in Android.

## Features
- **Dice Total Display:** The sum of both dice is calculated and displayed prominently above them.
- **Dual Dice Roll:** Roll two six-sided dice simultaneously.
- **Custom Graphics:** Dice faces are custom-drawn using Compose `Canvas`, featuring a classic dot layout for values 1 through 6.
- **Material 3 Design:** Built with the latest Android design standards, including Edge-to-Edge support.

## Tech Stack
- **Language:** Kotlin 2.x
- **UI Framework:** Jetpack Compose
- **Architecture:** Modern Android Architecture (Material 3, Scaffold)
- **Minimum SDK:** API 24+

## How it Works
The application uses Compose's state management (`remember { mutableIntStateOf() }`) to track the value of each die. When the "Roll Dice" button is pressed, random values are generated, and the UI instantly re-draws the dice faces using custom drawing logic.

## Project Structure
- `MainActivity.kt`: Contains the core logic for the dice roller and the custom `DieFace` drawing component.
- `ui/theme/`: Contains the Material 3 theme, colors, and typography settings.

---
*Developed with the assistance of Gemini CLI.*
