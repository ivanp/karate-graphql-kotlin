package starwars.film

import com.intuit.karate.junit5.Karate

class FilmRunner {

    @Karate.Test
    fun testMain(): Karate {
        return Karate.run("film").relativeTo(javaClass)
    }
}