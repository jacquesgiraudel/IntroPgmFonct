package fr.jgl.pgmfonct

class FindByTitleKotlin {

    companion object {

        val findByTitle = {query: String -> {collection: MutableList<Movie> ->
            val predicate = matches(query)
            filter(predicate)(collection)
        }}

        val filter = {predicate: (Movie) -> Boolean -> {collection: List<Movie> ->
            collection.filter(predicate)
        }}

        val matches = {query: String -> { movie: Movie -> isInfixOf(query) (title(movie))}}

        val title = {movie: Movie -> movie.title}

        val isInfixOf = {query: String -> {string: String -> string.contains(query)}}

    }
}