//
//  RoomNameView.swift
//  iosApp
//
//  Created by MacBook on 19.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct RoomNameView: View {
    
    let viewState: AddRoomViewState
    let viewEvent:(AddRoomEvent) -> Void
    
    @State private var text:String = ""
    
    var body: some View {
        Text("Input name")
        TextField("", text:$text)
            .onChange(of: text){value in
                viewEvent(AddRoomEvent.NameChanged(value: value))
            }
        Button(action: {
            viewEvent(AddRoomEvent.ContinueClicked())
        }, label: {
            Text("continue")
        })
    }
}

