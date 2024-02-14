//
//  LoginScreen.swift
//  iosApp
//
//  Created by MacBook on 12.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct LoginScreen: View {
    
    @State var isRegistrationPresented = false
    @State var isMainPresented = false
    
    private let viewModel = LoginViewModel()

    
    var body: some View {
        
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())){ viewState in
            LoginView(viewState: viewState){ event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }
        .sheet(isPresented: $isRegistrationPresented, content: {
            RegisterScreen()
        })
        .fullScreenCover(isPresented: $isMainPresented){
            MainView()
        }
        .onReceive(sharePublisher(viewModel.viewActions())){ action in
            switch(action){
                case LoginAction.OpenRegistrationScreen():
                    isRegistrationPresented = true
                case LoginAction.OpenMainFlow():
                    isMainPresented = true
                default:
                    break
            }
        }
    }
}

#Preview {
    LoginScreen()
}
