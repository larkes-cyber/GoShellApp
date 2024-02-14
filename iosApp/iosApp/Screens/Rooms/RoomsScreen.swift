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
        .onReceive(sharePublisher(viewModel.viewActions())){ action in
            switch(action){
                case RoomAction.OpenRoomDetail():
                    isRoomDetailPresented = true
            default:
                break
            }
        }
        
    }
}

#Preview {
    RoomsScreen()
}
