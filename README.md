# Android Architecture & Concepts Showcase

A modular Android application built with **Kotlin** and **XML (ViewBinding/DataBinding)** showcasing essential Android development components, clean MVVM architecture, background processing, and local/remote data persistence.

---

## 🚀 Key Concepts & Modules Covered

* **Architecture & State Management**: MVVM Pattern, `ViewModel`, `LiveData`, and `Repository` pattern.
* **Dependency Injection**: Full app DI with **Dagger Hilt** (`@HiltAndroidApp`, `@AndroidEntryPoint`, `@HiltViewModel`).
* **Concurrency**: **Kotlin Coroutines** (`viewModelScope`, Dispatchers `IO`/`Main`/`Default`, `async`/`await`).
* **Data Persistence**:
  * **Room Database**: Entity, DAO, TypeConverters with Hilt injection.
  * **Native SQLite**: CRUD operations using `SQLiteOpenHelper`.
* **Networking**: **Retrofit 2** + **OkHttp** + **Gson** for REST API integration and data parsing.
* **Services & Background Processing**:
  * **Foreground Media Service**: Background audio playback with notifications (`MusicService`).
  * **Foreground Location Service**: Real-time GPS tracking via Google Play Services Location (`LocationService`).
  * **Started Service**: Background task lifecycle management (`NewService`).
* **Broadcast Receivers**: Handling system events (e.g., Airplane mode) and custom intent broadcasts (`MyBroadcastReciver`).
* **UI Components & Navigation**:
  * **Fragments & Bottom Navigation**: Multi-tab interface (`HomeFragment`, `ListFragment`, `ProfileFragment`).
  * **RecyclerView**: Custom adapters for linear lists and grid layouts (`LIstAdapter`, `GrideAdapter`, `SimpleAdapter`).
  * **Deep Linking**: Custom scheme handling (`myapp://profile`).
* **System & Security**: Android 13+ runtime permissions (`POST_NOTIFICATIONS`, `ACCESS_FINE_LOCATION`), notification channels, and form validation using Android `Patterns`.

---

## 🛠️ Tech Stack

* **Language**: Kotlin
* **Target / Compile SDK**: 36 | **Min SDK**: 28
* **DI**: Dagger Hilt 2.51.1 (KSP)
* **Local Storage**: Room 2.6.1 & SQLite
* **Networking**: Retrofit 2.11.0 & Gson
* **Image Loading**: Glide 4.16.0
* **Location API**: Google Play Services Location 21.3.0
* **UI Utilities**: Intuit SDP / SSP

---

## 📂 Project Structure

```text
app/src/main/
├── AndroidManifest.xml
├── java/com/example/sample_app/
│   ├── MainActivity.kt                # Main Navigation Hub
│   ├── MyApplication.kt               # Hilt Application Class
│   ├── MyBroadcastReciver.kt          # System Broadcast Receiver
│   └── ui/theme/
│       ├── activity/                  # Feature Activities (Services, Coroutines, DB, APIs)
│       ├── miniAppActivites/          # Multi-screen Auth & Navigation Flow
│       ├── Adapter/                   # RecyclerView Adapters (Linear, Grid)
│       ├── Fragment/                  # Bottom Navigation Fragments
│       ├── LocalData/                 # Room Database & SQLiteHelper
│       ├── Retrofit/                  # API Services & DI Modules
│       ├── Services/                  # Music, Location & Worker Services
│       ├── model/                     # Data Models & DTOs
│       ├── reposetry/                 # Data Repositories
│       └── viewmodels/                # ViewModels (Hilt injected)
└── res/
    ├── layout/                        # XML UI Layouts (ViewBinding / DataBinding)
    ├── menu/                          # Bottom Navigation Menus
    ├── raw/                           # Audio Media Assets
    ├── drawable/                      # Vector Drawables & Gradients
    └── values/                        # Themes, Strings, Colors, Dimens
```

---

## 🏁 Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/dharmikchitroda/Sample_App.git
   ```
2. **Open in Android Studio** (Ladybug 2024.2+ or newer recommended).
3. Let Gradle sync dependencies.
4. Run the project on an Android device or emulator (API 28+).

---

## 📄 License

This project is licensed under the **MIT License** - open for educational and portfolio reference.
