<div align="center">

# ☕ CoffeeApp — Artisanal Coffee & Brew Lounge

> *Handcrafted coffee culture meets modern Android engineering — powered by Google Firebase Realtime Database and hardware-accelerated Frosted Glass (Glassmorphism).*

<br/>

[![Kotlin](https://img.shields.io/badge/Language-Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Firebase](https://img.shields.io/badge/Backend-Firebase_Realtime_DB-FFCA28?style=flat&logo=firebase&logoColor=black)](https://firebase.google.com/)
[![UI Style](https://img.shields.io/badge/Design-Glassmorphism_BlurView-6F4E37?style=flat)](https://github.com/Dimezis/BlurView)
[![Architecture](https://img.shields.io/badge/Architecture-MVVM_+_LiveData-4285F4?style=flat)](https://developer.android.com/topic/libraries/architecture)
[![Android SDK](https://img.shields.io/badge/Target%20SDK-35-green?style=flat&logo=android&logoColor=white)](https://developer.android.com/)

</div>

---

## 📖 Overview

**CoffeeApp** is a specialty coffee shop and beverage ordering application designed for Android. It combines an artisanal dark-roast aesthetic with modern cloud persistence. Users can explore 9 curated beverage and food categories, view detailed tasting notes, select customized cup sizes, and experience real-time glassmorphic UI blurring.

---

## 🥐 Handcrafted Menu Categories

The catalog is split into 9 dedicated collections dynamically queried from Firebase:

| ☕ Hot Coffee | 🧊 Ice Coffee | ⚗️ Brewing Coffee |
| :---: | :---: | :---: |
| Single-origin Espressos, Velvety Lattes, Flat Whites | Smooth Cold Brews, Iced Americanos, Frappés | Pour-overs, Chemex & Aeropress single-origin beans |
| **🍵 Hot Drinks** | **🧋 Ice Drinks** | **🥤 Thick Shakes** |
| Spiced Chais, Ceremonial Matchas, Herbal Teas | Sparkling Refreshers, Berry Spritzers, Lemonades | Creamy chocolate, vanilla, and salted caramel shakes |
| **🥐 Breakfast** | **🍰 Cakes & Treats** | **🍽️ Gourmet Lounge** |
| Freshly baked morning croissants & toasties | New York cheesecakes, brownies & tiramisu | Savory bites and chef-curated lounge pairings |

---

## 🏗 Architecture & Cloud Data Pipeline

The application follows the recommended **MVVM (Model-View-ViewModel)** architecture with a clean repository pattern:

```text
  ┌─────────────────────────────────────────────────────────┐
  │         Google Firebase Realtime Database               │
  │                  "Items" collection                     │
  └────────────────────────────┬────────────────────────────┘
                               │ Real-time listener
                               ▼
  ┌─────────────────────────────────────────────────────────┐
  │                 MainRepository.kt                       │
  │   - ref.orderByChild("categoryId").equalTo(id)          │
  │   - Parses snapshots into List<ItemsModel>              │
  └────────────────────────────┬────────────────────────────┘
                               │ Emits LiveData
                               ▼
  ┌─────────────────────────────────────────────────────────┐
  │                  MainViewModel.kt                       │
  │   - Exposes observable LiveData streams to Views        │
  └────────────────────────────┬────────────────────────────┘
                               │ Observes
                               ▼
  ┌─────────────────────────────────────────────────────────┐
  │             ListActivity & DetailActivity               │
  │   - Renders with ViewBinding & Glide image caching      │
  │   - Hardware-accelerated frosted glass (BlurView)       │
  └─────────────────────────────────────────────────────────┘
```

---

## 💎 Frosted Glass (Glassmorphism) Implementation

To deliver an elegant café lounge vibe, **CoffeeApp** applies real-time Gaussian blur to overlay panels:

```kotlin
// Real-time hardware-accelerated blur using RenderScript
val decorView = this.window.decorView
val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup

binding.blurView.setupWith(rootView, RenderScriptBlur(this))
    .setFrameClearDrawable(decorView.background)
    .setBlurRadius(10f)

binding.blurView.setOutlineProvider(ViewOutlineProvider.BACKGROUND)
binding.blurView.setClipToOutline(true)
```

---

## 🛠 Tech Stack

- **Language:** Kotlin 100% (JVM Target 11)
- **Minimum SDK:** Android 7.0 (API 24)
- **Target SDK:** Android 15 (API 35)
- **Cloud Backend:** Google Firebase Realtime Database
- **Architecture:** MVVM + Android Architecture Components (`ViewModel`, `LiveData`)
- **UI & Blur Effects:** ViewBinding, ConstraintLayout, [BlurView 2.0.5](https://github.com/Dimezis/BlurView)
- **Image Pipeline:** [Glide 4.12.0](https://github.com/bumptech/glide) with rounded corner transformations
- **Typography:** Custom calligraphic fonts (`pristina.ttf`)

---

## 🚀 Getting Started

### Prerequisites:
- Android Studio (Koala / Ladybug or newer)
- JDK 11 or higher
- Android Device or Emulator (API 24+)

### Build & Run:
1. Clone the repository:
   ```bash
   git clone https://github.com/ibrohim2005rajabboyev/CoffeeApp.git
   ```
2. Open **CoffeeApp** in Android Studio.
3. Allow Gradle to download dependencies and sync (`google-services.json` is pre-configured).
4. Select your device and press **Run** (`Shift + F10`).

---

## 👨‍💻 Developer

**Ibrohimjon Rajabboyev**  
*Mobile Application Developer • Android • Kotlin • Flutter*  
🔗 [GitHub Profile](https://github.com/ibrohim2005rajabboyev)
