package xyz.fabiano.dsa

class ImmutableBiMap<K, V>(vararg pairs: Pair<K, V>) : LinkedHashMap<K, V>(pairs.toMap()), Map<K, V> {
    private val reverseMap : Map<V, K> = pairs.associate { (k, v) -> Pair(v, k) }

    fun get(value : V): K? {
        return reverseMap[value]
    }

    fun contains(key : K) = containsKey(key)
    fun contains(value : V) = containsValue(value)
}

fun <K, V> biMapOf(vararg pairs: Pair<K, V>): Map<K, V> = MutableBiMap(*pairs)
