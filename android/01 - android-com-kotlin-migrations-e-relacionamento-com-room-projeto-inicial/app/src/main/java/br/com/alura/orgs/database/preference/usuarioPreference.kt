package br.com.alura.orgs.database.preference

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore


val CHAVE_USUARIO_ID_LOGADO = stringPreferencesKey("CHAVE_USUARIO_ID_LOGADO")
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "sessao_usuario")