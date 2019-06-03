package com.vivekvishwanath.javacountries.Main.Controllers

import com.vivekvishwanath.javacountries.Main.JavaCountriesApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/names")
class NameController {

    @GetMapping(value = ["/all"], produces = ["application/json"])
    fun getAllNames(): ResponseEntity<Any> {
        val names = ArrayList<String>()
        val tempCountries = JavaCountriesApplication.myCountryList.countryList.
                sortedBy {it.name}
        for (country in tempCountries) {
            names.add(country.name)
        }
        return ResponseEntity(names, HttpStatus.OK)
    }

    @GetMapping(value = ["/start/{s}"], produces = ["application/json"])
    fun getCountryByName(@PathVariable s: String): ResponseEntity<Any> {
        val tempCountries = JavaCountriesApplication.myCountryList.countryList.
                filter {it.name.startsWith(s, true)}
        return ResponseEntity(tempCountries, HttpStatus.OK)
    }

    @GetMapping(value = ["/size/{length}"], produces = ["application/json"])
    fun getCountriesByNameLength(@PathVariable length: Int): ResponseEntity<Any> {
        val tempCountries = JavaCountriesApplication.myCountryList.countryList.
                filter {it.name.length >= length}
        return ResponseEntity(tempCountries, HttpStatus.OK)
    }

}