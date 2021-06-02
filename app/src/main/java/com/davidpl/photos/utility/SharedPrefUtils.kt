package com.example.commons.utility.helper

import android.content.Context
import android.content.SharedPreferences

class SharedPrefUtils {

    companion object {
        private const val PREF_APP = "ANDNOTES"

        /**
         * Gets boolean data.
         *
         * @param context the context
         * @param key     the key
         * @return the boolean data
         */
        fun getBooleanData(context: Context, key: String?): Boolean {
            return context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE)
                .getBoolean(key, false)
        }

        fun getBooleanData(context: Context, key: String, default: Boolean): Boolean {
            return context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE)
                    .getBoolean(key, default)
        }

        /**
         * Gets int data.
         *
         * @param context the context
         * @param key     the key
         * @return the int data
         */
        fun getIntData(context: Context, key: String?): Int {
            return context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE).getInt(key, 0)
        }

        /**
         * Gets int data.
         *
         * @param context the context
         * @param key     the key
         * @return the int data
         */
        fun getLongData(context: Context, key: String?): Long {
            return context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE).getLong(key, 0)
        }

        /**
         * Gets string data.
         *
         * @param context the context
         * @param key     the key
         * @return the string data
         */
        // Get Data
        fun getStringData(context: Context, key: String?): String? {
            return context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE).getString(key, null)
        }

        /**
         * Save data.
         *
         * @param context the context
         * @param key     the key
         * @param val     the val
         */
        // Save Data
        fun saveData(context: Context, key: String?, value: String?) {
            context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE)
                .edit()
                .putString(key, value)
                .apply()
        }

        /**
         * Save data.
         *
         * @param context the context
         * @param key     the key
         * @param val     the val
         */
        fun saveData(context: Context, key: String?, value: Int) {
            context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE)
                .edit()
                .putInt(key, value)
                .apply()
        }

        /**
         * Save data.
         *
         * @param context the context
         * @param key     the key
         * @param val     the val
         */
        fun saveData(context: Context, key: String?, value: Long) {
            context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE)
                .edit()
                .putLong(key, value)
                .apply()
        }

        /**
         * Save data.
         *
         * @param context the context
         * @param key     the key
         * @param val     the val
         */
        fun saveData(context: Context, key: String?, value: Boolean) {
            context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(key, value)
                .apply()
        }

        fun getSharedPrefEditor(context: Context, pref: String?): SharedPreferences.Editor? {
            return context.getSharedPreferences(pref, Context.MODE_PRIVATE).edit()
        }

        fun saveData(editor: SharedPreferences.Editor) {
            editor.apply()
        }


        fun removeData(context: Context, key: String?) {
            context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE)
                .edit()
                .remove(key)
                .apply()
        }
    }

}