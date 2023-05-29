package me.iamsahil.translator_kmm.translate.data.local

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import me.iamsahil.translator_kmm.database.TranslateDatabase

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(TranslateDatabase.Schema,  "translate.db")
    }
}