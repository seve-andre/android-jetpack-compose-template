package com.mitch.template.data.userprefs

import androidx.datastore.core.DataStore
import com.mitch.template.data.userprefs.UserPreferencesProtoModel.TemplateThemePreferenceProto
import kotlinx.coroutines.flow.Flow
import java.util.Locale

/**
 * [UserPreferencesLocalDataSource] is the mediator between [UserPreferencesProtoModel] Datastore
 * and the repo to exchange data from the Datastore file
 *
 * @property userPreferences is the actual [UserPreferencesProtoModel] Datastore
 */
class UserPreferencesLocalDataSource(
    private val userPreferences: DataStore<UserPreferencesProtoModel>
) {
    val protoPreferences: Flow<UserPreferencesProtoModel> = userPreferences.data

    suspend fun setTheme(theme: TemplateThemePreferenceProto) {
        userPreferences.updateData {
            it.copy {
                this.theme = theme
            }
        }
    }

    suspend fun setLocale(locale: Locale) {
        userPreferences.updateData {
            it.copy {
                this.locale = locale.toLanguageTag()
            }
        }
    }

    suspend fun resetLocale() {
        userPreferences.updateData {
            it.copy {
                clearLocale()
            }
        }
    }
}
