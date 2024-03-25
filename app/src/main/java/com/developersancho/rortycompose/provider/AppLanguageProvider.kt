package com.developersancho.rortycompose.provider

import android.content.Context
import com.developersancho.framework.pref.CacheManager
import java.util.*

class AppLanguageProvider constructor(private val cacheManager: CacheManager) : LanguageProvider {

    companion object {
        private const val LANG_CODE = "lang_code"
        private const val DefaultLanguage = "en"
    }

    override fun saveLanguageCode(languageCode: String) {
        cacheManager.write(key = LANG_CODE, value = languageCode)
    }

    override fun getLanguageCode(): String {
        return cacheManager.read(key = LANG_CODE, DefaultLanguage)
    }

    override fun setLocale(language: String, context: Context) {
        updateResources(language, context)
    }

    private fun updateResources(language: String, context: Context) {
//        context.resources.apply {
//            val locale = Locale(language)
//            Locale.setDefault(locale)
//            val config = Configuration(configuration)
//            context.createConfigurationContext(configuration)
//            config.setLocale(locale)
//            context.resources.updateConfiguration(config, displayMetrics)
//        }
        val locale = Locale(language)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }
}