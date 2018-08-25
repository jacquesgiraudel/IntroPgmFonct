package fr.jgl.pgmfonct

class FindByTitleKotlin {

    companion object {

        val findByTitle = {query: String -> {collection: MutableList<Movie> ->
            var results: List<Movie> = listOf()

            val predicate = matches

            val add = {movie: Movie -> {movies: List<Movie> -> movies.plus(movie)}}

            for (movie: Movie in collection){
                results = addIf(predicate)(query)(movie)(add)(results)
            }
            results
        }}

        val addIf = {predicate: (String) -> (Movie) -> Boolean ->  {query: String -> {movie: Movie -> {add: (Movie) -> (List<Movie>) -> List<Movie> ->
            if (matches(query)(movie))
                add(movie)
            else
                fun (movies: List<Movie>) = listOf<Movie>()
        }}}}

        val matches = {query: String -> { movie: Movie -> isInfixOf(query) (title(movie))}}

        val title = {movie: Movie -> movie.title}

        val isInfixOf = {query: String -> {string: String -> string.contains(query)}}

    }
}