# Movie App

A simple Movie App built using **MVVM**, **Retrofit**, **Room Database**, and **Jetpack Compose**.

The app works in both **Online** and **Offline** mode.

---

## Features
- Fetch movies from API using Retrofit
- Store movies locally using Room DB
- Offline support
- Modern UI with Jetpack Compose
- MVVM Architecture

---

## Architecture

```
UI (Compose) → ViewModel → Repository → Retrofit API + Room DB
```

---

## Tech Stack

- Kotlin
- Jetpack Compose
- MVVM
- Retrofit
- Room Database
- Coroutines

---

## Online & Offline Flow

### When Internet is Available
1. Fetch movies from API
2. Save data into Room Database
3. Show latest movies on screen

### When No Internet
1. Fetch movies from Room Database
2. Show cached movie list offline

---

## Screenshots

<img width="280" height="600" alt="Screenshot_1778129469" src="https://github.com/user-attachments/assets/c5037a67-5eb4-47bc-b489-59bda7e62820" />
