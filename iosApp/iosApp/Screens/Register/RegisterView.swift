//
//  RegisterView.swift
//  iosApp
//
//  Created by MacBook on 12.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import SharedSDK

struct RegisterView: View {
    
    let viewState:RegisterViewState
    let eventHandler: (RegisterEvent) -> Void
    
    
    @State var login = ""
    @State var password = ""
    @State var name = ""
    
    var body: some View {
        
        VStack{
            TextField("name", text: $name)
                .onChange(of: login){value in
                    eventHandler(RegisterEvent.NameChanged(value: (name)))
                }
            
            TextField("login", text: $login)
                .onChange(of: login){value in
                    eventHandler(RegisterEvent.EmailChanged(value: (login)))
                }
            TextField("password", text: $password)
                .onChange(of: password){value in
                    eventHandler(RegisterEvent.PasswordChanged(value: (password)))
                }
            
            Button(action: {
                eventHandler(RegisterEvent.RegisterClick())
            }, label: {
                Text("send data")
            })
            
            Button(action: {
                eventHandler(RegisterEvent.LoginClick())
            }, label: {
                Text("to login")
            })
        }
        
    }
}
