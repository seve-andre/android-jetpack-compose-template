package com.mitch.template.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.mitch.template.R
import com.mitch.template.domain.models.TemplateThemePreference
import com.mitch.template.ui.designsystem.TemplateDesignSystem
import com.mitch.template.ui.designsystem.TemplateIcons
import com.mitch.template.ui.designsystem.TemplateTheme
import com.mitch.template.ui.designsystem.theme.custom.padding

@Composable
fun ThemePickerDialog(
    selectedTheme: TemplateThemePreference,
    onDismiss: () -> Unit,
    onConfirm: (TemplateThemePreference) -> Unit
) {
    var tempTheme by remember { mutableStateOf(selectedTheme) }

    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Icon(
                imageVector = TemplateIcons.Outlined.Palette,
                contentDescription = null
            )
        },
        title = {
            Text(text = stringResource(id = R.string.change_theme))
        },
        text = {
            Column(modifier = Modifier.selectableGroup()) {
                for (themePreference in TemplateThemePreference.entries) {
                    val isSelected = themePreference == tempTheme
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .selectable(
                                selected = isSelected,
                                onClick = { tempTheme = themePreference },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = padding.medium),
                        horizontalArrangement = Arrangement.spacedBy(padding.medium),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = isSelected,
                            onClick = null // null recommended for accessibility with screen readers
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(padding.small),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = themePreference.icon(),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = themePreference.title(),
                                style = TemplateDesignSystem.typography.bodyLarge
                            )
                        }
                    }
                }
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = stringResource(id = R.string.cancel))
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm(tempTheme)
                    onDismiss()
                },
                enabled = tempTheme != selectedTheme
            ) {
                Text(text = stringResource(id = R.string.save))
            }
        }
    )
}

@Composable
private fun TemplateThemePreference.icon(): ImageVector {
    return when (this) {
        TemplateThemePreference.FollowSystem -> TemplateIcons.Outlined.FollowSystem
        TemplateThemePreference.Light -> TemplateIcons.Outlined.LightMode
        TemplateThemePreference.Dark -> TemplateIcons.Outlined.DarkMode
    }
}

@Composable
private fun TemplateThemePreference.title(): String {
    val titleId = when (this) {
        TemplateThemePreference.FollowSystem -> R.string.system_default
        TemplateThemePreference.Light -> R.string.light_theme
        TemplateThemePreference.Dark -> R.string.dark_theme
    }
    return stringResource(id = titleId)
}

@PreviewLightDark
@Composable
private fun ThemePickerDialogPreview() {
    TemplateTheme {
        ThemePickerDialog(
            selectedTheme = TemplateThemePreference.Dark,
            onDismiss = { },
            onConfirm = { }
        )
    }
}
