# Modular Media Streaming Suite
---
## Description
The **Modular Media Streaming Suite** is a **Java console application** that simulates a modular media player.  
It supports multiple media sources (Local, Remote, HLS), proxy caching, plugin features (Subtitles, Equalizer, Watermark), and playlist management.

This project demonstrates key **Structural Design Patterns**:
- **Proxy** (caching)
- **Bridge** (rendering abstraction)
- **Composite** (playlist hierarchy)
- **Decorator** (plugin extensions)
  
---
## How to Set Up and Run

### Requirements
- Java **JDK 17** or higher  
- Any IDE (NetBeans, VS Code, IntelliJ, Eclipse) or terminal

### Quick Start (Command Line)

You can run the program using **two kinds of terminals**:

- The **terminal built into your IDE** (like NetBeans, VS Code, or IntelliJ)  
- Or the **system terminal** (Command Prompt or PowerShell in Windows, Terminal in macOS/Linux)

Follow these steps:

1. **Open a terminal:**
   - If you are using an IDE just open its built-in terminal.  
   - Otherwise, If you are not using an IDE just open the **Command Prompt** or **PowerShell** (Windows) or **Terminal** (Mac/Linux).

2. **Go to the folder** where your `modularmedia` files are located.  
   Example (Windows):
   cd C:\Users\YourName\Documents\ModularMediaSuite

3. **Compile all Java files:**
javac modularmedia/*.java

4. **Run the main program:**
java modularmedia.App

5.**The program will start — follow the instructions shown on the screen.**

---
## Run Using an IDE

### Option 1: NetBeans
1. Create a **new Java project**.  
2. Copy the `src/modularmedia/` folder into your project’s **`src`** directory.  
3. Open `App.java` → Right-click → **Run File**.

### Option 2: VS Code / IntelliJ / Eclipse
1. Open the folder containing the `modularmedia/` folder.  
2. Open `App.java`.  
3. Click the **Run icon** above the `main()` method or use the IDE’s **Run** or **Run Java** option.

---
## Demo Steps

When you run the program, follow these steps:

1. **Choose a Media Source**
   - Local File  
   - Remote Stream  
   - HLS Stream  

2. **Enable Proxy Caching (optional)**
   - Speeds up loading by storing data temporarily.

3. **Choose a Renderer**
   - Software (CPU-based)  
   - Hardware (GPU-based)  

4. **Add Plugins**
   - Subtitles  
   - Audio Equalizer  
   - Watermark  

5. **Add More Media or a Sub-Playlist**
   - You can group media items or create mini playlists inside a playlist.

6. **View Playlist and Start Playback**
   - The player shows your media list and begins playing.

---
## Documentation
See the **docs/** folder for the architecture overview, UML diagrams, design rationale, and reflection.

