package com.natra.memodiary.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.natra.memodiary.navigation.routes.authenticationRoute
import com.natra.memodiary.navigation.routes.homeRoute
import com.natra.memodiary.navigation.routes.writeRoute

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun NavGraph(startDestination: String, navController: NavHostController, onDataLoaded: () -> Unit) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        authenticationRoute(
            navigateToHome = {
                navController.popBackStack()
                navController.navigate(Screen.Home.route)
            },
            onDataLoaded = onDataLoaded
        )
        homeRoute(
            navigateToWrite = {
                navController.navigate(Screen.Write.route)
            },
            navigateToWriteWithArgs = {
                navController.navigate(Screen.Write.passDiaryId(diaryId = it))
            },
            navigateToAuth = {
                navController.popBackStack()
                navController.navigate(Screen.Authentication.route)
            },
            onDataLoaded = onDataLoaded
        )
        writeRoute(
            navigateBack = {
                navController.popBackStack()
            }
        )
    }
}