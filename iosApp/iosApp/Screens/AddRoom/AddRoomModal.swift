//
//  AddRoomScreen.swift
//  iosApp
//
//  Created by MacBook on 19.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct AddRoomModal: View {
    
    let onClose:() -> Void
    private let viewModel = AddRoomViewModel()
    @State private var currentView:AddRoomAction? = nil
    
    
    
    var body: some View {
        
        let _ = print(currentView)
        
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())){ viewState in
            
            switch(currentView){
                case AddRoomAction.OpenRoomName():
                    RoomNameView(viewState: viewState){event in
                        viewModel.obtainEvent(viewEvent: event)
                    }
                case AddRoomAction.OpenSelectImage():
                    SelectImageView(viewState: viewState){event in
                        viewModel.obtainEvent(viewEvent: event)
                    }
                case AddRoomAction.OpenSelectDevices():
                    SelectDevicesView(viewState: viewState){event in
                        viewModel.obtainEvent(viewEvent: event)
                    }
                case AddRoomAction.OpenDone():
                    DoneView(viewState: viewState){event in
                        viewModel.obtainEvent(viewEvent: event)
                    }
                case AddRoomAction.OpenRoomScreen():
                    let _ = onClose()
               
                default:
                    EmptyView()
            }
            
        }
        .onReceive(sharePublisher(viewModel.viewActions())){ action in
            currentView = action
        }
    }
}

