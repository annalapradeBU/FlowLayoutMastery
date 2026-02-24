package com.example.flowlayoutmastery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.automirrored.filled.ArrowBack

// read ahead to ch 67

// light mode
val CafePalette = lightColorScheme(
    primary = Color(0xFF6F4E37),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFEDDBC7),
    onPrimaryContainer = Color(0xFF2D1600),
    secondaryContainer = Color(0xFFD2B48C),
    surface = Color(0xFFFFFBF8)
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Use the base MaterialTheme to ensure all M3 components have colors
            MaterialTheme (colorScheme = CafePalette){
                // just for ui polish
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                // just for ui polish
                {
                    Scaffold { innerPadding ->
                        TagBrowserScreen(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TagBrowserScreen(modifier: Modifier = Modifier) {
    // state management
    var selectedTags by remember { mutableStateOf(setOf<String>()) }
    val cafeTags = listOf("Study Space", "Matcha", "Boba", "Great Coffee", "Quiet", "Themed", "Good Service", "Good Value", "Local Gem", "Outdoor Seating", "Fast WiFi", "Pet Friendly")
    val filterOptions = listOf("4+ Stars", "5 Stars", "$", "$$", "$$$", "A-Z", "By Distance")

    // main wrapper
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp) // Requirement: Responsive sizing/padding
    ) {
        // REQUIREMENT: M3 component - TopAppBar
        TopAppBar(
            title = { Text("Cafe Finder") },
            navigationIcon = {
                // REQUIREMENT: M3 component - IconButton
                IconButton(onClick = { /* Handle back navigation here */ }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text("Your Selected Criteria", style = MaterialTheme.typography.titleMedium)

        // REQUIREMENT Updates dynamically based on state, contains tags
        // REQUIREMENT: M3 component - surface
        Surface(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            color = MaterialTheme.colorScheme.secondaryContainer,
            shape = MaterialTheme.shapes.medium
        ) {
            // --- SECTION: SELECTED TAGS ---
            // REQUIREMENT: FlowRow for dynamic wrapping of chips
            FlowRow(
                modifier = Modifier.padding(12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp) // Added vertical spacing
            ) {
                if (selectedTags.isEmpty()) {
                    Text("No criteria selected...", style = MaterialTheme.typography.bodyMedium)
                }
                selectedTags.forEach { tag ->
                    // REQUIREMENT: Must use FilterChip or AssistChip (or similar)
                    AssistChip(
                        onClick = { selectedTags = selectedTags - tag },
                        label = { Text(tag) },
                        trailingIcon = { Icon(Icons.Default.Check, null, Modifier.size(16.dp)) }
                    )
                }
            }
        }

        // REQUIREMENT: M3 component - divider
        HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp), thickness = 1.dp)


        Spacer(modifier = Modifier.height(16.dp))
        Text("Browse Cafe Vibes", style = MaterialTheme.typography.titleMedium)

        // --- SECTION: TAG BROWSER ---
        // REQUIREMENT: FlowRow for tags that wrap nicely across the screen
        FlowRow(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            cafeTags.forEach { tag ->
                val isSelected = selectedTags.contains(tag)
                FilterChip(
                    selected = isSelected,
                    onClick = {
                        selectedTags = if (isSelected) selectedTags - tag else selectedTags + tag
                    },
                    label = { Text(tag) },
                    leadingIcon = if (isSelected) {
                        { Icon(Icons.Default.Check, null, Modifier.size(18.dp)) }
                    } else null
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Quick Filters", style = MaterialTheme.typography.titleMedium)


        // --- SECTION: VERTICAL FILTERS ---
        // REQUIREMENT: Use FlowColumn for a second purpose
        // using weight(1f) to ensure responsive sizing in the vertical list
        Column(modifier = Modifier.weight(1f).fillMaxWidth()) {
            FlowColumn(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                maxItemsInEachColumn = 3
            ) {
                filterOptions.forEach { filter ->
                    SuggestionChip(onClick = { }, label = { Text(filter) })
                }
            }
        }
    }
}