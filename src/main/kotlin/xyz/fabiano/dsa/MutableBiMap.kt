package xyz.fabiano.dsa

class MutableBiMap<K, V>(vararg pairs: Pair<K, V>) : HashMap<K, V>(pairs.toMap()), MutableMap<K, V> {
    private val reverseMap: MutableMap<V, K> = mutableMapOf()

    init {
        pairs.associateTo(reverseMap) { (k, v) -> Pair(v, k) }
    }

    fun get(value: V): K? {
        return reverseMap[value]
    }

    fun contains(key: K) = containsKey(key)
    fun contains(value: V) = containsValue(value)

    override fun put(key: K, value: V): V {
        super.put(key, value)
        reverseMap[value] = key
        return value
    }

    override fun putAll(from: Map<out K, V>) {

    }

    override fun remove(key: K): V? {
        val value = super<HashMap>.remove(key)
        reverseMap.remove(value)
        return value
    }

    fun remove(value: V): K? {
        val key = reverseMap.remove(value)
        if (key != null) super<HashMap>.remove(key)
        return key
    }

    override fun remove(key: K, value: V): Boolean {

    }

    override fun clear() {}

}

fun <K, V> mutableBiMapOf(vararg pairs: Pair<K, V>): Map<K, V> = MutableBiMap(*pairs)