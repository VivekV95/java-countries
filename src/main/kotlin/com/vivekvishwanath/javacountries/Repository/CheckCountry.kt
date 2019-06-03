package com.vivekvishwanath.javacountries.Repository

import com.vivekvishwanath.javacountries.Models.Country

interface CheckCountry {
    fun test(c: Country): Boolean
}