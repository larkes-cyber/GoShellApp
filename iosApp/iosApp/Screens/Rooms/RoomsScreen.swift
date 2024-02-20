//
//  RoomsScreen.swift
//  iosApp
//
//  Created by MacBook on 14.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct RoomsScreen: View {
    
    @State var isRoomDetailPresented = false
    @State var isAddRoomPresented = false
    
    private let viewModel = RoomsViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())){ viewState in
            RoomsView(viewState: viewState){ event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }
        .sheet(isPresented: $isRoomDetailPresented, content: {
            RoomDetailScreen()
        })
        .sheet(isPresented: $isAddRoomPresented, content: {
            AddRoomModal(){
                viewModel.obtainEvent(viewEvent: RoomEvent.AddRoomClick())
                isAddRoomPresented = false
            }
            let _ = viewModel.obtainEvent(viewEvent: RoomEvent.CloseAddRoomModal())
        })
        .onReceive(sharePublisher(viewModel.viewActions())){ action in
            switch(action){
                case RoomAction.OpenRoomDetail():
                    isRoomDetailPresented = true
                case RoomAction.OpenAddRoom():
                    isAddRoomPresented = true
            default:
                break
            }
        }
        
    }
}

#Preview {
    RoomsScreen()
}
