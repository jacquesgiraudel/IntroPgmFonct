package fr.jgl.pgmfonct

class FindByTitleKotlin {

    companion object {

        fun findByTitle(query: String, collection: MutableList<Movie>): List<Movie>{
            var results: MutableList<Movie> = mutableListOf()

            do {
                val movie = collection.removeAt(0)
                addIfMatches(query, movie, results)
            }
            while (collection.size > 0)

            return results
        }

        fun addIfMatches(query: String, movie: Movie, results: MutableList<Movie>){
            if (matches(query, movie)){
                results.add(movie)
            }
        }

        fun matches(query: String, movie: Movie): Boolean = title(movie).isInfixOf(query)

        fun title(movie: Movie): String = movie.title

        fun String.isInfixOf(query: String) = contains(query)

    }
}