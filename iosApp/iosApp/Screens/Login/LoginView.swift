//
//  LoginView.swift
//  iosApp
//
//  Created by MacBook on 12.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct LoginView: View {
    
    let viewState:LoginViewState
    let eventHandler: (LoginEvent) -> Void
    
    @State var login = ""
    @State var password = ""
    
    var body: some View {
        VStack{
            
            TextField("login", text: $login)
                .onChange(of: login){value in
                    eventHandler(LoginEvent.EmailChanged(value: (login)))
                }
            TextField("password", text: $password)
                .onChange(of: password){value in
                    eventHandler(LoginEvent.PasswordChanged(value: (password)))
                }
            
            Button(action: {
                eventHandler(LoginEvent.LoginClick())
            }, label: {
                Text("send data")
            })
            
            Button(action: {
                eventHandler(LoginEvent.RegistrationClick())
            }, label: {
                Text("to register")
            })
        }
    }
}


