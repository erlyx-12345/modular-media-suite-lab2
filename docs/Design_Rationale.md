## Design Rationale

This section explains **why each Structural Design Pattern** was used in the project and how it improves the system’s flexibility, modularity, and maintainability.

---

### 1. Proxy Pattern  
**Used in:** `ProxyMediaSource`

**Intent:**  
Control access to another object and add caching behavior transparently.

**Where:**  
`ProxyMediaSource` wraps around a real `MediaSource` (e.g., `RemoteStreamSource` or `HlsStreamSource`).

**Why:**  
Fetching media chunks from remote sources can be slow. The proxy adds caching to avoid downloading the same data multiple times.

**Effect:**  
When caching is enabled, the proxy intercepts calls to `getChunks()`. If data is already cached, it reuses it instead of fetching again.

**Benefit:**  
Reduces loading time and improves playback efficiency without changing existing source classes.

---

### 2. Bridge Pattern  
**Used in:** `RenderingBridge`, `RenderingEngine`, `CPURenderingEngine`, `GPURenderingEngine`

**Intent:**  
Separate the abstraction (renderer) from its implementation (hardware/software engine) so both can change independently.

**Where:**  
`MediaRenderer → RenderingBridge → RenderingEngine` hierarchy.

**Why:**  
Allows adding new rendering methods (e.g., GPU, CPU) without modifying the main player logic.

**Effect:**  
`RenderingBridge` delegates the rendering task to a chosen `RenderingEngine`.

**Benefit:**  
Makes the rendering system flexible and easy to extend for future use.

---

### 3. Composite Pattern  
**Used in:** `Playlist` and `MediaItem`

**Intent:**  
Treat single media items and collections (playlists) the same way.

**Where:**  
Both `Playlist` and `MediaItem` implement the `MediaComponent` interface.

**Why:**  
Supports nested playlists — playlists that can contain other playlists or media items.

**Effect:**  
The app can call `.play()` or `.display()` on both without special handling.

**Benefit:**  
Simplifies playlist management and makes the structure scalable.

---

### 4. Decorator / Chain Pattern  
**Implemented via:** `PluginChain`

**Intent:**  
Add extra features to media playback dynamically.

**Where:**  
`PluginChain` manages multiple plugins such as `SubtitlePlugin`, `AudioEqualizerPlugin`, and `WatermarkPlugin`.

**Why:**  
Allows users to enable or disable playback features at runtime.

**Effect:**  
Each plugin in the chain applies its effect during playback.

**Benefit:**  
Encourages modular design — new plugins can be added without changing core code.
