//
//  RegisterScreen.swift
//  iosApp
//
//  Created by MacBook on 12.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct RegisterScreen: View {
    
    @State var isLoginPresented = false
    
    private let viewModel = RegisterViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())){ viewState in
            RegisterView(viewState: viewState){ event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }
        .sheet(isPresented: $isLoginPresented, content: {
            LoginScreen()
        })
        .onReceive(sharePublisher(viewModel.viewActions())){ action in
            switch(action){
                case RegisterAction.OpenLoginScreen():
                    isLoginPresented = true
                default:
                    break
            }
        }
    }
}

#Preview {
    RegisterScreen()
}
