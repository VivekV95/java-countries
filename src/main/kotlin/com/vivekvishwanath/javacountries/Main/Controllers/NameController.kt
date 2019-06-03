package com.vivekvishwanath.javacountries.Main.Controllers

import com.vivekvishwanath.javacountries.Main.JavaCountriesApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/names")
class NameController {
    //localhost:2019/names/all
    @GetMapping(value = ["/all"], produces = ["application/json"])
    fun getAllNames(): ResponseEntity<Any> {
        val names = ArrayList<String>()
        JavaCountriesApplication.myCountryList.countryList.
                sortBy {country -> country.name}
        for (country in JavaCountriesApplication.myCountryList.countryList) {
            names.add(country.name)
        }
        return ResponseEntity(names, HttpStatus.OK)
    }
}