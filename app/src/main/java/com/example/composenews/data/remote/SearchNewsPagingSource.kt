package com.example.composenews.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.composenews.domain.model.Article

class SearchNewsPagingSource (
    val newsApi: NewsApi,
    val sources: String,
    val searchQuery: String
): PagingSource<Int, Article>() {

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private var totalNewsCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        // make request to api and return article
        // 1: get page using params
        val page = params.key ?: 1
        return try {
            val newsResponse = newsApi.searchNews(page = page, sources = sources, searchQuery = searchQuery)
            totalNewsCount += newsResponse.articles.size
            val distinctArticles = newsResponse.articles.distinctBy { it.title } // filters distinct articles based on title as there are duplicates in the overall response
            LoadResult.Page(
                data = distinctArticles,
                nextKey = if(totalNewsCount == newsResponse.totalResults) null else page+1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
        //
    }

}