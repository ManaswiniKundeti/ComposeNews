package com.example.composenews.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.composenews.R
import com.example.composenews.domain.model.Article
import com.example.composenews.domain.model.Source
import com.example.composenews.presentation.onboarding.Dimens.ArticleCardSize
import com.example.composenews.presentation.onboarding.Dimens.SmallIconSize
import com.example.composenews.presentation.onboarding.Dimens.extraSmallPadding
import com.example.composenews.presentation.onboarding.Dimens.extraSmallPadding2

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick:() -> Unit
) {
    val context = LocalContext.current
    Row (modifier = modifier.clickable { onClick() }) {
        AsyncImage(
            modifier = modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(context).data(article.urlToImage).build() ,
            contentDescription = null
        )
        Column(verticalArrangement = Arrangement.SpaceAround, modifier = modifier
            .padding(extraSmallPadding)
            .height(
                ArticleCardSize
            )
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(
                    id = R.color.text_title
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row (verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(extraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(extraSmallPadding2))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    ArticleCard(
        article = Article(
            author = "",
            content = "",
            description = "",
            publishedAt = "2 hours ago",
            source = Source(id = "", name = "BBC"),
            title = "title is BBC NEws",
            url = "",
            urlToImage = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.bbc.co.uk%2Fbranding&psig=AOvVaw2OnEv6_ENQrAM8XKKeFOvI&ust=1725420051988000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCJjXo-DopYgDFQAAAAAdAAAAABAJ"
        )) {}
}