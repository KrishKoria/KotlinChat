# Kotlin Chat Application

This is a real-time chat application built using Kotlin and Java, with Gradle as the build tool. The application uses Jetpack Compose for UI, Firebase Firestore for data storage, Firebase Authentication for user login and signup, and follows the MVVM architecture.

## Features

- Real-time chat functionality: Users can send and receive messages in real-time.
- Message timestamping: Each message is timestamped, and the timestamp is displayed in a user-friendly format.
- User identification in chat: Messages are tagged with the sender's name.
- Data storage: User data and messages are stored securely in Firebase Firestore.
- User Authentication: Firebase Authentication is used for user login and signup.

## Technologies Used

- Kotlin: The main programming language used in this project.
- Java: Used alongside Kotlin for certain functionalities.
- Gradle: The build automation tool used.
- Jetpack Compose: The modern toolkit for building native Android UI.
- Firebase Firestore: Used for storing user data and messages.
- Firebase Authentication: Used for user login and signup.
- MVVM Architecture: The project follows the Model-View-ViewModel architectural pattern.

## Setup and Installation

1. Clone the repository to your local machine.
2. Open the project in Android Studio Jellyfish | 2023.3.1 Patch 1 or any IDE that supports Kotlin and Java.
3. Build and run the project.

## Code Overview

The main chat screen is built using Jetpack Compose. It displays a list of messages in the chat room. Each message shows the sender's name, the message text, and the time the message was sent. The chat input field and send button are located at the bottom of the screen. The application follows the MVVM architecture, with a ViewModel managing the state of the chat room. User data and messages are stored in Firebase Firestore. User login and signup is handled by Firebase Authentication.

