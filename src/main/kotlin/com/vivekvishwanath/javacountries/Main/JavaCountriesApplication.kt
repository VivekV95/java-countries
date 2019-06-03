package com.vivekvishwanath.javacountries.Main

import com.vivekvishwanath.javacountries.Repository.CountryList
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JavaCountriesApplication {

    companion object {
        lateinit var myCountryList: CountryList
        @JvmStatic
        fun main(args: Array<String>) {
            myCountryList = CountryList()
            runApplication<JavaCountriesApplication>(*args)
        }
    }
}
