package fr.jgl.pgmfonct

class FindByTitleKotlin {

    companion object {

        // findByTitle :: (String, [Movie]) -> [Movie]
        fun findByTitle(query: String, collection: MutableList<Movie>): List<Movie>{
            var results: List<Movie> = listOf()

            // matches :: (String, Film) -> Boolean
            val predicate = ::matches

            // add :: (Film) -> Boolean
            val add = fun (movie: Movie) = fun (movies: List<Movie>) = movies.plus(movie)

            for (movie: Movie in collection){
                val fn = addIf(predicate, query, movie, add)
                results = fn(movie)(results)
            }

            return results
        }

        // addIfMatches :: ((String, Movie) -> Boolean, String, Movie, [Movie] -> (Boolean)) -> (Movie) -> (Boolean)
        fun addIf(predicate: (String, Movie) -> Boolean, query: String, movie: Movie, add: (Movie) -> (List<Movie>) -> List<Movie>): (Movie) -> (List<Movie>) -> List<Movie>{
            if (predicate(query, movie)){
                return add
            }
            return fun (movie: Movie) = fun (movies: List<Movie>) = listOf<Movie>()
        }

        // matches :: (String, Film) -> Boolean
        fun matches(query: String, movie: Movie): Boolean = title(movie).isInfixOf(query)

        // title :: (Film) -> String
        fun title(movie: Movie): String = movie.title

        // isInfixOf :: (String, String) -> Boolean
        fun String.isInfixOf(query: String) = contains(query)

    }
}