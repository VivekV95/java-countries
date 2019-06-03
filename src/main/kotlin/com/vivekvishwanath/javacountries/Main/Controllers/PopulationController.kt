package com.vivekvishwanath.javacountries.Main.Controllers

import com.vivekvishwanath.javacountries.Main.JavaCountriesApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/population")
class PopulationController{

    @GetMapping(value = ["/size/{people}"], produces = ["application/json"])
    fun getCountriesByPopulation(@PathVariable people: Long): ResponseEntity<Any> {
        val tempCountries = JavaCountriesApplication.myCountryList.countryList.
                filter {it.population >= people}
        return ResponseEntity(tempCountries, HttpStatus.OK)
    }

    @GetMapping(value = ["/size/min"])
    fun getMinPopulationCountry(): ResponseEntity<Any> {
        val min = JavaCountriesApplication.myCountryList.countryList.minBy { it.population }
        return ResponseEntity(min, HttpStatus.OK)
    }

    @GetMapping(value = ["/size/max"])
    fun getMaxPopulationCountry(): ResponseEntity<Any> {
        val min = JavaCountriesApplication.myCountryList.countryList.maxBy { it.population }
        return ResponseEntity(min, HttpStatus.OK)
    }

    @GetMapping(value = ["/median"])
    fun getMedianPopulationCountry(): ResponseEntity<Any> {
        val tempCountries = JavaCountriesApplication.myCountryList.countryList.
                sortedBy { it.population }
        val median = tempCountries[tempCountries.size/2]
        return ResponseEntity(median, HttpStatus.OK)
    }
}