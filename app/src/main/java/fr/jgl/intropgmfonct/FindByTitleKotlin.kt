package fr.jgl.pgmfonct

class FindByTitleKotlin {

    companion object {

        // findByTitle :: (String, [Movie]) -> [Movie]
        fun findByTitle(query: String, collection: MutableList<Movie>): List<Movie>{
            var results: MutableList<Movie> = mutableListOf()

            // Use of functions as variables (predicate and add) : functions as first class citizen

            // matches :: (String, Film) -> Boolean
            val predicate = ::matches

            // TODO side effect moved up (still on results)
            // add :: (Film) -> Boolean
            val add = fun (movie: Movie) = results.add(movie)

            for (movie: Movie in collection){
                val fn = addIf(predicate, query, movie, add)
                fn(movie)
            }

            return results
        }

        // addIfMatches :: ((String, Movie) -> Boolean, String, Movie, [Movie] -> (Boolean)) -> (Movie) -> (Boolean)
        fun addIf(predicate: (String, Movie) -> Boolean, query: String, movie: Movie, add: (Movie) -> (Boolean)): (Movie) -> (Boolean){
            if (predicate(query, movie)){
                return add
            }
            return fun (movie: Movie) = false
        }

        // matches :: (String, Film) -> Boolean
        fun matches(query: String, movie: Movie): Boolean = title(movie).isInfixOf(query)

        // title :: (Film) -> String
        fun title(movie: Movie): String = movie.title

        // isInfixOf :: (String, String) -> Boolean
        fun String.isInfixOf(query: String) = contains(query)

    }
}