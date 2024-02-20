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
        
        let _ = print(viewState.rooms.count)
        
        VStack{
            HStack{
                Text("My Rooms")
                Spacer()
                Image(systemName: "plus.circle.fill").onTapGesture{
                    eventHandler(RoomEvent.AddRoomModalClick())
                }
                .frame(width: 27, height: 27)
            }
            .padding(.horizontal, 16)
            VStack{
                ForEach(viewState.rooms, id:\.self.name){value in
                    VStack{
                        Text(value.name)
                        Text(value.image)
                    }
                }
            }
        }
    }
}


