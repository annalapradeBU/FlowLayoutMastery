# Cafe Finder Tag Browser (Flow Layout Mastery)

### 📝 Project Overview
This application demonstrates dynamic, wrapping layouts in Jetpack Compose using the modern `FlowRow` and `FlowColumn` components. The "Cafe Finder" theme allows users to browse and select various "vibes" (tags) that wrap intelligently based on screen width, providing a fluid and responsive user experience.

### 🚀 Key Technical Features
* **Dynamic Tag Wrapping**: Uses `FlowRow` to display a large list of cafe tags. Unlike a standard Row, the tags automatically move to the next line when they hit the screen edge.
* **Vertical Filter Columns**: Implements `FlowColumn` with `maxItemsInEachColumn = 3` to organize quick filter options into a multi-column grid that scales vertically.
* **Reactive State Management**: Utilizes a `MutableState<Set<String>>` to track user selections. Tapping a tag updates the "Selected Criteria" area in real-time.

### 🎨 Material 3 Requirements Met
The following M3 components were implemented to satisfy the project rubric:
1.  **FilterChip**: Used in the browser section to demonstrate the "selected" state with a leading check icon.
2.  **AssistChip**: Used in the "Selected Criteria" area to represent active filters.
3.  **SuggestionChip**: Used within the `FlowColumn` for quick-action filter options.
4.  **TopAppBar**: Features a themed background and an `AutoMirrored` back arrow icon.
5.  **IconButton**: Encapsulates the navigation action in the header.
6.  **Surface**: Provides a distinct background container and rounded corners for the "Selected Criteria" area.
7.  **HorizontalDivider**: Visually separates the interactive sections of the screen.

### 🛠️ Modifiers Demonstrated
* **`Arrangement.spacedBy(8.dp)`**: Ensures consistent horizontal and vertical gutter spacing between all chips within the Flow layouts.
* **`fillMaxWidth()` & `padding()`**: Implemented across containers to ensure the UI stretches to fit the device screen while maintaining readable margins.
* **Visual State Selection**: The `FilterChip` dynamically updates its colors, border, and elevation based on the `isSelected` boolean state.
* **`weight(1f)`**: Applied to the vertical filters section to ensure it occupies the appropriate remaining screen space.


---

### 📱 Execution Environment
* **Device**: Pixel 8 Pro Emulator
* **SDK Version**: Android 36 (targetSdk)
* **Min SDK**: 26
* **Compose BOM**: 2026.01.00

### 📸 Screenshot
![Running App Screenshot](FlowLayout.png)

# AI DISCLOSURE

### Universal AI Statment 
I utilized Gemini to ensure that I met each of the project requirements, as well as prompting it for assistance with commenting and ensuring my code followed standard Kotlin conventions. In several instances, AI-generated comments were omitted or manually rewritten to ensure accuracy and flow. Because the AI occasionally "hallucinated" requirements or skipped constraints, I manually verified every line of code against the rubric, using Gemini primarily as a second pair of eyes and a brainstorming partner.

Additionally, I used it to draft my READMES, though I occassionally needed to omit unneccessary (and frankly, sometimes strange) details.

---

### Q3: Flow Layout Tag Browser
* **Data Generation:** Gemini assisted in generating potential tag ideas for the "Cafe Finder" theme and filter options for the vertical `FlowColumn`.
* **Icon Discovery:** Gemini helped identify the correct "back" icon (`Icons.AutoMirrored.Filled.ArrowBack`) to ensure the `TopAppBar` looked polished and intuitive. 
