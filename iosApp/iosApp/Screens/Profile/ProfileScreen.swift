//
//  ProfileScreen.swift
//  iosApp
//
//  Created by MacBook on 14.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct ProfileScreen: View {
    
    private let viewModel = ProfileViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())){ viewState in
            ProfileView(viewState: viewState){ event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }
    }
}

#Preview {
    ProfileScreen()
}
