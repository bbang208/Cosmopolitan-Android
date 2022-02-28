package io.github.bbang208.cosmopolitan.data.models

data class Repo(
    val owner: String,
    val description: String,
    val name: String,
    val stars: Int
) {
    val starsString: String
    get() {
        return stars.toString()
    }
}
