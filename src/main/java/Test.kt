import io.kotlintest.specs.ShouldSpec

/**
 * Created by harihar on 11/07/16.
 */
class Test : ShouldSpec() {
    init {
        should("return the length of the string") {
            "sammy".length shouldBe 5
            "".length shouldBe 0
        }
    }
}

