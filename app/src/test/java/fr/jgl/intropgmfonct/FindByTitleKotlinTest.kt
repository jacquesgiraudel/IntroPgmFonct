package fr.jgl.intropgmfonct

import fr.jgl.pgmfonct.FindByTitleKotlin
import fr.jgl.pgmfonct.Movie
import org.hamcrest.Matchers.empty
import org.hamcrest.core.Is
import org.junit.Assert.*
import org.junit.Test

class FindByTitleKotlinTest {

    val MATRIX = Movie("Matrix", "1999")
    val A_BEAUTIFUL_MIND = Movie("A beautiful mind", "2001")
    val INTOUCHABLE = Movie("Intouchable", "2011")
    val FORREST_GUMP = Movie("Forrest Gump", "1994")

    val FILM_COLLECTION = mutableListOf(MATRIX, A_BEAUTIFUL_MIND, INTOUCHABLE, FORREST_GUMP)

    @Test
    fun `should return empty when non found`() {
        val result = FindByTitleKotlin.findByTitle("Other film")(FILM_COLLECTION)
        assertThat(result, Is(empty()))
    }

    @Test
    fun `should return a matching movie`() {
        val result = FindByTitleKotlin.findByTitle("Matrix")(FILM_COLLECTION)
        assertNotNull(result)
    }

    @Test
    fun `should return all matching movies`(){
        val expectedResult = listOf(INTOUCHABLE, FORREST_GUMP)

        val result = FindByTitleKotlin.findByTitle("o")(FILM_COLLECTION)

        assertEquals(expectedResult, result)
    }

}