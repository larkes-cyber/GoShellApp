//
//  MainView.swift
//  iosApp
//
//  Created by MacBook on 14.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct MainView: View {
    var body: some View {
        TabView{
            HomeScreen()
                .tabItem{
                    Label("Home", systemImage: "house")
                }
            RoomsScreen()
                .tabItem{
                    Label("Rooms", systemImage: "room")
                }
            ProfileScreen()
                .tabItem{
                    Label("Profile", systemImage: "profile")
                }
        }
    }
}

#Preview {
    MainView()
}
