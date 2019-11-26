package com.chirkin.kafedratest

import java.time.LocalDate

class AccountingService {

    companion object {
        fun isDate(ds: String, de: String): Boolean {
            var isDate = false
            return try {
                LocalDate.parse(ds)
                LocalDate.parse(de)
                isDate = true
                isDate
            } catch (e: Exception) {
                isDate
            }
        }

        fun isVol(vol: String): Boolean {
            var isVol = false
            return try {
                vol.toInt()
                isVol = true
                isVol
            } catch (e: Exception) {
                isVol
            }
        }
    }
}
