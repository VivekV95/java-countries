package com.vivekvishwanath.javacountries.Main.Controllers

import com.vivekvishwanath.javacountries.Main.JavaCountriesApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/age")
class AgeController {

    @GetMapping(value = ["{age}"], produces = ["application/json"])
    fun getCountriesByAge(@PathVariable age: Int): ResponseEntity<Any> {
        val tempCountries = JavaCountriesApplication.myCountryList.countryList.
                filter {it.age >= age}
        return ResponseEntity(tempCountries, HttpStatus.OK)
    }

    @GetMapping(value = ["/min"], produces = ["application/json"])
    fun getCountryWithMinAge(): ResponseEntity<Any> {
        val min = JavaCountriesApplication.myCountryList.countryList.minBy { it.age }
        return ResponseEntity(min, HttpStatus.OK)
    }

    @GetMapping(value = ["/max"], produces = ["application/json"])
    fun getCountryWithMaxAge(): ResponseEntity<Any> {
        val max = JavaCountriesApplication.myCountryList.countryList.maxBy { it.age }
        return ResponseEntity(max, HttpStatus.OK)
    }

    @GetMapping(value = ["/median"], produces = ["application/json"])
    fun getCountryWithMedianAge(): ResponseEntity<Any> {
        val tempCountries = JavaCountriesApplication.myCountryList.countryList.
                sortedBy { it.age }
        val median = tempCountries[tempCountries.size/2]
        return ResponseEntity(median, HttpStatus.OK)
    }


}