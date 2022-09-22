import com.intuit.karate.Runner
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RunTests {
    @Test
    fun testParallel() {
        val results = Runner.path("classpath:starwars") //.outputCucumberJson(true)
            .parallel(5)
        Assertions.assertEquals(0, results.failCount, results.errorMessages)
    }
}