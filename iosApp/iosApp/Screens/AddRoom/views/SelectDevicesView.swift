//
//  SelectDevicesView.swift
//  iosApp
//
//  Created by MacBook on 19.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK


struct SelectDevicesView: View {
    
    let viewState: AddRoomViewState
    let viewEvent:(AddRoomEvent) -> Void
    
    var body: some View {
        Text("Select devices")
        
        Button(action: {
            viewEvent(AddRoomEvent.ContinueClicked())
        }, label: {
            Text("continue")
        })
    }
}

