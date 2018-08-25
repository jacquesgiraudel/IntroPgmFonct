package fr.jgl.pgmfonct

class FindByTitleKotlin {

    companion object {

        var findByTitle: (String) -> (MutableList<Movie>) -> List<Movie> = { query -> { collection ->
            val predicate = matches(query)
            filter(predicate)(collection)
        }}

        val filter: ((Movie) -> Boolean) -> (List<Movie>) -> List<Movie> = { predicate -> { collection ->
            collection.filter(predicate)
        }}

        val matches: (String) -> (Movie) -> Boolean = { query -> { movie -> isInfixOf(query) (title(movie))}}

        val title: (Movie) -> String = { movie -> movie.title}

        val isInfixOf: (String) -> (String) -> Boolean = { query -> { string -> string.contains(query)}}

    }
}