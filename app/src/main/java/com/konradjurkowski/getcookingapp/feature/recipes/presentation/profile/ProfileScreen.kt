package com.konradjurkowski.getcookingapp.feature.recipes.presentation.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.konradjurkowski.getcookingapp.R
import com.konradjurkowski.getcookingapp.common_components.drop_menu.BasicDropdownMenu
import com.konradjurkowski.getcookingapp.common_components.drop_menu.MenuItem
import com.konradjurkowski.getcookingapp.common_components.top_bar.BasicTopBar
import com.konradjurkowski.getcookingapp.util.theme.Gray3

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileScreenViewModel = hiltViewModel()
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    var showMenu by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                BasicTopBar(
                    title = stringResource(id = R.string.profile_screen_title),
                    trailingIcon = R.drawable.ic_more,
                    onTrailingIconClicked = {
                        showMenu = true
                    }
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(horizontal = dimensionResource(id = R.dimen.regular_padding)),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    BasicDropdownMenu(
                        onDismissPressed = {
                            showMenu = false
                        },
                        isMenuVisible = showMenu,
                        menuItems = listOf(
                            MenuItem(
                                text = stringResource(id = R.string.profile_screen_edit_profile),
                                icon = Icons.Default.Edit,
                                onClick = {
                                    // TODO:
                                }
                            ),
                            MenuItem(
                                text = stringResource(id = R.string.profile_screen_logout),
                                icon = Icons.Default.Logout,
                                onClick = {
                                    viewModel.logout()
                                }
                            ),
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = dimensionResource(id = R.dimen.regular_padding))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://media.istockphoto.com/photos/millennial-male-team-leader-organize-virtual-workshop-with-employees-picture-id1300972574?b=1&k=20&m=1300972574&s=170667a&w=0&h=2nBGC7tr0kWIU8zRQ3dMg-C5JLo9H2sNUuDjQ5mlYfo=")
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    placeholder = painterResource(id = R.drawable.ic_default_profile),
                    error = painterResource(id = R.drawable.ic_default_profile),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(screenHeight * 0.15f)

                )
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Recipe",
                            style = MaterialTheme.typography.h6.copy(color = Gray3)
                        )
                        Text(
                            text = "4",
                            style = MaterialTheme.typography.h3.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Followers",
                            style = MaterialTheme.typography.h6.copy(color = Gray3)
                        )
                        Text(
                            text = "2.5M",
                            style = MaterialTheme.typography.h3.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Following",
                            style = MaterialTheme.typography.h6.copy(color = Gray3)
                        )
                        Text(
                            text = "259",
                            style = MaterialTheme.typography.h3.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.regular_padding)))
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Jan Kowalski",
                    style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "Chef",
                    style = MaterialTheme.typography.h6.copy(color = Gray3)
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.small_padding)))
                Text(
                    text = "Private Chef\n" +
                            "Passionate about food and life \uD83E\uDD58\uD83C\uDF72\uD83C\uDF5D\uD83C\uDF71\n",
                    style = MaterialTheme.typography.h6.copy(color = Gray3)
                )
            }
            // TODO: IMAGE SECTION
        }
    }
}