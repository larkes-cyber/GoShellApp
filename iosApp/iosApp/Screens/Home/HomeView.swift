//
//  HomeView.swift
//  iosApp
//
//  Created by MacBook on 14.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct HomeView: View {
    
    let viewState:HomeViewState
    let eventHandler: (HomeEvent) -> Void
    
    var body: some View {
        Text("Home")
    }
}


