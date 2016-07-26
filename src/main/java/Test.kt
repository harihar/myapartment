import io.kotlintest.specs.ShouldSpec

/**
 * Created by harihar on 11/07/16.
 */
class Test : ShouldSpec() {
    init {
        should("return the length of the string") {
            "sammy1".length shouldBe 6
            "".length shouldBe 0
        }
    }
}

