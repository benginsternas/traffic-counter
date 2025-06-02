package de.thkoeln.vma.trafficcounter.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CleanDatabaseDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(text = "Daten löschen") },
        text = { Text(dialogText) },
        icon = { Icon(imageVector = icon, contentDescription = "Warning Icon") },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                    onDismissRequest()
                }
            ) {
                Text("Löschen")
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismissRequest
            ) {
                Text("Abbrechen")
            }
        }
    )
}
