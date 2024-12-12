package xyz.fabiano.dsa

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ImmutableBiMapSpec : StringSpec({
    "Empty map" {
        val map = MutableBiMap<String, Int>()

        map.size shouldBe  0
        map.isEmpty() shouldBe  true
    }



})
