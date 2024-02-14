//
//  RoomsView.swift
//  iosApp
//
//  Created by MacBook on 14.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct RoomsView: View {
    
    let viewState:RoomViewState
    let eventHandler: (RoomEvent) -> Void
    
    var body: some View {
        let _ = print(viewState)
        Text("Rooms")
    }
}


