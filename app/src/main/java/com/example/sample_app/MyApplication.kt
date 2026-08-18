package com.example.sample_app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

}



/*
# Hilt Integration Plan — Sample_App

## Background

Teri app mein Hilt already setup hai (dependencies + plugin). Ab sirf **code-level wiring** karna hai. Main tere existing Retrofit aur Room code ko Hilt ke saath connect karunga taki tu seekh sake ki Hilt kaise kaam karta hai.

## Kya Change Hoga?

### Architecture Flow (Before vs After)

**Before (Manual DI):**
```
Activity → ViewModelFactory → ViewModel → Repository → (RetrofitModule / AppDatabase)
```

**After (Hilt DI):**
```
Activity (@AndroidEntryPoint) → ViewModel (@HiltViewModel) → Repository (@Inject) → (Retrofit / Room provided by @Module)
```

---

## Proposed Changes

### 1. 🆕 NEW — `di/AppModule.kt`
Ek naya **Hilt Module** banaunga jo yeh provide karega:
- `Retrofit` instance
- `ApiService` interface
- `AppDatabase` instance
- `MyDao` instance

```kotlin
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides @Singleton fun provideRetrofit(): Retrofit { ... }
    @Provides @Singleton fun provideApiService(retrofit: Retrofit): ApiService { ... }
    @Provides @Singleton fun provideDatabase(@ApplicationContext ctx: Context): AppDatabase { ... }
    @Provides fun provideDao(db: AppDatabase): MyDao { ... }
}
```

---

### 2. MODIFY — `reposetry/repoRetrofit.kt`

**Before:**
```kotlin
class repoRetrofit {
    suspend fun fetchfromApi(): SeverStudentdata {
        val response = RetrofitModule.api.getallStuden() // ❌ hardcoded
        return response
    }
}
```
**After:**
```kotlin
class repoRetrofit @Inject constructor(
    private val apiService: ApiService  // ✅ Hilt inject karega
) {
    suspend fun fetchfromApi(): SeverStudentdata = apiService.getallStuden()
}
```

---

### 3. MODIFY — `reposetry/reposetryRoom.kt` (StudentRepository)

**Before:**
```kotlin
class StudentRepository(context: Context) {
    private val dao = AppDatabase.getdata(context).dao()  // ❌ manually bana raha
}
```
**After:**
```kotlin
class StudentRepository @Inject constructor(
    private val dao: MyDao  // ✅ Hilt inject karega
) { ... }
```

---

### 4. MODIFY — `viewmodels/RetrofitViewModel.kt`

**Before:**
```kotlin
class RetrofitViewModel(val repository: repoRetrofit) : ViewModel()
// ❌ ViewModelFactory banana padta tha
```
**After:**
```kotlin
@HiltViewModel
class RetrofitViewModel @Inject constructor(
    private val repository: repoRetrofit  // ✅ Hilt automatically inject karega
) : ViewModel()
```

---

### 5. MODIFY — `viewmodels/RoomVIewModel.kt`

**Before:**
```kotlin
class RoomVIewModel(private val repository: StudentRepository) : ViewModel()
// ❌ ViewModelFactory banana padta tha
```
**After:**
```kotlin
@HiltViewModel
class RoomVIewModel @Inject constructor(
    private val repository: StudentRepository  // ✅ auto inject
) : ViewModel()
```

---

### 6. MODIFY — Activities jo yeh ViewModels use karti hain

Jo bhi Activity `RetrofitViewModel` ya `RoomVIewModel` use karti hai use `@AndroidEntryPoint` add karna hoga aur ViewModel initialization simplify hogi:

```kotlin
// Before (manual factory)
val vm = ViewModelProvider(this, MyFactory(repo))[RetrofitViewModel::class.java]

// After (Hilt se auto)
val vm: RetrofitViewModel by viewModels()
```

---

## Verification Plan

1. App build karo — koi compile error nahi aana chahiye
2. Retrofit screen open karo — data fetch hona chahiye
3. Room/registration screen open karo — save karna chahiye

> [!IMPORTANT]
> Main **purana code nahi hataunga** — sirf Hilt annotations add karunga. Tera existing flow same rahega, bas DI better ho jayega.

> [!NOTE]
> `@HiltAndroidApp` (`MyApplication.kt`) pehle se correct hai ✅
> Hilt plugin + dependencies pehle se set hain ✅

*/